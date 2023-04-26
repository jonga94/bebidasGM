package com.server.bebidasGM.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Inventario")
public class Inventario {

@Id
@Column(name = "id_inventario")
private Long id;
private Long idProducto;
private Long cantidad;
private String fechaActualizacion;

/*
  id_inventario NUMBER PRIMARY KEY,
  id_producto NUMBER NOT NULL,
  cantidad NUMBER NOT NULL,
 */

  public Inventario() {
  }

  public Inventario(Long idProducto, Long cantidad, String fechaActualizacion) {
    this.idProducto = idProducto;
    this.cantidad = cantidad;
    this.fechaActualizacion = fechaActualizacion;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Long idProducto) {
    this.idProducto = idProducto;
  }

  public Long getCantidad() {
    return cantidad;
  }

  public void setCantidad(Long cantidad) {
    this.cantidad = cantidad;
  }

  public String getFechaActualizacion() {
    return fechaActualizacion;
  }

  public void setFechaActualizacion(String fechaActualizacion) {
    this.fechaActualizacion = fechaActualizacion;
  }
}
