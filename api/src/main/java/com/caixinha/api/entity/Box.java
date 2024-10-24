package com.caixinha.api.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "boxs")
@Entity
public class Box {
    @Id
    @Column(nullable = false, name = "box_number")
    private String boxNumber;

    @Column(nullable = false, name = "user_id")
    private int userId;

    @Column(nullable = false, name = "bank_name")
    private String bankName;

    @Column(nullable = false, name = "box_balance")
    private BigDecimal boxBalance = new BigDecimal(0.00);

    public String getBoxNumber() {
        return boxNumber;
    }

    public void setBoxNumber(String boxNumber) {
        this.boxNumber = boxNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BigDecimal getBoxBalance() {
        return boxBalance;
    }

    public void setBoxBalance(BigDecimal boxBalance) {
        this.boxBalance = boxBalance;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Box [boxNumber=" + boxNumber + ", userId=" + userId + ", bankName=" + bankName
                + ", boxBalance=" + boxBalance + "]";
    }
}
