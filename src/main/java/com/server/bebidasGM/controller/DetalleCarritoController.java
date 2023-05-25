package com.server.bebidasGM.controller;


import com.server.bebidasGM.model.DetalleCarrito;
import com.server.bebidasGM.service.DetalleCarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("detalleCarrito")
public class DetalleCarritoController {

  @Autowired
  DetalleCarritoService detalleCarritoService;

  @GetMapping("")
  public ArrayList<DetalleCarrito> getAll(){
    return detalleCarritoService.findAll();
  }

  @GetMapping("/get")
  public ResponseEntity<?> getById(@RequestParam long id){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(detalleCarritoService.getById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }

  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@RequestBody DetalleCarrito detalleCarrito){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(detalleCarritoService.save(detalleCarrito));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @PutMapping("/update")
  public ResponseEntity<?> update(@RequestBody DetalleCarrito detalleCarrito){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(detalleCarritoService.update(detalleCarrito));
    }catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @DeleteMapping("/delete")
  public boolean delete(@RequestParam long id){
    return detalleCarritoService.delete(id);
  }

}
