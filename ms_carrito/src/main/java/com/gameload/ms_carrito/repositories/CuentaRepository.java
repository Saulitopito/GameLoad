package com.gameload.ms_carrito.repositories;

import com.gameload.ms_carrito.models.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CuentaRepository extends MongoRepository<Cuenta, String> {
}
