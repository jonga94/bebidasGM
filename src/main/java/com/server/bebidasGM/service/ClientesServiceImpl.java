package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Clientes;
import com.server.bebidasGM.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClientesServiceImpl implements ClientesService{

  @Autowired
  ClienteRepository clienteRepository;

  @Override
  @Transactional
  public ArrayList<Clientes> getAll() {
    return (ArrayList<Clientes>) clienteRepository.findAll();
  }

  @Override
  @Transactional
  public Clientes getById(Long id) {
    Optional<Clientes> optionalClientes = clienteRepository.findById(id);
    Clientes cliente = optionalClientes.get();
    return cliente;
  }

  @Override
  @Transactional
  public Clientes save(Clientes c) {
    return clienteRepository.save(c);
  }

  @Override
  @Transactional
  public Clientes update(Clientes c) {
    Optional<Clientes> optionalClientes = clienteRepository.findById(c.getIdCliente());
    Clientes cliente = optionalClientes.get();
    cliente = clienteRepository.save(c);
    return cliente;
  }

  @Override
  @Transactional
  public boolean delete(Long id) {
    try {
     Optional<Clientes> optionalClientes = clienteRepository.findById(id);
     clienteRepository.delete(optionalClientes.get());
     return true;
    }catch (Exception e) {
      return false;
    }
  }

}
