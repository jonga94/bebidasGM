package com.server.bebidasGM.service;


import com.server.bebidasGM.model.Pedidos;

import java.text.ParseException;
import java.util.ArrayList;

public interface PedidosService {
  ArrayList<Pedidos> findAll();
  Pedidos getById(Long id);
  Pedidos save(Pedidos p);
  Pedidos update(Pedidos p) throws ParseException;
  boolean delete(Long id);
}
