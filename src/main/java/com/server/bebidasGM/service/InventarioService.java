package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Inventario;


import java.util.ArrayList;
import java.util.Optional;

public interface InventarioService {
  ArrayList<Inventario> getAllInventario();
  Optional<Inventario> getInventarioById(Long id);
  Inventario saveInventario(Inventario a);
  boolean deleteInventario(Long id);

}
