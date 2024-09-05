package com.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.classes.Bank;

public interface BankRepository extends JpaRepository<Bank,Long>{

}