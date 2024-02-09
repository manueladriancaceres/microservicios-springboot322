package com.example.clientes.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MensajeDeConfig {

    @Value("${configuracion.texto}")
    private String texto;

    @GetMapping("/mensaje")
    public String getMensajeConfigCloud() {
        return texto;
    }
}
