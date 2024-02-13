package com.example.clientes.controller;

import com.example.clientes.dto.request.ClienteRequestDto;
import com.example.clientes.dto.response.ClienteResponseDto;
import com.example.clientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientesController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ClienteService clienteService;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    @GetMapping("/clientes")
    public ResponseEntity<List<ClienteResponseDto>> getClientes() {
        return ResponseEntity.ok(clienteService.getClientes());
    }

    @GetMapping("/clientes/{documento}")
    public ResponseEntity<ClienteResponseDto> getCliente(@PathVariable Integer documento) {
        return ResponseEntity.ok(clienteService.getCliente(documento));
    }

    @PostMapping("/clientes")
    public ResponseEntity<ClienteRequestDto> saveCliente(@RequestBody ClienteRequestDto clienteRequestDto) {
        return ResponseEntity.ok(clienteService.saveCliente(clienteRequestDto));
    }

    @PutMapping("/clientes/{documento}")
    public ResponseEntity<ClienteRequestDto> putCliente(
            @PathVariable Integer documento, @RequestBody ClienteRequestDto clienteRequestDto) {
        return ResponseEntity.ok(clienteService.putCliente(documento,clienteRequestDto));
    }

    @DeleteMapping("/clientes/{documento}")
    public ResponseEntity<ClienteResponseDto> deleteCliente(
            @PathVariable Integer documento) {
        return ResponseEntity.ok(clienteService.deleteCliente(documento));
    }

}
