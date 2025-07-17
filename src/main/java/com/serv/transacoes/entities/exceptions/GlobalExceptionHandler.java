package com.serv.transacoes.entities.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundResultException.class)
    public ResponseEntity handleNotFound(NotFoundResultException ex) {
        return (ResponseEntity) ResponseEntity.status(HttpStatus.NO_CONTENT);
    }
}
