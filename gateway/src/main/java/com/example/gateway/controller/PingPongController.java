package com.example.gateway.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPongController {

    private final Logger logger = LoggerFactory.getLogger(PingPongController.class);

    @GetMapping("/ping")
    public String pingPong() {
        logger.info("ping");
        return "pong";
    }
}
