package com.gameload.ms_carrito.controllers;

import com.gameload.ms_carrito.models.Carrito;
import com.gameload.ms_carrito.models.Orden;
import com.gameload.ms_carrito.models.Producto;
import com.gameload.ms_carrito.repositories.CarritoRepository;
import com.gameload.ms_carrito.repositories.OrdenRepository;
import com.gameload.ms_carrito.repositories.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OrdenController {

    private final OrdenRepository ordenRepository;
    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;

    public OrdenController(OrdenRepository ordenRepository, CarritoRepository carritoRepository, ProductoRepository productoRepository) {
        this.ordenRepository = ordenRepository;
        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
    }

    @PostMapping("/orden/{usuarioId}")
    List<Orden> postOrden(@PathVariable String usuarioId){
        List<Carrito> productos = carritoRepository.findByUsuarioId(usuarioId);
        List<Orden> orden = new ArrayList<Orden>();
        Date fecha = new Date();
        String cons = LocalDate.now().toString();

        for (Carrito producto:productos) {
            Orden elemento = new Orden();
            elemento.setCodigoOrden(usuarioId+"ORD"+cons);
            elemento.setUsuarioId(usuarioId);
            elemento.setProductoId(producto.getProductoId());
            elemento.setProductoCantidad(producto.getProductoCantidad());
            elemento.setProductoPrecio(elemento.getProductoCantidad()*producto.getProductoPrecio());
            elemento.setFechaCompra(fecha);
            orden.add(elemento);
            ordenRepository.save(elemento);
        }

        List<Carrito> carritos = carritoRepository.findByUsuarioId(usuarioId);
        for (Carrito carrito: carritos) {
            carritoRepository.delete(carrito);
        }

        return orden;
    }

    @DeleteMapping("/orden/{codigoOrden}")
    void deleteOrden(@PathVariable String codigoOrden) {
        List<Orden> ordenes = ordenRepository.findByCodigoOrden(codigoOrden);
        for (Orden orden: ordenes) {
            ordenRepository.delete(orden);
        }
    }

    @GetMapping("/ordenes/{usuarioId}")
    List<Orden> getOrdenes(@PathVariable String usuarioId) {
        List<Orden> ordenes = ordenRepository.findByUsuarioId(usuarioId);
        return ordenes;
    }

    @GetMapping("/orden/{codigoOrden}")
    List<Orden> getOrden(@PathVariable String codigoOrden) {
        return ordenRepository.findByCodigoOrden(codigoOrden);
    }

    @GetMapping("/orden/total/{codigoOrden}")
    double valorTotal(@PathVariable String codigoOrden) {
        double total = 0;
        List<Orden> ordenes = ordenRepository.findByCodigoOrden(codigoOrden);
        for (Orden orden:ordenes) {
            total = total + orden.getProductoPrecio();
        }
        return total;
    }

    @PutMapping("/orden/confirmar/{codigoOrden}")
    void confirmarOrden(@PathVariable String codigoOrden) {
        List<Orden> ordenes = getOrden(codigoOrden);
        for (Orden orden:ordenes) {
            Producto producto = productoRepository.findById(orden.getProductoId()).get();
            producto.setInventario(producto.getInventario()-orden.getProductoCantidad());
            productoRepository.save(producto);
        }
    }
}
