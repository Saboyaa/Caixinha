package com.caixinha.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caixinha.api.entity.Transaction;
import com.caixinha.api.entity.TransactionInterface;
import com.caixinha.api.service.TransactionService;

@RestController
public class TransactionController {
    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions/{transactionId}")
    public Transaction getTransactionById(@PathVariable int transactionId) {
        Transaction transaction = transactionService.findById(transactionId);

        if (transaction == null) {
            throw new RuntimeException("Transação não encontrada de id " + transactionId);
        }

        return transaction;
    }

    @GetMapping("/transactions/userId/{userId}")
    public List<TransactionInterface> getTransactionByUserId(@PathVariable int userId) {
        return transactionService.findByUserId(userId);
    }

    @PostMapping("/transactions")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        Transaction dbTransaction = transactionService.save(transaction);

        return dbTransaction;
    }

    @PutMapping("/transactions/{transactionId}")
    public Transaction updateTransaction(@RequestBody Transaction transaction, @PathVariable int transactionId) {
        Transaction tempTransaction = transactionService.findById(transactionId);

        if (tempTransaction == null) {
            throw new RuntimeException("Transação não encontrada de id " + transactionId);
        }

        Transaction dbTransaction = transactionService.update(transaction);

        return dbTransaction;
    }

    @DeleteMapping("/transactions/{transactionId}")
    public String deleteTransaction(@PathVariable int transactionId) {
        Transaction tempTransaction = transactionService.findById(transactionId);

        if (tempTransaction == null) {
            throw new RuntimeException("Transação não encontrada de id " + transactionId);
        }

        transactionService.deleteById(transactionId);

        return "Deletou transação de id " + transactionId;
    }   
}