package com.server.bebidasGM.controller;

import com.server.bebidasGM.model.DetallePedido;
import com.server.bebidasGM.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("detallePedido")
public class DetallePedidosController {

  @Autowired
  DetallePedidoService detallePedidoService;

  @GetMapping("")
  public ArrayList<DetallePedido> getAll(){
    return detallePedidoService.findAll();
  }

  @GetMapping("/get")
  public ResponseEntity<?> getById(@RequestParam long id){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.getById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }

  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@RequestBody DetallePedido detallePedido){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.save(detallePedido));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @PutMapping("/update")
  public ResponseEntity<?> update(@RequestBody DetallePedido detallePedido){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(detallePedidoService.update(detallePedido));
    }catch (Exception e){
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @DeleteMapping("/delete")
  public boolean delete(@RequestParam long id){
    return detallePedidoService.delete(id);
  }


}
