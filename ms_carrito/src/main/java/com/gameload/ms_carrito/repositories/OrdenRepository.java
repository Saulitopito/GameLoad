package com.gameload.ms_carrito.repositories;

import com.gameload.ms_carrito.models.Orden;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrdenRepository extends MongoRepository<Orden, String> {

    List<Orden> findByUsuarioId(String usuarioID);
    List<Orden> findByCodigoOrden(String codigoOrden);
    List<Orden> findByEstadoAndUsuarioId(String estado, String usuarioId);

}
