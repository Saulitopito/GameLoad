package com.gameload.ms_carrito.repositories;

import com.gameload.ms_carrito.models.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductoRepository extends MongoRepository<Producto, String> {

    List<Producto> findByCategoria(String categoria);

}
