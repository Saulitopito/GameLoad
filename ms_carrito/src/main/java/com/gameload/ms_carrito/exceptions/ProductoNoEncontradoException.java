package com.gameload.ms_carrito.exceptions;

public class ProductoNoEncontradoException extends RuntimeException{
    public ProductoNoEncontradoException(String message){
        super(message);
    }
}
