package com.example.commons.usuario.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 20)
    private String username;
    @Column(length = 60)
    private String password;
    private Boolean enable;

    private String nombre;

    private String apellido;


    @Column(unique=true,length = 100)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Rol> roles;

    public Usuario(Long id, String username, String password, Boolean enable, String apellido, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enable = enable;
        this.apellido = apellido;
        this.email = email;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
