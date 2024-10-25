package com.caixinha.api.entity;

import java.math.BigDecimal;

public interface TransactionInterface {
    public String getAccountNumber();

    public String getBankName();

    public BigDecimal getTransactionValue();

    public String getType();
}