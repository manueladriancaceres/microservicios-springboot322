package com.example.usuario.repository;

import com.example.commons.usuario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="usuarios",exported = true)
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    // @RestResource(path="buscar-username")
    // public Usuario findByUsername(@Param("username") String username);
    public Usuario findByUsername(String username);

    public Usuario findByUsernameAndEmail(String username, String email);

    @Query("select u from Usuario u where u.username=?1")
    public Usuario obtenerPorUserName(String username);

}
