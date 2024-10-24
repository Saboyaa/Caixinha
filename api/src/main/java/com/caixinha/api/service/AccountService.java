package com.caixinha.api.service;

import java.util.List;

import com.caixinha.api.entity.Account;
import com.caixinha.api.entity.AccountInterface;

public interface AccountService {
    List<AccountInterface> findByUserId(int userId);
    
    Account findByAccountNumber(String accountNumber);

    Account save(Account account);

    void deleteByAccountNumber(String accountNumber);

    Account update(Account account);
}
