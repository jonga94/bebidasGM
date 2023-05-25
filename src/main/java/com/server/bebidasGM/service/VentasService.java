package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Inventario;
import com.server.bebidasGM.model.Ventas;

import java.text.ParseException;
import java.util.ArrayList;

public interface VentasService {
  ArrayList<Ventas> findAll();
  Ventas getById(Long id);
  Ventas save(Ventas v);
  Ventas update(Ventas v) throws ParseException;
  boolean delete(Long id);
}
