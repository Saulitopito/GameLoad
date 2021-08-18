package com.gameload.ms_carrito.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class MaximoInventarioAdvice {
    @ResponseBody
    @ExceptionHandler(MaximoInventarioException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String MaximoInventarioAdvice(MaximoInventarioException ex) {
        return ex.getMessage();
    }
}
