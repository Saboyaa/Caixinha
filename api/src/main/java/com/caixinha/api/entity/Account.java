package com.caixinha.api.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "accounts")
@Entity
public class Account {
    @Id
    @Column(nullable = false, name = "account_number")
    private String accountNumber;

    @Column(nullable = false, name = "user_id")
    private int userId;

    @Column(nullable = false, name = "bank_name")
    private String bankName;

    @Column(nullable = false, name = "account_balance")
    private BigDecimal accountBalance = new BigDecimal(0.00);

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Account [accountNumber=" + accountNumber + ", userId=" + userId + ", bankName=" + bankName
                + ", accountBalance=" + accountBalance + "]";
    }
}
