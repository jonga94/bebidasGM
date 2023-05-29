package com.server.bebidasGM.repository;

import com.server.bebidasGM.model.Clientes;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Clientes, Long> {

  Optional<Clientes> findOneBytelefonoCliente(String celular);
}
