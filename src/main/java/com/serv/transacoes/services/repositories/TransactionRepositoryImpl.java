package com.serv.transacoes.services.repositories;

import com.serv.transacoes.entities.datas.LastTransactionsData;
import com.serv.transacoes.entities.exceptions.DataBaseException;
import com.serv.transacoes.outputs.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

import static com.serv.transacoes.entities.mappers.LastTransactionMapper.INSTANCE;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private static final Logger log = LoggerFactory.getLogger(TransactionRepositoryImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public LastTransactionsData findLastTransactionBalance(UUID accountId) {

        log.info("[BD] Busca o ultimo saldo da transacao no Banco de Dados: {}", accountId);

        try {
            return INSTANCE.toData(accountRepository
                    .findLastTransactionBalance(accountId.toString()));
        } catch (Exception e) {
            log.error("[BD] Erro ao busca o ultimo saldo da transacao no Banco de Dados: {}", accountId);
            throw new DataBaseException("Problemas com o banco de dados", e);
        }
    }
}
