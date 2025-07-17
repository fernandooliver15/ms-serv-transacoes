package com.serv.transacoes.entities.datas;

import java.io.Serializable;
import java.math.BigDecimal;

public class BalanceData implements Serializable {
    private BigDecimal amount;
    private String currency;

    public BalanceData() {
    }

    public BalanceData(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
