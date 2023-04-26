package com.server.bebidasGM.controller;

import com.server.bebidasGM.model.Inventario;
import com.server.bebidasGM.model.Producto;
import com.server.bebidasGM.service.InventarioService;
import com.server.bebidasGM.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("bebidasController")
public class BebidasGmController {

  @Autowired
  ProductoService productoService;

  @Autowired
  InventarioService inventarioService;

  @GetMapping("/productos")
  public ArrayList<Producto> getProductos(){
    return productoService.getAllProducto();
  }

  @GetMapping("/productoId/{id}")
  public Optional<Producto> getProductoById(@PathVariable("id") long id){
    return productoService.getProductoById(id);
  }

  @GetMapping("/inventarioId/{id}")
  public Optional<Inventario> getInventarioById(@PathVariable("id") long id){
    return inventarioService.getInventarioById(id);
  }


}
