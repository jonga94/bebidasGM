package com.server.bebidasGM.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Inventario")
public class Inventario implements Serializable {
  /*
TO_CHAR(SYSDATE,'DD-MON-YYYYHH24:MI:SS')
  CREATE TABLE Inventario (
  id_inventario NUMBER PRIMARY KEY,
  id_producto NUMBER NOT NULL,
  cantidad NUMBER NOT NULL,
  fecha_actualizacion DATE DEFAULT SYSDATE,
  FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);
 */

@Id
@Column(name = "id_inventario")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "id_producto")
private Long idProducto;
@Column(name = "cantidad")
private Long cantidad;
@Column(name = "fecha_actualizacion")
@Temporal(TemporalType.DATE)
@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD-MON-YY HH:MI:SS")
private String fechaActualizacion;

  public Inventario() {
  }

  public Inventario(Long idProducto, Long cantidad, String fechaActualizacion) {
    this.idProducto = idProducto;
    this.cantidad = cantidad;
    this.fechaActualizacion = fechaActualizacion;
  }

  @SequenceGenerator(name = "inventario_seq", sequenceName = "incInventario", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventario_seq")
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
