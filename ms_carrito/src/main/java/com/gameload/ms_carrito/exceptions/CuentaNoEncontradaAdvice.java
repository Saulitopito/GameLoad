package com.gameload.ms_carrito.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CuentaNoEncontradaAdvice {
    @ResponseBody
    @ExceptionHandler(CuentaNoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String CuentaNoEncontradaAdvice(CuentaNoEncontradaException ex) {
        return ex.getMessage();
    }
}
