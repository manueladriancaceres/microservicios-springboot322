package com.example.creditos.services;

import com.example.commons.models.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente getCliente(Integer documento);

    Cliente saveCliente(Cliente cliente);
    Cliente updateCliente(Integer documento, Cliente cliente);

    Integer deleteCliente(Integer documento);
}
