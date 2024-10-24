package com.caixinha.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caixinha.api.entity.Account;
import com.caixinha.api.entity.AccountInterface;
import com.caixinha.api.service.AccountService;

@RestController
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts/{accountNumber}")
    public Account getAccountById(@PathVariable String accountNumber) {
        Account account = accountService.findByAccountNumber(accountNumber);

        if (accountNumber == null) {
            throw new RuntimeException("Conta não encontrada de numéro " + accountNumber);
        }

        return account;
    }

    @GetMapping("/accounts/userId/{userId}")
    public List<AccountInterface> getAccountByUserId(@PathVariable int userId) {
        return accountService.findByUserId(userId);
    }

    @PostMapping("/accounts")
    public Account addAccount(@RequestBody Account account) {
        Account dbAccount = accountService.save(account);

        return dbAccount;
    }

    @PutMapping("/accounts/{accountNumber}")
    public Account updateAccount(@RequestBody Account account, @RequestParam String accountNumber) {
        Account tempAccount = accountService.findByAccountNumber(accountNumber);

        if (tempAccount == null) {
            throw new RuntimeException("Conta não encontrada de numéro " + accountNumber);
        }

        Account dbAccount = accountService.update(account);

        return dbAccount;
    }

    @DeleteMapping("/accounts/{accountNumber}") 
    public String deleteAccount(@PathVariable String accountNumber) {
        Account tempAccount = accountService.findByAccountNumber(accountNumber);

        if (tempAccount == null) {
            throw new RuntimeException("Conta não encontrada de numéro " + accountNumber);
        }

        accountService.deleteByAccountNumber(accountNumber);

        return "Deletou conta de número " + accountNumber;
    }
}
