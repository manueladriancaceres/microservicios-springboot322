package com.example.creditos.services;

import com.example.commons.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes =
                Arrays.asList(restTemplate.getForObject("http://localhost:8003/clientes",Cliente[].class));
        return clientes;
    }

    @Override
    public Cliente getCliente(Integer documento) {
        return restTemplate.getForObject("http://localhost:8003/clientes/"+documento,Cliente.class);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        HttpEntity<Cliente> body = new HttpEntity<Cliente>(cliente);
        ResponseEntity<Cliente> response = restTemplate.exchange("http://localhost:8003/clientes", HttpMethod.POST,body,Cliente.class);
        Cliente clienteResponse = response.getBody();
        return clienteResponse;
    }

    @Override
    public Cliente updateCliente(Integer documento, Cliente cliente) {
        Map<String,String> pathVariables = new HashMap<>();
        pathVariables.put("documento", documento.toString());

        HttpEntity<Cliente> body = new HttpEntity<Cliente>(cliente);
        ResponseEntity<Cliente> response = restTemplate.exchange("http://localhost:8003/clientes/{documento}",
                HttpMethod.PUT,body,Cliente.class, pathVariables);
        Cliente clienteResponse = response.getBody();
        return clienteResponse;
    }

    @Override
    public Integer deleteCliente(Integer documento) {
        Map<String,String> pathVariables = new HashMap<>();
        pathVariables.put("documento", documento.toString());
        restTemplate.delete("http://localhost:8003/clientes/{documento}", pathVariables);
        return documento;
    }


}
