package com.server.bebidasGM.controller;

import com.server.bebidasGM.model.Carrito;
import com.server.bebidasGM.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("carrito")
public class CarritoController {

  @Autowired
  CarritoService carritoService;

  @GetMapping("")
  public ArrayList<Carrito> getAll(){
    return carritoService.findAll();
  }

  @GetMapping("/get")
  public ResponseEntity<?> getById(@RequestParam long id){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(carritoService.getById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }

  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@RequestBody Carrito carrito){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(carritoService.save(carrito));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @PutMapping("/update")
  public ResponseEntity<?> update(@RequestBody Carrito carrito){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(carritoService.update(carrito));
    }catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @DeleteMapping("/delete")
  public boolean delete(@RequestParam long id){
    return carritoService.delete(id);
  }




}
