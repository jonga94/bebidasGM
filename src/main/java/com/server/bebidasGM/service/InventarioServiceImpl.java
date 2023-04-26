package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Inventario;
import com.server.bebidasGM.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService{

  @Autowired
  InventarioRepository inventarioRepository;

  @Override
  public ArrayList<Inventario> getAllInventario() {
    return null;
  }

  @Override
  public Optional<Inventario> getInventarioById(Long id) {
    return inventarioRepository.findById(id);
  }

  @Override
  public Inventario saveInventario(Inventario a) {
    return null;
  }

  @Override
  public boolean deleteInventario(Long id) {
    return false;
  }
}
