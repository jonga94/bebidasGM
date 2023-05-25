package com.server.bebidasGM.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Detalle_pedido")
public class DetallePedido {
  /*
CREATE TABLE Detalle_pedido (
  id_detalle NUMBER PRIMARY KEY,
  id_pedido NUMBER NOT NULL,
  id_producto NUMBER NOT NULL,
  cantidad NUMBER NOT NULL,
  precio_unitario NUMBER(8,2) NOT NULL,
  FOREIGN KEY (id_pedido) REFERENCES Pedidos(id_pedido),
  FOREIGN KEY (id_producto) REFERENCES Productos(id_producto)
);
*/

  @Id
  @Column(name="id_detalle")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idDetalle;

  @Column(name="id_pedido")
  private long idPedido;

  @Column(name="id_producto", nullable = true)
  private Long idProducto;

  @Column(name="cantidad")
  private long cantidad;

  @Column(name="precio_unitario")
  private long precioUnitario;

  public DetallePedido() {
  }

  public DetallePedido(long idDetalle, long idPedido, long idProducto, long cantidad, long precioUnitario) {
    this.idDetalle = idDetalle;
    this.idPedido = idPedido;
    this.idProducto = idProducto;
    this.cantidad = cantidad;
    this.precioUnitario = precioUnitario;
  }

  @SequenceGenerator(name = "detPedido_seq", sequenceName = "incDetallePedido", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detPedido_seq")
  public long getIdDetalle() {
    return idDetalle;
  }

  public void setIdDetalle(long idDetalle) {
    this.idDetalle = idDetalle;
  }

  public long getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(long idPedido) {
    this.idPedido = idPedido;
  }

  public Long getIdProducto() {
    return idProducto;
  }

  public void setIdProducto(Long idProducto) {
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
