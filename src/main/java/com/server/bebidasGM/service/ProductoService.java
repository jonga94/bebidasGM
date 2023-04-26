package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.Optional;


public interface ProductoService{
  ArrayList<Producto> getAllProducto();
  Optional<Producto> getProductoById(Long id);
  Producto saveProducto(Producto a);
  boolean deleteProducto(Long id);


}
