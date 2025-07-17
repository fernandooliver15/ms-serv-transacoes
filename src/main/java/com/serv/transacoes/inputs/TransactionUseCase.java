package com.serv.transacoes.inputs;

import com.serv.transacoes.controllers.openapi.model.BalanceTransactionsResponse;

import java.util.UUID;

public interface TransactionUseCase {
    BalanceTransactionsResponse process(UUID accountIdentifier);
}
