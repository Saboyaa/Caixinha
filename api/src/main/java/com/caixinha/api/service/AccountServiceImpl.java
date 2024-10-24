package com.caixinha.api.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caixinha.api.dao.AccountRepository;
import com.caixinha.api.dao.UserRepository;
import com.caixinha.api.entity.Account;
import com.caixinha.api.entity.AccountInterface;
import com.caixinha.api.entity.User;

import jakarta.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    private UserRepository userRepository;
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(UserRepository userRepository, AccountRepository accountRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public void deleteByAccountNumber(String accountNumber) {
        Optional<Account> resultAccount = accountRepository.findById(accountNumber);
        Account account = null;

        if (resultAccount.isPresent()) {
            account = resultAccount.get();
        } else {
            throw new RuntimeException("Não foi encontrada a conta com " + accountNumber);
        }

        int userId = account.getUserId();
        Optional<User> resultUser = userRepository.findById(userId);
        User user = null;

        if (resultUser.isPresent()) {
            user = resultUser.get();
        } else {
            throw new RuntimeException("Não foi encontrado o usuário com id " + userId);
        }

        user.setTotalBalance(user.getTotalBalance().subtract(account.getAccountBalance()));
        userRepository.save(user);

        accountRepository.deleteById(accountNumber);
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        Optional<Account> result = accountRepository.findById(accountNumber);
        Account account = null;

        if (result.isPresent()) {
            account = result.get();
        } else {
            throw new RuntimeException("Não foi encontrada a conta com " + accountNumber);
        }

        return account;
    }

    @Override
    public List<AccountInterface> findByUserId(int userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public Account save(Account account) {
        int userId = account.getUserId();
        Optional<User> result = userRepository.findById(userId);
        User user = null;

        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Não foi encontrado o usuário com id " + userId);
        }

        user.setTotalBalance(user.getTotalBalance().add(account.getAccountBalance()));
        userRepository.save(user);

        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public Account update(Account account) {
        int userId = account.getUserId();
        Optional<User> resultUser = userRepository.findById(userId);
        User user = null;

        if (resultUser.isPresent()) {
            user = resultUser.get();
        } else {
            throw new RuntimeException("Não foi encontrado o usuário com id " + userId);
        }

        Optional<Account> resultAccount = accountRepository.findById(account.getAccountNumber());
        Account oldAccount = null;

        if (resultAccount.isPresent()) {
            oldAccount = resultAccount.get();
        } else {
            throw new RuntimeException("Não foi encontrada a conta com " + account.getAccountNumber());
        }

        BigDecimal diff = account.getAccountBalance().subtract(oldAccount.getAccountBalance());
        user.setTotalBalance(user.getTotalBalance().add(diff));
        userRepository.save(user);

        return accountRepository.save(account);
    }
}
