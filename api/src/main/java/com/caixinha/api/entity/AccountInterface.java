package com.caixinha.api.entity;

import java.math.BigDecimal;

public interface AccountInterface {
    public String getAccountNumber();

    public String getBankName();

    public BigDecimal getAccountBalance();
}
