package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Ventas;
import com.server.bebidasGM.repository.VentasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class VentasServiceImpl implements VentasService{

  @Autowired
  VentasRepository ventasRepository;

  @Override
  @Transactional
  public ArrayList<Ventas> findAll() {
    return (ArrayList<Ventas>) ventasRepository.findAll();
  }

  @Override
  @Transactional
  public Ventas getById(Long id) {
    Optional<Ventas> ventasOptional = ventasRepository.findById(id);
    return ventasOptional.get();
  }

  @Override
  @Transactional
  public Ventas save(Ventas v) {
    v = ventasRepository.save(v);
    return v;
  }

  @Override
  @Transactional
  public Ventas update(Ventas v) throws ParseException {
    Optional<Ventas> ventasOptional = ventasRepository.findById(v.getIdVenta());
    Ventas ventas = ventasOptional.get();
    ventas = ventasRepository.save(v);
    return ventas;
  }

  @Override
  @Transactional
  public boolean delete(Long id) {
    try {
      Optional<Ventas> ventas = ventasRepository.findById(id);
      ventasRepository.deleteById(ventas.get().getIdVenta());
      return true;
    }catch(Exception e){
      return false;
    }
  }
}
