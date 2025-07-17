package com.serv.transacoes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class TransactionEntity {

    @Id
    @Column(length = 36)
    private String id;

    @Column(length = 20)
    private String type;

    @Column(precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(length = 10)
    private String currency;

    @Column(length = 20)
    private String status;

    @Column
    private LocalDateTime timestamp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "account_id", nullable = false)
    private AccountEntity account;

    public TransactionEntity() {
    }

    public TransactionEntity(String id, String type, BigDecimal amount, String currency, String status, LocalDateTime timestamp, AccountEntity account) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.currency = currency;
        this.status = status;
        this.timestamp = timestamp;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }
}
