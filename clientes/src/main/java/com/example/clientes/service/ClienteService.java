package com.example.clientes.service;

import com.example.clientes.dto.request.ClienteRequestDto;
import com.example.clientes.dto.response.ClienteResponseDto;
import com.example.clientes.repository.ClienteRepository;
import com.example.commons.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteRequestDto saveCliente(ClienteRequestDto clienteRequestDto) {
        clienteRepository.save(new Cliente(clienteRequestDto.getDocumento(),clienteRequestDto.getNombre(),clienteRequestDto.getApellido()));
        return clienteRequestDto;
    }


    public ClienteResponseDto getCliente(Integer documento) {
        Cliente cliente = clienteRepository.findByDocumento(documento).orElse(null);
        // ver de lanzar una exepcion
        if(cliente==null) {
            return null;
        } else {
            return new ClienteResponseDto(cliente.getDocumento(),cliente.getNombre(),cliente.getApellido());
        }
    }


    public List<ClienteResponseDto> getClientes() {

        return clienteRepository.findAll().stream().map(
                c -> new ClienteResponseDto(c.getDocumento(),c.getNombre(),c.getApellido())
        ).collect(Collectors.toList());

        /*
        return clienteRepository.getClientes().stream().map(
          c -> new ClienteResponseDto(c.getDocumento(),c.getNombre(),c.getApellido())
        ).collect(Collectors.toList());
        */
    }

    public ClienteRequestDto putCliente(Integer documento, ClienteRequestDto clienteRequestDto) {
        Cliente cliente = clienteRepository.findByDocumento(documento).orElse(null);
        // ver de lanzar una exepcion
        if(cliente==null) {
            return null;
        }
        cliente.setApellido(clienteRequestDto.getApellido());
        cliente.setNombre(clienteRequestDto.getNombre());
        clienteRepository.save(cliente);
        return clienteRequestDto;
    }

    public ClienteResponseDto deleteCliente(Integer documento) {
        Cliente cliente = clienteRepository.findByDocumento(documento).orElse(null);
        // ver de lanzar una exepcion
        if(cliente==null) {
            return null;
        }
        ClienteResponseDto clienteResponseDto = new ClienteResponseDto(cliente.getDocumento(),cliente.getNombre(),cliente.getApellido());
        clienteRepository.deleteInClientesByDocumento(documento);
        return clienteResponseDto;
    }
}
