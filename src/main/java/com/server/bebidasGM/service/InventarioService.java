package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Inventario;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

public interface InventarioService {
  ArrayList<Inventario> findAll();
  Inventario getById(Long id);
  Inventario save(Inventario p);
  Inventario update(Inventario p) throws ParseException;
  boolean delete(Long id);

}
