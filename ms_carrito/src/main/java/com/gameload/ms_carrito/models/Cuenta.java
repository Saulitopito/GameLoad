package com.gameload.ms_carrito.models;

import org.springframework.data.annotation.Id;

public class Cuenta {

    @Id
    private String usuarioId;

    public Cuenta(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}
