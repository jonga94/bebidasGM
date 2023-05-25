package com.server.bebidasGM.controller;

import com.server.bebidasGM.model.Inventario;
import com.server.bebidasGM.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("inventario")
public class InventarioController {

  @Autowired
  InventarioService inventarioService;

  @GetMapping("")
  public ArrayList<Inventario> getAll(){
    return inventarioService.findAll();
  }

  @GetMapping("/get")
  public ResponseEntity<?> getById(@RequestParam long id){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(inventarioService.getById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }

  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@RequestBody Inventario producto){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(inventarioService.save(producto));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @PutMapping("/update")
  public ResponseEntity<?> update(@RequestBody Inventario producto){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(inventarioService.update(producto));
    }catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @DeleteMapping("/delete")
  public boolean delete(@RequestParam long id){
    return inventarioService.delete(id);
  }

}
