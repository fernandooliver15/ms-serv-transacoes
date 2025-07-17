package com.serv.transacoes.entities.mappers;

import com.serv.transacoes.entities.datas.BalanceData;
import com.serv.transacoes.entities.datas.LastTransactionsData;
import com.serv.transacoes.services.pojos.LastTransactionsBalance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LastTransactionMapper {
    LastTransactionMapper INSTANCE = Mappers.getMapper(LastTransactionMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "owner", target = "owner")
    @Mapping(source = "updatedAt", target = "updateAt")
    @Mapping(target = "balance", expression = "java(mapToBalance(source))")
    LastTransactionsData toData(LastTransactionsBalance source);

    default BalanceData mapToBalance(LastTransactionsBalance source) {
        if (source == null) return null;
        BalanceData balance = new BalanceData();
        balance.setAmount(source.getAmount());
        balance.setCurrency(source.getCurrency());
        return balance;
    }
}
