package com.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.classes.Bank;

public interface BankRepository extends JpaRepository<Bank,Long>{

    List<Bank> findByClientId(long clientId);
}