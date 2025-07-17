package com.serv.transacoes.usecases;

import com.serv.transacoes.entities.datas.BalanceData;
import com.serv.transacoes.entities.datas.LastTransactionsData;
import com.serv.transacoes.entities.exceptions.NotFoundResultException;
import com.serv.transacoes.outputs.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionUseCaseImplTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    TransactionUseCaseImpl transactionUseCase;

    @Test
    void process_success_test() {

        //Give:
        var accountId = UUID.randomUUID();

        var lastTransactionsData = getLastTransactionsData(accountId);

        when(transactionRepository.findLastTransactionBalance(accountId))
                .thenReturn(lastTransactionsData);

        //When:
        var result = transactionUseCase.process(accountId);

        //Then:
        assertNotNull(result);
        assertEquals(lastTransactionsData.getId(), result.getId());
        assertEquals(lastTransactionsData.getOwner(), result.getOwner());
        assertEquals(lastTransactionsData.getBalance().getAmount(), result.getBalance().getAmount());

    }

    @Test
    void process_exception_test() {

        //Give:
        var accountId = UUID.randomUUID();

        when(transactionRepository.findLastTransactionBalance(accountId))
                .thenReturn(null);

        //When:
        NotFoundResultException exception = assertThrows(
                NotFoundResultException.class,
                () -> transactionUseCase.process(accountId)
        );

        //Then:
        assertEquals("Não encontrado saldo", exception.getMessage());
    }

    private LastTransactionsData getLastTransactionsData(UUID accountId) {
        var balanceData = new BalanceData(
                BigDecimal.valueOf(97,00),
                "BRL"
        );

        return new LastTransactionsData(
                accountId,
                UUID.randomUUID(),
                balanceData,
                LocalDateTime.now()
        );

    }
}
