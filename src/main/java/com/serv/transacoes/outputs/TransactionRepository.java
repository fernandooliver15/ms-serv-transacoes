package com.serv.transacoes.outputs;

import com.serv.transacoes.entities.datas.LastTransactionsData;

import java.util.UUID;

public interface TransactionRepository {
    LastTransactionsData findLastTransactionBalance(UUID accountId);
}
