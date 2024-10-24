package com.caixinha.api.service;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caixinha.api.dao.AccountRepository;
import com.caixinha.api.dao.TransactionRepository;
import com.caixinha.api.dao.UserRepository;
import com.caixinha.api.entity.Account;
import com.caixinha.api.entity.Transaction;
import com.caixinha.api.entity.TransactionInterface;
import com.caixinha.api.entity.User;

import jakarta.transaction.Transactional;

@Service
public class TransactionServiceImpl implements TransactionService{
    private UserRepository userRepository;
    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;
    
    @Autowired
    public TransactionServiceImpl(UserRepository userRepository, AccountRepository accountRepository,
            TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionInterface> findByUserId(int userId) {
       return transactionRepository.findByUserId(userId);
    }

    @Override
    public Transaction findById(int id) {
        Optional<Transaction> result = transactionRepository.findById(id);
        Transaction transaction = null;

        if (result.isPresent()) {
            transaction = result.get();
        } else {
            throw new RuntimeException("Não foi encontrado a transação com id " + id);
        }

        return transaction;
    }

    @Override
    @Transactional
    public Transaction save(Transaction transaction) {
        int userId = transaction.getUserId();
        Optional<User> resultUser = userRepository.findById(userId);
        User user = null;

        if (resultUser.isPresent()) {
            user = resultUser.get();
        } else {
            throw new RuntimeException("Não foi encontrado o usuário com id " + userId);
        }

        String accountNumber = transaction.getAccountNumber();
        Optional<Account> resultAccount = accountRepository.findById(accountNumber);
        Account account = null;

        if (resultAccount.isPresent()) {
            account = resultAccount.get();
        } else {
            throw new RuntimeException("Não foi encontrada a conta com " + accountNumber);
        }

        user.setTotalBalance(user.getTotalBalance().add(transaction.getTransactionValue()));
        userRepository.save(user);

        account.setAccountBalance(account.getAccountBalance().add(transaction.getTransactionValue()));
        accountRepository.save(account);

        return transactionRepository.save(transaction);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Optional<Transaction> resultTransaction = transactionRepository.findById(id);
        Transaction transaction = null;

        if (resultTransaction.isPresent()) {
            transaction = resultTransaction.get();
        } else {
            throw new RuntimeException("Não foi encontrado a transação com id " + id);
        }

        int userId = transaction.getUserId();
        Optional<User> resultUser = userRepository.findById(userId);
        User user = null;

        if (resultUser.isPresent()) {
            user = resultUser.get();
        } else {
            throw new RuntimeException("Não foi encontrado o usuário com id " + userId);
        }

        String accountNumber = transaction.getAccountNumber();
        Optional<Account> resultAccount = accountRepository.findById(accountNumber);
        Account account = null;

        if (resultAccount.isPresent()) {
            account = resultAccount.get();
        } else {
            throw new RuntimeException("Não foi encontrada a conta com " + accountNumber);
        }

        user.setTotalBalance(user.getTotalBalance().subtract(transaction.getTransactionValue()));
        userRepository.save(user);

        account.setAccountBalance(account.getAccountBalance().subtract(transaction.getTransactionValue()));
        accountRepository.save(account);

        transactionRepository.deleteById(id);
    }

    @Override
    public Transaction update(Transaction transaction) {
        int userId = transaction.getUserId();
        Optional<User> resultUser = userRepository.findById(userId);
        User user = null;

        if (resultUser.isPresent()) {
            user = resultUser.get();
        } else {
            throw new RuntimeException("Não foi encontrado o usuário com id " + userId);
        }

        String accountNumber = transaction.getAccountNumber();
        Optional<Account> resultAccount = accountRepository.findById(accountNumber);
        Account account = null;

        if (resultAccount.isPresent()) {
            account = resultAccount.get();
        } else {
            throw new RuntimeException("Não foi encontrada a conta com " + accountNumber);
        }

        Optional<Transaction> resultTransaction = transactionRepository.findById(transaction.getId());
        Transaction oldTransaction = null;

        if (resultTransaction.isPresent()) {
            oldTransaction = resultTransaction.get();
        } else {
            throw new RuntimeException("Não foi encontrado a transação com id " + transaction.getId());
        }

        BigDecimal diff = transaction.getTransactionValue().subtract(oldTransaction.getTransactionValue());
        user.setTotalBalance(user.getTotalBalance().add(diff));
        userRepository.save(user);
        account.setAccountBalance(account.getAccountBalance().add(diff));
        accountRepository.save(account);

        return transactionRepository.save(transaction);
    }
}
