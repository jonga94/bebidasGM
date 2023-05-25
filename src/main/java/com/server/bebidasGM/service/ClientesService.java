package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Clientes;

import java.util.ArrayList;

public interface ClientesService {
  ArrayList<Clientes> getAll();
  Clientes getById(Long id);
  Clientes save(Clientes c);
  Clientes update(Clientes c);
  boolean delete(Long id);
}
