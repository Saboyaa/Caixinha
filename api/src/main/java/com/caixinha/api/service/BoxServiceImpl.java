package com.caixinha.api.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caixinha.api.dao.BoxRepository;
import com.caixinha.api.dao.UserRepository;
import com.caixinha.api.entity.Box;
import com.caixinha.api.entity.BoxInterface;
import com.caixinha.api.entity.User;

import jakarta.transaction.Transactional;

@Service
public class BoxServiceImpl implements BoxService {
    private UserRepository userRepository;
    private BoxRepository boxRepository;

    @Autowired
    public BoxServiceImpl(UserRepository userRepository, BoxRepository boxRepository) {
        this.userRepository = userRepository;
        this.boxRepository = boxRepository;
    }

    @Override
    @Transactional
    public void deleteByBoxNumber(String boxNumber) {
        Optional<Box> resultBox = boxRepository.findById(boxNumber);
        Box box = null;

        if (resultBox.isPresent()) {
            box = resultBox.get();
        } else {
            throw new RuntimeException("Não foi encontrada a conta com " + boxNumber);
        }

        int userId = box.getUserId();
        Optional<User> resultUser = userRepository.findById(userId);
        User user = null;

        if (resultUser.isPresent()) {
            user = resultUser.get();
        } else {
            throw new RuntimeException("Não foi encontrado o usuário com id " + userId);
        }

        user.setTotalBalance(user.getTotalBalance().subtract(box.getBoxBalance()));
        userRepository.save(user);

        boxRepository.deleteById(boxNumber);
    }

    @Override
    public Box findByBoxNumber(String boxNumber) {
        Optional<Box> result = boxRepository.findById(boxNumber);
        Box box = null;

        if (result.isPresent()) {
            box = result.get();
        } else {
            throw new RuntimeException("Não foi encontrada a conta com " + boxNumber);
        }

        return box;
    }

    @Override
    public List<BoxInterface> findByUserId(int userId) {
        return boxRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public Box save(Box box) {
        int userId = box.getUserId();
        Optional<User> result = userRepository.findById(userId);
        User user = null;

        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Não foi encontrado o usuário com id " + userId);
        }

        user.setTotalBalance(user.getTotalBalance().add(box.getBoxBalance()));
        userRepository.save(user);

        return boxRepository.save(box);
    }

    @Override
    @Transactional
    public Box update(Box box) {
        int userId = box.getUserId();
        Optional<User> resultUser = userRepository.findById(userId);
        User user = null;

        if (resultUser.isPresent()) {
            user = resultUser.get();
        } else {
            throw new RuntimeException("Não foi encontrado o usuário com id " + userId);
        }

        Optional<Box> resultBox = boxRepository.findById(box.getBoxNumber());
        Box oldBox = null;

        if (resultBox.isPresent()) {
            oldBox = resultBox.get();
        } else {
            throw new RuntimeException("Não foi encontrada a conta com " + box.getBoxNumber());
        }

        BigDecimal diff = box.getBoxBalance().subtract(oldBox.getBoxBalance());
        user.setTotalBalance(user.getTotalBalance().add(diff));
        userRepository.save(user);

        return boxRepository.save(box);
    }
}
