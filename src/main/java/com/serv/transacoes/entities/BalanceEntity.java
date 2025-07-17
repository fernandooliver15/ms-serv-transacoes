package com.serv.transacoes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "balance")
public class BalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(length = 10, nullable = false)
    private String currency;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false, unique = true)
    private AccountEntity account;

    public BalanceEntity() {
    }

    public BalanceEntity(Long id, BigDecimal amount, String currency, AccountEntity account) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }
}
