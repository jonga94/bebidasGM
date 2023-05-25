package com.server.bebidasGM.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
@Table(name = "ventas")
public class Ventas {
  /*
CREATE TABLE ventas (
  id_venta NUMBER(10) PRIMARY KEY,
  id_cliente NUMBER(10) NOT NULL,
  fecha DATE DEFAULT SYSDATE,
  total NUMBER(10,2) NOT NULL,
  metodo_pago VARCHAR2(20) NOT NULL,
  FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente)
);
   */

  @Id
  @Column(name="id_venta")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idVenta;

  @Column(name="id_cliente")
  private long idCliente;

  @Column(name="fecha")
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD-MON-YY HH:MI:SS")
  private String fecha;

  @Column(name="total")
  private long total;

  @Column(name="metodo_pago")
  private String metodoPago;

  public Ventas() {
  }

  public Ventas(long idVenta, long idCliente, String fecha, long total, String metodoPago) {
    this.idVenta = idVenta;
    this.idCliente = idCliente;
    this.fecha = fecha;
    this.total = total;
    this.metodoPago = metodoPago;
  }

  @SequenceGenerator(name = "ventas_seq", sequenceName = "incVentas", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ventas_seq")
  public long getIdVenta() {
    return idVenta;
  }

  public void setIdVenta(long idVenta) {
    this.idVenta = idVenta;
  }

  public long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(long idCliente) {
    this.idCliente = idCliente;
  }

  public String getFecha() {
    return fecha;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

  public String getMetodoPago() {
    return metodoPago;
  }

  public void setMetodoPago(String metodoPago) {
    this.metodoPago = metodoPago;
  }
}
