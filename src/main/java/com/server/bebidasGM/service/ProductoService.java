package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Producto;

import java.util.ArrayList;


public interface ProductoService{
  ArrayList<Producto> getAll();
  Producto getById(Long id);
  Producto save(Producto p);
  Producto update(Producto p);
  boolean delete(Long id);

}
