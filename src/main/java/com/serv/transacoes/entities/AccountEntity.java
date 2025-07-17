package com.serv.transacoes.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @Column(length = 36)
    private String id;

    @Column(length = 36, nullable = false)
    private String owner;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(length = 20)
    private String status;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private BalanceEntity balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransactionEntity> transactions = new ArrayList<>();

    public AccountEntity() {
    }

    public AccountEntity(String id, String owner, LocalDateTime createdAt, String status, BalanceEntity balance, List<TransactionEntity> transactions) {
        this.id = id;
        this.owner = owner;
        this.createdAt = createdAt;
        this.status = status;
        this.balance = balance;
        this.transactions = transactions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BalanceEntity getBalance() {
        return balance;
    }

    public void setBalance(BalanceEntity balance) {
        this.balance = balance;
    }

    public List<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }
}
