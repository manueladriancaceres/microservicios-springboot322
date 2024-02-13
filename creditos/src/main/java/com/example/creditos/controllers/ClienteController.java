package com.example.creditos.controllers;

import com.example.commons.models.Cliente;
import com.example.creditos.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> findAll() {
        // return new ArrayList<Cliente>();
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{documento}")
    public Cliente getCliente(@PathVariable Integer documento) {
        return clienteService.getCliente(documento);
    }

    @PutMapping("/clientes")
    public ResponseEntity<Cliente> saveCliente(@PathVariable Integer documento, @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.updateCliente(documento,cliente));
    }

    @PostMapping("/clientes/{documento}")
    public ResponseEntity<Cliente> putCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.saveCliente(cliente));
    }

    @DeleteMapping("/clientes/{documento}")
    public ResponseEntity<String> deleteCliente(@PathVariable Integer documento) {
        return ResponseEntity.ok("Baja ok, documento " + documento);
    }

}
