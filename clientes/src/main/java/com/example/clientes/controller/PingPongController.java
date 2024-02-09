package com.example.clientes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPongController {

    @RequestMapping("/")
    public String saludo() {
        return "clientes";
    }


    @GetMapping("/ping")
    public String pingPong() {
        return "pong clientes";
    }
}
