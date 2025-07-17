package com.serv.transacoes.entities.mappers;

import com.serv.transacoes.controllers.openapi.model.BalanceTransactionsResponse;
import com.serv.transacoes.controllers.openapi.model.BalanceTransactionsResponseBalance;
import com.serv.transacoes.entities.datas.BalanceData;
import com.serv.transacoes.entities.datas.LastTransactionsData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Mapper
public interface BalanceTransactionsMapper {

    BalanceTransactionsMapper RESULTMAP = Mappers.getMapper(BalanceTransactionsMapper.class);

    @Mapping(source = "updateAt", target = "updatedAt")
    @Mapping(target = "balance", expression = "java(mapToBalance(source.getBalance()))")
    BalanceTransactionsResponse toResponse(LastTransactionsData source);

    default BalanceTransactionsResponseBalance mapToBalance(BalanceData balanceData) {
        if (balanceData == null) return null;
        BalanceTransactionsResponseBalance balance = new BalanceTransactionsResponseBalance();
        balance.setAmount(balanceData.getAmount());
        balance.setCurrency(balanceData.getCurrency());
        return balance;
    }

    default OffsetDateTime toOffsetDateTime(LocalDateTime localDateTime) {
        return localDateTime != null ? localDateTime.atOffset(ZoneOffset.of("-03:00")) : null;
    }
}
