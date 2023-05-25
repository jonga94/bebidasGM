package com.server.bebidasGM.controller;

import com.server.bebidasGM.model.Clientes;
import com.server.bebidasGM.model.Producto;
import com.server.bebidasGM.repository.ClienteRepository;
import com.server.bebidasGM.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("clientes")
public class ClienteController {

  @Autowired
  ClientesService clientesService;

  @GetMapping("")
  public ArrayList<Clientes> clientes(){
    return (ArrayList<Clientes>) clientesService.getAll();
  }

  @GetMapping("/get")
  public ResponseEntity<?> getById(@RequestParam Long id){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(clientesService.getById(id));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @PostMapping("/save")
  public ResponseEntity<?> save(@RequestBody Clientes c){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(clientesService.save(c));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }

  }

  @PutMapping("/update")
  public ResponseEntity<?> update(@RequestBody Clientes c){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(clientesService.update(c));
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
    }
  }

  @DeleteMapping("/delete")
  public boolean delete(@RequestParam long id){
    return clientesService.delete(id);
  }


}
