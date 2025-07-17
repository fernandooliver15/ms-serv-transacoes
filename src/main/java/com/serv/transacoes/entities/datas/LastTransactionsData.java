package com.serv.transacoes.entities.datas;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;


public class LastTransactionsData implements Serializable {
    private UUID id;
    private UUID owner;
    private BalanceData balance;
    private LocalDateTime updateAt;

    public LastTransactionsData() {
    }

    public LastTransactionsData(UUID id, UUID owner, BalanceData balance, LocalDateTime updateAt) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        this.updateAt = updateAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public BalanceData getBalance() {
        return balance;
    }

    public void setBalance(BalanceData balance) {
        this.balance = balance;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }
}
