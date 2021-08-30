package com.gameload.ms_carrito.models;

import org.springframework.data.annotation.Id;

public class Carrito {

    @Id
    private String carrito_id;
    private String usuarioId;
    private String productoId;
    private String productoNombre;
    private int productoCantidad;
    private double productoPrecio;

    public Carrito(String carrito_id, String usuarioId, String productoId, int productoCantidad, double productoPrecio, String productoNombre) {
        this.carrito_id = carrito_id;
        this.usuarioId = usuarioId;
        this.productoId = productoId;
        this.productoCantidad = productoCantidad;
        this.productoPrecio = productoPrecio;
        this.productoNombre = productoNombre;
    }

    public Carrito(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Carrito() {

    }

    public String getCarrito_id() {
        return carrito_id;
    }

    public void setCarrito_id(String carrito_id) {
        this.carrito_id = carrito_id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getProductoId() {
        return productoId;
    }

    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }

    public int getProductoCantidad() {
        return productoCantidad;
    }

    public void setProductoCantidad(int productoCantidad) {
        this.productoCantidad = productoCantidad;
    }

    public double getProductoPrecio() {
        return productoPrecio;
    }

    public void setProductoPrecio(double productoPrecio) {
        this.productoPrecio = productoPrecio;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }
}
