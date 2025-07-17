package com.serv.transacoes.services.pojos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public interface LastTransactionsBalance {
    UUID getId();
    UUID getOwner();
    BigDecimal getAmount();
    String getCurrency();
    LocalDateTime getUpdatedAt();
}
