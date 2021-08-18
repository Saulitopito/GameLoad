package com.gameload.ms_carrito.models;

import org.springframework.data.annotation.Id;

public class Producto {

    @Id
    private String producto_id;
    private String categoria;
    private String codigo;
    private String nombre;
    private double precio;
    private int inventario;
    private String imagen;

    public Producto(String producto_id, String categoria, String codigo, String nombre, double precio, int inventario, String imagen) {
        this.producto_id = producto_id;
        this.categoria = categoria;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.inventario = inventario;
        this.imagen = imagen;
    }

    public String getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(String producto_id) {
        this.producto_id = producto_id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
