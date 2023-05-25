package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Inventario;
import com.server.bebidasGM.repository.InventarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService{

  SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

  @Autowired
  InventarioRepository inventarioRepository;

  @Override
  @Transactional
  public ArrayList<Inventario> findAll() {
    return (ArrayList<Inventario>) inventarioRepository.findAll();
  }

  @Override
  @Transactional
  public Inventario getById(Long id) {
    Optional<Inventario> inventarioOptional = inventarioRepository.findById(id);
    return inventarioOptional.get();
  }

  @Override
  @Transactional
  public Inventario save(Inventario p) {
    p = inventarioRepository.save(p);
    return p;
  }

  @Override
  @Transactional
  public Inventario update(Inventario p) throws ParseException {
    Optional<Inventario> inventarioOptional = inventarioRepository.findById(p.getId());
    Inventario inventario = inventarioOptional.get();
    inventario = inventarioRepository.save(p);
    return inventario;
  }

  @Override
  @Transactional
  public boolean delete(Long id) {
    try {
      Optional<Inventario> inventario = inventarioRepository.findById(id);
      inventarioRepository.deleteById(inventario.get().getId());
      return true;
    }catch(Exception e){
      return false;
    }
  }

}