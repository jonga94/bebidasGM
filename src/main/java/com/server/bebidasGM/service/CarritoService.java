package com.server.bebidasGM.service;


import com.server.bebidasGM.model.Carrito;

import java.text.ParseException;
import java.util.ArrayList;

public interface CarritoService {
  ArrayList<Carrito> findAll();
  Carrito getById(Long id);
  Carrito save(Carrito c);
  Carrito update(Carrito c) throws ParseException;
  boolean delete(Long id);
}
