package com.gameload.ms_carrito.controllers;

import com.gameload.ms_carrito.models.Producto;
import com.gameload.ms_carrito.repositories.ProductoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;

        //Seed
//        Producto producto1 = new Producto("1", "PlayStation", "PS0001", "PlayStation 5", 3500000, 5,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3IYE7cZOvw1hm4U05llBquYt_VW1FvTDyy8t0VLbg_vaD1axfAXjOs-R7b9J2z3QMvDjBGCw&usqp=CAc");
//        Producto producto2 = new Producto("2", "PlayStation", "PS0002", "Call Of Duty: Black Ops War", 270000, 5,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQvrKNniMJ3PPHhmebtrU-KM9bBo7sKkP8nvYPskcxDYMAxaJB5IfVRJn5O1w&usqp=CAc");
//        Producto producto3 = new Producto("3", "PlayStation", "PS0003", "Spiderman Miles Morales", 200000, 5,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBGUFZj7f06XwtexirGlpKT_NPm6mcnJZAyB9mwBWkSdoFL-FM8dhGQSnJRZkkfH2kjIxxJbw&usqp=CAc");
//        Producto producto4 = new Producto("4", "Xbox", "X0001", "Xbox Series X", 3200000, 2,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbhjds5ltBo0jvv1cHul_2Hp5DuTHIHtN4uzddNWOQID03UslO8-tndSUj3afDhsoHb-yB7W4&usqp=CAc");
//        Producto producto5 = new Producto("5", "Xbox", "X0002", "Call Of Duty: Black Ops War", 225000, 1,"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStl1AXITtU8Mh_Uzi3lUnmejMPc8NothstYg-wX4GNtDJvAOFrRrtPCnX3ATs&usqp=CAc");
//
//        this.productoRepository.save(producto1);
//        this.productoRepository.save(producto2);
//        this.productoRepository.save(producto3);
//        this.productoRepository.save(producto4);
//        this.productoRepository.save(producto5);
    }

    @GetMapping("/productos/{productoId}")
    Producto getProducto(@PathVariable String productoId) {
        return productoRepository.findById(productoId).get();
    }

    @GetMapping("/productos")
    List<Producto> getProductos() {
        List<Producto> productosDisponibles = new ArrayList<Producto>();
        List<Producto> productos = productoRepository.findAll();
        for (Producto producto:productos) {
            if (producto.getInventario() > 0) {
                productosDisponibles.add(producto);
            }
        }
        return productosDisponibles;
    }

    @GetMapping("/productos/categoria/{categoria}")
    List<Producto> getProductosCategoria(@PathVariable String categoria) {
        List<Producto> productosDisponibles = new ArrayList<Producto>();
        List<Producto> productos = productoRepository.findByCategoria(categoria);
        for (Producto producto:productos) {
            if (producto.getInventario() != 0) {
                productosDisponibles.add(producto);
            }
        }
        return productosDisponibles;
    }

}
