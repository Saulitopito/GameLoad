package com.gameload.ms_carrito.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Orden {

    @Id
    private String orden_id;
    private String codigoOrden;
    private String usuarioId;
    private Date fechaCompra;
    private String productoId;
    private String productoNombre;
    private int productoCantidad;
    private double productoPrecio;
    private String estado;

    public Orden(String orden_id, String usuarioId, Date fechaCompra, String productoId, int productoCantidad, double productoPrecio, String codigoOrden, String estado, String productoNombre) {
        this.orden_id = orden_id;
        this.codigoOrden = codigoOrden;
        this.usuarioId = usuarioId;
        this.fechaCompra = fechaCompra;
        this.productoId = productoId;
        this.productoCantidad = productoCantidad;
        this.productoPrecio = productoPrecio;
        this.estado = estado;
        this.productoNombre = productoNombre;
    }

    public Orden() {

    }

    public String getOrden_id() {
        return orden_id;
    }

    public void setOrden_id(String orden_id) {
        this.orden_id = orden_id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
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

    public String getCodigoOrden() {
        return codigoOrden;
    }

    public void setCodigoOrden(String codigoOrden) {
        this.codigoOrden = codigoOrden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }
}
