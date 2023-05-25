package com.server.bebidasGM.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "PRODUCTOS")
public class Producto implements Serializable {

  @Id
  @Column(name="id_producto")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name="nombre_producto")
  private String nombreProducto;
  @Column(name="descripcion_producto")
  private String descripcionProducto;
  @Column(name="precio_producto")
  private long precioProducto;
  @Column(name="existencias")
  private long  existencias;
  @Column(name="categoria")
  private String categoria;
  @Lob
  @Column(name="imagen")
  private byte[] imagen;
  @Column(name="en_oferta")
  private String enOferta;

  @Column(name = "fecha_creacion")
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD-MON-YY HH:MI:SS")
  private String fechaCreacion;

  /*
  id_producto NUMBER PRIMARY KEY,
  nombre_producto VARCHAR2(100) NOT NULL,
  descripcion_producto VARCHAR2(200),
  precio_producto NUMBER(8,2) NOT NULL,
  existencias NUMBER NOT NULL,
  categoria VARCHAR2(50),
  imagen BLOB,
  en_oferta CHAR(1) DEFAULT 'N',
  fecha_creacion DATE DEFAULT SYSDATE
   */

  public Producto() {
  }

  public Producto(long id, String nombreProducto, String descripcionProducto, long precioProducto, long existencias, String categoria, byte[] imagen, String enOferta, String fechaCreacion) {
    this.id = id;
    this.nombreProducto = nombreProducto;
    this.descripcionProducto = descripcionProducto;
    this.precioProducto = precioProducto;
    this.existencias = existencias;
    this.categoria = categoria;
    this.imagen = imagen;
    this.enOferta = enOferta;
    this.fechaCreacion = fechaCreacion;
  }

  @SequenceGenerator(name = "producto_seq", sequenceName = "incProductos", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_seq")
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNombreProducto() {
    return nombreProducto;
  }

  public void setNombreProducto(String nombreProducto) {
    this.nombreProducto = nombreProducto;
  }

  public String getDescripcionProducto() {
    return descripcionProducto;
  }

  public void setDescripcionProducto(String descripcionProducto) {
    this.descripcionProducto = descripcionProducto;
  }

  public long getPrecioProducto() {
    return precioProducto;
  }

  public void setPrecioProducto(long precioProducto) {
    this.precioProducto = precioProducto;
  }

  public long getExistencias() {
    return existencias;
  }

  public void setExistencias(long existencias) {
    this.existencias = existencias;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public byte[] getImagen() {
    return imagen;
  }

  public void setImagen(byte[] imagen) {
    this.imagen = imagen;
  }

  public String getEnOferta() {
    return enOferta;
  }

  public void setEnOferta(String enOferta) {
    this.enOferta = enOferta;
  }

  public String getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(String fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }
}
