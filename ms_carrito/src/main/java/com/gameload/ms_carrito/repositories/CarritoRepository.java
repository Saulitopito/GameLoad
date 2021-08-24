package com.gameload.ms_carrito.repositories;

import com.gameload.ms_carrito.models.Carrito;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CarritoRepository extends MongoRepository<Carrito, String> {

    List<Carrito> findByUsuarioId(String usuarioId);
    Carrito findByUsuarioIdAndProductoId(String usuarioId, String productoId);

}
