package com.server.bebidasGM.controller;

import com.server.bebidasGM.model.Pedidos;
import com.server.bebidasGM.service.PedidosService;
import org.springframework.aot.hint.predicate.RuntimeHintsPredicates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("pedidos")
public class PedidosController {

  @Autowired
  PedidosService pedidosService;

  @GetMapping("")
  public ArrayList<Pedidos> getAll(){
    return pedidosService.findAll();
  }

  @GetMapping("/get")
  public ResponseEntity<?> getById(@RequestParam long id){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(pedidosService.getById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }

  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@RequestBody Pedidos pedidos){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(pedidosService.save(pedidos));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @PutMapping("/update")
  public ResponseEntity<?> update(@RequestBody Pedidos pedidos){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(pedidosService.update(pedidos));
    }catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @DeleteMapping("/delete")
  public boolean delete(@RequestParam long id){
    return pedidosService.delete(id);
  }


}
