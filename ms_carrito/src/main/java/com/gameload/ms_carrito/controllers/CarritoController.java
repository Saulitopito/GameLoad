package com.gameload.ms_carrito.controllers;

import com.gameload.ms_carrito.exceptions.MaximoInventarioException;
import com.gameload.ms_carrito.models.Carrito;
import com.gameload.ms_carrito.models.Producto;
import com.gameload.ms_carrito.repositories.CarritoRepository;
import com.gameload.ms_carrito.repositories.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarritoController {

    private final CarritoRepository carritoRepository;
    private final ProductoRepository productoRepository;

    public CarritoController(CarritoRepository carritoRepository, ProductoRepository productoRepository) {

        this.carritoRepository = carritoRepository;
        this.productoRepository = productoRepository;
    }

    @GetMapping("/carrito/{usuarioId}")
    List<Carrito> getCarrito(@PathVariable String usuarioId) {
        List<Carrito> carritos = carritoRepository.findByUsuarioId(usuarioId);
        return carritos;
    }

    @DeleteMapping("/carrito/{usuarioId}")
    void deleteCarrito(@PathVariable String usuarioId) {
        List<Carrito> carritos = carritoRepository.findByUsuarioId(usuarioId);
        for (Carrito carrito: carritos) {
            carritoRepository.delete(carrito);
        }
    }

    @DeleteMapping("/carrito/producto/{carritoId}")
    void deleteProducto(@PathVariable String carritoId) {
        carritoRepository.deleteById(carritoId);
    }

    @PostMapping("/carrito/{usuarioId}")
    Carrito agregarProducto(@RequestBody Producto producto, @PathVariable String usuarioId) {

        Producto prod = productoRepository.findById(producto.getProducto_id()).get();
        List<Carrito> actualCarrito = carritoRepository.findByUsuarioId(usuarioId);

        if (actualCarrito.isEmpty()) {
            Carrito carrito = new Carrito(usuarioId);
            carrito.setUsuarioId(usuarioId);
            carrito.setProductoId(prod.getProducto_id());
            carrito.setProductoCantidad(1);
            carrito.setProductoPrecio(prod.getPrecio());
            return carritoRepository.save(carrito);
        }
        else {
            for (Carrito cart:actualCarrito) {
                if (prod.getInventario() <= cart.getProductoCantidad()) {
                    throw new MaximoInventarioException("No hay suficiente inventario");
                }
                if (cart.getProductoId() == prod.getProducto_id()) {
                    aumentarProducto(cart, cart.getProductoCantidad()+1);
                    return cart;
                }
            }
            Carrito carrito = new Carrito(usuarioId);
            carrito.setUsuarioId(usuarioId);
            carrito.setProductoId(prod.getProducto_id());
            carrito.setProductoCantidad(1);
            carrito.setProductoPrecio(prod.getPrecio());
            return carritoRepository.save(carrito);
        }
    }

    @PutMapping("/carrito/aumentar")
    Carrito aumentarProducto(@RequestBody Carrito carrito, int cantidad) {
        carrito.setProductoCantidad(cantidad);
        return carritoRepository.save(carrito);
    }

    @PutMapping("/carrito/disminuir")
    Carrito disminuirProducto(@RequestBody Carrito carrito) {
        Carrito carro = carritoRepository.findById(carrito.getCarrito_id()).get();
        carro.setProductoCantidad(carro.getProductoCantidad()-1);
        return carritoRepository.save(carro);
    }

}
