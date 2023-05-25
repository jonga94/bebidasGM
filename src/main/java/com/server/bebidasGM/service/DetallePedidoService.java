package com.server.bebidasGM.service;

import com.server.bebidasGM.model.DetallePedido;

import java.text.ParseException;
import java.util.ArrayList;

public interface DetallePedidoService{
  ArrayList<DetallePedido> findAll();
  DetallePedido getById(Long id);
  DetallePedido save(DetallePedido dp);
  DetallePedido update(DetallePedido dp) throws ParseException;
  boolean delete(Long id);
}
