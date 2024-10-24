package com.caixinha.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caixinha.api.entity.Account;
import com.caixinha.api.entity.AccountInterface;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<AccountInterface> findByUserId(int userId);
}
