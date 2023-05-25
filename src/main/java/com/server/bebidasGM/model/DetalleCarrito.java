package com.server.bebidasGM.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Detalle_carrito")
public class DetalleCarrito {
  /*
  CREATE TABLE Detalle_carrito (
  id_detalle_carrito NUMBER PRIMARY KEY,
  id_carrito NUMBER NOT NULL,
  id_producto NUMBER NOT NULL,
  cantidad NUMBER NOT NULL,
  precio_unitario NUMBER(8,2) NOT NULL,
  FOREIGN KEY (id_carrito) REFERENCES Carrito(id_carrito),
  FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);
   */

  @Id
  @Column(name="id_detalle_carrito")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idDetalleCarrito;

  @Column(name="id_carrito")
  private long idCarrito;

  @Column(name="id_producto")
  private long idProducto;

  @Column(name="cantidad")
  private long cantidad;

  @Column(name="precio_unitario")
  private long precioUnitario;

  public DetalleCarrito() {
  }

  public DetalleCarrito(long idDetalleCarrito, long idCarrito, long idProducto, long cantidad, long precioUnitario) {
    this.idDetalleCarrito = idDetalleCarrito;
    this.idCarrito = idCarrito;
    this.idProducto = idProducto;
    this.cantidad = cantidad;
    this.precioUnitario = precioUnitario;
  }

  @SequenceGenerator(name = "detCarrito_seq", sequenceName = "incDetalleCarrito", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detCarrito_seq")
  public long getIdDetalleCarrito() {
    return idDetalleCarrito;
  }

  public void setIdDetalleCarrito(long idDetalleCarrito) {
    this.idDetalleCarrito = idDetalleCarrito;
  }

  public long getIdCarrito() {
    return idCarrito;
  }

  public void setIdCarrito(long idCarrito) {
    this.idCarrito = idCarrito;
  }

  public long getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(long idProducto) {
    this.idProducto = idProducto;
  }

  public long getCantidad() {
    return cantidad;
  }

  public void setCantidad(long cantidad) {
    this.cantidad = cantidad;
  }

  public long getPrecioUnitario() {
    return precioUnitario;
  }

  public void setPrecioUnitario(long precioUnitario) {
    this.precioUnitario = precioUnitario;
  }
}
