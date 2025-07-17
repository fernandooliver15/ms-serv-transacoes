package com.serv.transacoes.entities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class NotFoundResultException extends RuntimeException {
    public NotFoundResultException(String message) {
        super(message);
    }
}
