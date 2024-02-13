package com.example.clientes.repository;

import com.example.commons.models.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepositoryImpl {

    List<Cliente> clientes = new ArrayList<>();

    public ClienteRepositoryImpl() {
        clientes.add(new Cliente(123,"Carlos","Gomez"));
        clientes.add(new Cliente(123,"Juana","Fernandez"));
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

}
