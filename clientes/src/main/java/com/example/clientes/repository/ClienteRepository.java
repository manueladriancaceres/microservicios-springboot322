package com.example.clientes.repository;


import com.example.commons.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    Optional<Cliente> findByDocumento(Integer documento);

    @Modifying
    // @Query("delete c from Cliente c where u.documento= ?1") revisar
    @Query(value = "delete from clientes where documento = ?1", nativeQuery = true)
    void deleteInClientesByDocumento(Integer documento);


}
