package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Inventario;
import com.server.bebidasGM.model.Pedidos;
import com.server.bebidasGM.repository.PedidosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class PedidosServiceImpl implements PedidosService{

  @Autowired
  PedidosRepository pedidosRepository;

  @Override
  @Transactional
  public ArrayList<Pedidos> findAll() {
    return (ArrayList<Pedidos>) pedidosRepository.findAll();
  }

  @Override
  @Transactional
  public Pedidos getById(Long id) {
    Optional<Pedidos> pedidosOptional = pedidosRepository.findById(id);
    return pedidosOptional.get();
  }

  @Override
  @Transactional
  public Pedidos save(Pedidos p) {
    p = pedidosRepository.save(p);
    return p;
  }

  @Override
  @Transactional
  public Pedidos update(Pedidos p) throws ParseException {
    Optional<Pedidos> pedidosOptional = pedidosRepository.findById(p.getIdPedido());
    Pedidos pedido = pedidosOptional.get();
    pedido = pedidosRepository.save(p);
    return pedido;
  }

  @Override
  @Transactional
  public boolean delete(Long id) {
    try {
      Optional<Pedidos> pedidos = pedidosRepository.findById(id);
      pedidosRepository.deleteById(pedidos.get().getIdPedido());
      return true;
    }catch(Exception e){
      return false;
    }
  }
}
