package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Producto;
import com.server.bebidasGM.repository.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

  @Autowired
  ProductoRepository productoRepository;

  @Override
  @Transactional
  public ArrayList<Producto> getAll() {
    return (ArrayList<Producto>) productoRepository.findAll() ;
  }

  @Override
  @Transactional
  public Producto getById(Long id) {
    Optional<Producto> productoOptional = productoRepository.findById(id);
    return productoOptional.get();
  }

  @Override
  @Transactional
  public Producto save(Producto p) {
    System.out.println("antes: "+ p.getId());
    Producto productoNuevo = productoRepository.save(p);
    System.out.println("despues: "+productoNuevo.getId());
    return productoNuevo;
  }

  @Override
  public Producto update(Producto p) {
      Optional<Producto> productoOptional = productoRepository.findById(p.getId());
      Producto producto = productoOptional.get();
      producto = productoRepository.save(p);
      return producto;
  }

  @Override
  @Transactional
  public boolean delete(Long id) {
    try {
      Optional<Producto> producto = productoRepository.findById(id);
      productoRepository.delete(producto.get());
      return true;
    } catch (Exception e){
      return false;
    }

  }

}
