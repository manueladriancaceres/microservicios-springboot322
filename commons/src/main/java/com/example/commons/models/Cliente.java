package com.example.commons.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "clientes")
public class Cliente {

    @Id
    private Integer documento;
    private String nombre;
    private String apellido;

    public Cliente() {

    }
    public Cliente(Integer documento, String nombre, String apellido) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
