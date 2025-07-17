package com.serv.transacoes.entities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
public class DataBaseException extends RuntimeException {
    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
