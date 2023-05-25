package com.server.bebidasGM.service;

import com.server.bebidasGM.model.DetalleCarrito;

import java.text.ParseException;
import java.util.ArrayList;

public interface DetalleCarritoService {
  ArrayList<DetalleCarrito> findAll();
  DetalleCarrito getById(Long id);
  DetalleCarrito save(DetalleCarrito dc);
  DetalleCarrito update(DetalleCarrito dc) throws ParseException;
  boolean delete(Long id);
}
