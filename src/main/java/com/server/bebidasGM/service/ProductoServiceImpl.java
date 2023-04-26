package com.server.bebidasGM.service;

import com.server.bebidasGM.model.Producto;
import com.server.bebidasGM.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{

  @Autowired
  ProductoRepository productoRepository;


  @Override
  public ArrayList<Producto> getAllProducto() {
    return (ArrayList<Producto>) productoRepository.findAll() ;
  }

  @Override
  public Optional<Producto> getProductoById(Long id) {
    return productoRepository.findById(id);
  }

  @Override
  public Producto saveProducto(Producto a) {
    return productoRepository.save(a);
  }

  @Override
  public boolean deleteProducto(Long id) {
    try {
      Optional<Producto> producto = getProductoById(id);
      productoRepository.delete(producto.get());
      return true;
    } catch (Exception e){
      return false;
    }

  }



}
