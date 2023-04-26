package com.server.bebidasGM.repository;

import com.server.bebidasGM.model.Inventario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends CrudRepository<Inventario, Long> {
}
