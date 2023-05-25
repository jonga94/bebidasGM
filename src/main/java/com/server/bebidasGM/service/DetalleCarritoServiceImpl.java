package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Carrito;
import com.server.bebidasGM.model.DetalleCarrito;
import com.server.bebidasGM.repository.CarritoRepository;
import com.server.bebidasGM.repository.DetalleCarritoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class DetalleCarritoServiceImpl implements DetalleCarritoService {

  @Autowired
  DetalleCarritoRepository detalleCarritoRepository;
  @Autowired
  CarritoRepository carritoRepository;

  @Override
  @Transactional
  public ArrayList<DetalleCarrito> findAll() {
    return (ArrayList<DetalleCarrito>) detalleCarritoRepository.findAll();
  }

  @Override
  @Transactional
  public DetalleCarrito getById(Long id) {
    Optional<DetalleCarrito> optionalCarrito = detalleCarritoRepository.findById(id);
    DetalleCarrito carrito = optionalCarrito.get();
    return carrito;
  }

  @Override
  @Transactional
  public DetalleCarrito save(DetalleCarrito dc) {
      dc = detalleCarritoRepository.save(dc);
    return dc;
  }

  @Override
  @Transactional
  public DetalleCarrito update(DetalleCarrito dc) throws ParseException {
    Optional<DetalleCarrito> carritoOptional = detalleCarritoRepository.findById(dc.getIdDetalleCarrito());
    DetalleCarrito carrito = carritoOptional.get();
    carrito = detalleCarritoRepository.save(dc);
    return carrito;
  }

  @Override
  @Transactional
  public boolean delete(Long id) {
    try {
      Optional<DetalleCarrito> carrito = detalleCarritoRepository.findById(id);
      detalleCarritoRepository.deleteById(carrito.get().getIdDetalleCarrito());
      return true;
    }catch(Exception e) {
      return false;
    }
  }


}
