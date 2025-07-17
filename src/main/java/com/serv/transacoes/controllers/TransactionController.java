package com.serv.transacoes.controllers;

import com.serv.transacoes.controllers.openapi.api.TransactionsApi;
import com.serv.transacoes.controllers.openapi.model.BalanceTransactionsResponse;
import com.serv.transacoes.controllers.openapi.model.TransationsProcessedRequest;
import com.serv.transacoes.inputs.TransactionUseCase;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TransactionController implements TransactionsApi {

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    private TransactionUseCase transactionUseCase;

    public TransactionController(TransactionUseCase transactionUseCase) {
        this.transactionUseCase = transactionUseCase;
    }

    @Override
    public ResponseEntity<BalanceTransactionsResponse> transationsProcessed(
            @Parameter(name = "TransationsProcessedRequest", description = "", required = true)
            @Valid @RequestBody TransationsProcessedRequest transationsProcessedRequest
    ) {

        log.info("[Inicio] Request LastTransaction: {}",
                transationsProcessedRequest.getAccountIdentifier());

        var response = transactionUseCase
                .process(transationsProcessedRequest
                        .getAccountIdentifier());

        log.info("[Fim] Request LastTransaction: {}",
                transationsProcessedRequest.getAccountIdentifier());

        return ResponseEntity.ok(response);
    }
}
