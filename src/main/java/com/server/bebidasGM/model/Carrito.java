package com.server.bebidasGM.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Carrito")
public class Carrito {

  /*
  CREATE TABLE Carrito (
  id_carrito NUMBER PRIMARY KEY,
  id_cliente NUMBER NOT NULL,
  fecha_carrito DATE DEFAULT SYSDATE,
  FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);
   */
  @Id
  @Column(name="id_carrito")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idCarrito;

  @Column(name="id_cliente")
  private long idCliente;

  @Column(name="fecha_carrito")
  private String fechaCarrito;

  public Carrito() {
  }

  public Carrito(long idCarrito, long idCliente, String fechaCarrito) {
    this.idCarrito = idCarrito;
    this.idCliente = idCliente;
    this.fechaCarrito = fechaCarrito;
  }
  @SequenceGenerator(name = "carrito_seq", sequenceName = "incCarrito", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carrito_seq")
  public long getIdCarrito() {
    return idCarrito;
  }

  public void setIdCarrito(long idCarrito) {
    this.idCarrito = idCarrito;
  }

  public long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(long idCliente) {
    this.idCliente = idCliente;
  }

  public String getFechaCarrito() {
    return fechaCarrito;
  }

  public void setFechaCarrito(String fechaCarrito) {
    this.fechaCarrito = fechaCarrito;
  }
}
