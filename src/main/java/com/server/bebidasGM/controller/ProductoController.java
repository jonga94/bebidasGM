package com.server.bebidasGM.controller;

import com.server.bebidasGM.model.Producto;
import com.server.bebidasGM.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("producto")
public class ProductoController {

  @Autowired
  ProductoService productoService;

  @GetMapping("")
  public ArrayList<Producto> getAll(){
    return productoService.getAll();
  }

  @GetMapping("/get")
  public ResponseEntity<?> getById(@RequestParam long id){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(productoService.getById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@RequestBody Producto producto){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(productoService.save(producto));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }

  }

  @PutMapping("/update")
  public ResponseEntity<?> update(@RequestBody Producto producto){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(productoService.update(producto));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @DeleteMapping("/delete")
  public boolean delete(@RequestParam long id){
    return productoService.delete(id);
  }

}
