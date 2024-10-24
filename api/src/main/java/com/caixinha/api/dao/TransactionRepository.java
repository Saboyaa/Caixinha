package com.caixinha.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caixinha.api.entity.Transaction;
import com.caixinha.api.entity.TransactionInterface;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<TransactionInterface> findByUserId(int userId);
}
