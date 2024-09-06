package com.repos;

import com.classes.Transactions;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions,Long>{

    List<Transactions> findByClientId(Long clientId);
}