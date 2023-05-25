package com.server.bebidasGM.controller;

import com.server.bebidasGM.model.Ventas;
import com.server.bebidasGM.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("ventas")
public class VentasController {

  @Autowired
  VentasService ventasService;

  @GetMapping("")
  public ArrayList<Ventas> getAll(){
    return ventasService.findAll();
  }

  @GetMapping("/get")
  public ResponseEntity<?> getById(@RequestParam long id){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(ventasService.getById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }

  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@RequestBody Ventas ventas){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(ventasService.save(ventas));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @PutMapping("/update")
  public ResponseEntity<?> update(@RequestBody Ventas ventas){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(ventasService.update(ventas));
    }catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @DeleteMapping("/delete")
  public boolean delete(@RequestParam long id){
    return ventasService.delete(id);
  }


}
