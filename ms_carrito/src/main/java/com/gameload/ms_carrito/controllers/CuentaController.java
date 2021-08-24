package com.gameload.ms_carrito.controllers;

import com.gameload.ms_carrito.exceptions.CuentaNoEncontradaException;
import com.gameload.ms_carrito.models.Cuenta;
import com.gameload.ms_carrito.repositories.CuentaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CuentaController {

    private final CuentaRepository cuentaRepository;

    public CuentaController(CuentaRepository cuentaRepository) {
        this.cuentaRepository = cuentaRepository;

        //Seed
//        Cuenta cuenta1 = new Cuenta("1");
//        Cuenta cuenta2 = new Cuenta("2");
//
//        cuentaRepository.save(cuenta1);
//        cuentaRepository.save(cuenta2);
    }

    @PostMapping("/cuentas/{cuentaId}")
    Cuenta postCuenta(@PathVariable String cuentaId) {
        Cuenta cuenta = new Cuenta(cuentaId);
        return cuentaRepository.save(cuenta);
    }

    @GetMapping("/cuentas/{usuarioId}")
    Cuenta getCuenta(@PathVariable String usuarioId) {
        return cuentaRepository.findById(usuarioId).orElseThrow(() -> new CuentaNoEncontradaException("No se encontró una cuenta con el usuario "+ usuarioId));
    }

}
