package com.gameload.ms_carrito.controllers;

import com.gameload.ms_carrito.models.Carrito;
import com.gameload.ms_carrito.models.Orden;
import com.gameload.ms_carrito.models.Producto;
import com.gameload.ms_carrito.repositories.CarritoRepository;
import com.gameload.ms_carrito.repositories.OrdenRepository;
import com.gameload.ms_carrito.repositories.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
        String cons = LocalDateTime.now().toString();

        List<Orden> ordenActual = ordenRepository.findByEstadoAndUsuarioId("Pendiente", usuarioId);

//        List<Orden> ordenActual = new ArrayList<Orden>();
//        for (Orden ordenAct:ordenRepository.findByUsuarioId(usuarioId)) {
//            if (ordenAct.getEstado() == "Pendiente") {
//                ordenActual.add(ordenAct);
//            }
//        }

        if (ordenActual.isEmpty()) {
            for (Carrito producto:productos) {
                Orden elemento = new Orden();
                elemento.setCodigoOrden(usuarioId+"ORD"+cons);
                elemento.setUsuarioId(usuarioId);
                elemento.setProductoId(producto.getProductoId());
                elemento.setProductoNombre(producto.getProductoNombre());
                elemento.setProductoCantidad(producto.getProductoCantidad());
                elemento.setProductoPrecio(elemento.getProductoCantidad()*producto.getProductoPrecio());
                elemento.setFechaCompra(fecha);
                elemento.setEstado("Pendiente");
                orden.add(elemento);
                ordenRepository.save(elemento);
            }
        }
        else {
            deleteOrden(ordenActual.get(0).getCodigoOrden());

            for (Carrito producto:productos) {
            Orden elemento = new Orden();
            elemento.setCodigoOrden(usuarioId+"ORD"+cons);
            elemento.setUsuarioId(usuarioId);
            elemento.setProductoId(producto.getProductoId());
            elemento.setProductoNombre(producto.getProductoNombre());
            elemento.setProductoCantidad(producto.getProductoCantidad());
            elemento.setProductoPrecio(elemento.getProductoCantidad()*producto.getProductoPrecio());
            elemento.setFechaCompra(fecha);
            elemento.setEstado("Pendiente");
            orden.add(elemento);
            ordenRepository.save(elemento);
            }
        }
        return orden;
    }

    @DeleteMapping("/orden/{usuarioId}/{codigoOrden}")
    void deleteOrden(@PathVariable String codigoOrden) {
        List<Orden> ordenes = ordenRepository.findByCodigoOrden(codigoOrden);
        for (Orden orden: ordenes) {
            ordenRepository.delete(orden);
        }
    }

    @GetMapping("/ordenes/{usuarioId}")
    List<Orden> getOrdenes(@PathVariable String usuarioId) {
        List<Orden> ordenes = ordenRepository.findByEstadoAndUsuarioId("Pendiente", usuarioId);
        return ordenes;
    }

    @GetMapping("/orden/{usuarioId}/{codigoOrden}")
    List<Orden> getOrden(@PathVariable String codigoOrden) {
        return ordenRepository.findByCodigoOrden(codigoOrden);
    }

    @GetMapping("/orden/total/{usuarioId}/{codigoOrden}")
    double valorTotal(@PathVariable String codigoOrden) {
        double total = 0;
        List<Orden> ordenes = ordenRepository.findByCodigoOrden(codigoOrden);
        for (Orden orden:ordenes) {
            total = total + orden.getProductoPrecio();
        }
        return total;
    }

    @PutMapping("/orden/confirmar/{usuarioId}/{codigoOrden}")
    void confirmarOrden(@PathVariable String codigoOrden) {
        List<Orden> ordenes = getOrden(codigoOrden);
        for (Orden orden:ordenes) {
            Producto producto = productoRepository.findById(orden.getProductoId()).get();
            producto.setInventario(producto.getInventario()-orden.getProductoCantidad());
            productoRepository.save(producto);
        }

        List<Orden> ordenLista = ordenRepository.findByCodigoOrden(codigoOrden);

        for (Orden orden:ordenLista) {
            orden.setEstado("Confirmada");
            ordenRepository.save(orden);
        }

        String usuarioId = ordenes.get(0).getUsuarioId();

        List<Carrito> carritos = carritoRepository.findByUsuarioId(usuarioId);
        for (Carrito carrito: carritos) {
            carritoRepository.delete(carrito);
        }
    }
}
