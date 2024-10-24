package com.caixinha.api.service;

import java.util.List;

import com.caixinha.api.entity.Transaction;
import com.caixinha.api.entity.TransactionInterface;

public interface TransactionService {
    List<TransactionInterface> findByUserId(int userId);

    Transaction findById(int id);

    Transaction save(Transaction transaction);

    Transaction update(Transaction transaction);

    void deleteById(int id);
}
