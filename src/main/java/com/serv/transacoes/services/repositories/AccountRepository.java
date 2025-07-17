package com.serv.transacoes.services.repositories;

import com.serv.transacoes.entities.AccountEntity;
import com.serv.transacoes.services.pojos.LastTransactionsBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {

    String QUERY_TRANSATION_BALANCE = "" +
            "SELECT a.id, " +
            "       a.owner, " +
            "       b.amount, " +
            "       b.currency, " +
            "       t.`timestamp` as updatedAt " +
            " FROM transaction t " +
            "  LEFT JOIN account a " +
            "         ON a.id = t.account_id " +
            "  LEFT JOIN balance b " +
            "         ON b.account_id = t.account_id " +
            "WHERE a.id = :accountId " +
            "ORDER BY t.timestamp DESC LIMIT 1;";

    @Query(value = QUERY_TRANSATION_BALANCE, nativeQuery = true)
    LastTransactionsBalance findLastTransactionBalance(@Param("accountId") String accountId);
}