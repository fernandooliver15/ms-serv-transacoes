package com.serv.transacoes.usecases;

import com.serv.transacoes.controllers.openapi.model.BalanceTransactionsResponse;
import com.serv.transacoes.entities.exceptions.NotFoundResultException;
import com.serv.transacoes.inputs.TransactionUseCase;
import com.serv.transacoes.outputs.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.serv.transacoes.entities.mappers.BalanceTransactionsMapper.RESULTMAP;

@Component
public class TransactionUseCaseImpl implements TransactionUseCase {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public BalanceTransactionsResponse process(UUID accountIdentifier) {

        var balanceTransactionsResult = transactionRepository
                .findLastTransactionBalance(accountIdentifier);

        if (balanceTransactionsResult == null)
            throw new NotFoundResultException("Não encontrado saldo");

        return RESULTMAP.toResponse(balanceTransactionsResult);
    }
}
