package com.server.bebidasGM.service;

import com.server.bebidasGM.model.DetallePedido;
import com.server.bebidasGM.model.Inventario;
import com.server.bebidasGM.repository.DetallePedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService{

  @Autowired
  DetallePedidoRepository detallePedidoRepository;

  @Override
  @Transactional
  public ArrayList<DetallePedido> findAll() {
    System.out.println("Entrando a detallePedido");
    ArrayList<DetallePedido> lista = (ArrayList<DetallePedido>) detallePedidoRepository.findAll();
    for (DetallePedido detalle: lista) {
        Long idProducto = detalle.getIdProducto();
        if (idProducto == null){
          idProducto = 0L;
        }
    }
    return lista;
  }

  @Override
  @Transactional
  public DetallePedido getById(Long id) {
    Optional<DetallePedido> detallePedidoOptional = detallePedidoRepository.findById(id);
    return detallePedidoOptional.get();

  }

  @Override
  @Transactional
  public DetallePedido save(DetallePedido dp) {
    dp = detallePedidoRepository.save(dp);
    return dp;
  }

  @Override
  @Transactional
  public DetallePedido update(DetallePedido dp) throws ParseException {
    Optional<DetallePedido> detallePedidoOptional = detallePedidoRepository.findById(dp.getIdDetalle());
    DetallePedido detallePedido = detallePedidoOptional.get();
    detallePedido = detallePedidoRepository.save(dp);
    return detallePedido;
  }

  @Override
  @Transactional
  public boolean delete(Long id) {
    try {
      Optional<DetallePedido> detallePedidoOptional = detallePedidoRepository.findById(id);
      detallePedidoRepository.delete(detallePedidoOptional.get());
      return true;
    }catch(Exception e){
      return false;
    }
  }
}
