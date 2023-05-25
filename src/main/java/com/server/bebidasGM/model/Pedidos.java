package com.server.bebidasGM.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Pedidos")
public class Pedidos {
  /*
CREATE TABLE Pedidos (
  id_pedido NUMBER PRIMARY KEY,
  id_cliente NUMBER NOT NULL,
  fecha_pedido DATE DEFAULT SYSDATE,
  estado_pedido VARCHAR2(20) DEFAULT 'en proceso',
  total_pedido NUMBER(8,2) NOT NULL,
  direccion_envio VARCHAR2(200),
  FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);
   */

  @Id
  @Column(name="id_pedido")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idPedido;

  @Column(name="id_cliente")
  private long idCliente;

  @Column(name="fecha_pedido")
  private String fechaPedido;

  @Column(name="estado_pedido")
  private String estadoPedido;

  @Column(name="total_pedido")
  private long totalPedido;

  @Column(name="direccion_envio")
  private String direccionEnvio;

  public Pedidos() {
  }

  public Pedidos(long idPedido, long idCliente, String fechaPedido, String estadoPedido, long totalPedido, String direccionEnvio) {
    this.idPedido = idPedido;
    this.idCliente = idCliente;
    this.fechaPedido = fechaPedido;
    this.estadoPedido = estadoPedido;
    this.totalPedido = totalPedido;
    this.direccionEnvio = direccionEnvio;
  }

  @SequenceGenerator(name = "pedidos_seq", sequenceName = "incPedidos", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedidos_seq")
  public long getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(long idPedido) {
    this.idPedido = idPedido;
  }

  public long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(long idCliente) {
    this.idCliente = idCliente;
  }

  public String getFechaPedido() {
    return fechaPedido;
  }

  public void setFechaPedido(String fechaPedido) {
    this.fechaPedido = fechaPedido;
  }

  public String getEstadoPedido() {
    return estadoPedido;
  }

  public void setEstadoPedido(String estadoPedido) {
    this.estadoPedido = estadoPedido;
  }

  public long getTotalPedido() {
    return totalPedido;
  }

  public void setTotalPedido(long totalPedido) {
    this.totalPedido = totalPedido;
  }

  public String getDireccionEnvio() {
    return direccionEnvio;
  }

  public void setDireccionEnvio(String direccionEnvio) {
    this.direccionEnvio = direccionEnvio;
  }
}
