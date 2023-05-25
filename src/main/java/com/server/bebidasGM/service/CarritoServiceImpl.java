package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Carrito;
import com.server.bebidasGM.repository.CarritoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService{
    
  @Autowired
  CarritoRepository  carritoRepository;

  @Override
  @Transactional
  public ArrayList<Carrito> findAll() {
    return (ArrayList<Carrito>) carritoRepository.findAll();
  }

  @Override
  @Transactional
  public Carrito getById(Long id) {
    //se necesita validar si el id de carrito existe, si no existe se crea
    Optional<Carrito> optionalCarrito = carritoRepository.findById(id);
    Carrito carrito = optionalCarrito.get();
    return carrito;
  }

  @Override
  @Transactional
  public Carrito save(Carrito c) {
    c = carritoRepository.save(c);
    return c;
  }

  @Override
  @Transactional
  public Carrito update(Carrito c) throws ParseException {
    Optional<Carrito> carritoOptional = carritoRepository.findById(c.getIdCarrito());
    Carrito carrito = carritoOptional.get();
    carrito = carritoRepository.save(c);
    return carrito;
  }

  @Override
  @Transactional
  public boolean delete(Long id) {
    try {
        Optional<Carrito> carrito = carritoRepository.findById(id);
        carritoRepository.deleteById(carrito.get().getIdCarrito());
        return true;
        }catch(Exception e) {
         return false;
        }
  }




}
