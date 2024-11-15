package com.example.exerciciolabprog2;

import java.math.BigDecimal;

public class Account {
    private String accountNumber;
    private String bankName;
    private BigDecimal accountBalance;

    public Account(String accountNumber, String bankName, BigDecimal accountBalance) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }
}

