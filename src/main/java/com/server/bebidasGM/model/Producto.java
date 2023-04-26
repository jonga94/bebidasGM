package com.server.bebidasGM.model;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "PRODUCTOS")
public class Producto {

  @Id
  @Column(name="id_producto")
  private long id;
  private String nombre_producto;
  private String descripcion_producto;
  private long precio_producto;
  private long  existencias;
  private String categoria;
  @Lob
  private byte[] imagen;
  private String en_oferta;
  private String fecha_creacion;

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

  public Producto(long id, String nombre_producto, String descripcion_producto, long precio_producto, long existencias, String categoria, byte[] imagen, String en_oferta, String fecha_creacion) {
    this.id = id;
    this.nombre_producto = nombre_producto;
    this.descripcion_producto = descripcion_producto;
    this.precio_producto = precio_producto;
    this.existencias = existencias;
    this.categoria = categoria;
    this.imagen = imagen;
    this.en_oferta = en_oferta;
    this.fecha_creacion = fecha_creacion;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getNombre_producto() {
    return nombre_producto;
  }

  public void setNombre_producto(String nombre_producto) {
    this.nombre_producto = nombre_producto;
  }

  public String getDescripcion_producto() {
    return descripcion_producto;
  }

  public void setDescripcion_producto(String descripcion_producto) {
    this.descripcion_producto = descripcion_producto;
  }

  public long getPrecio_producto() {
    return precio_producto;
  }

  public void setPrecio_producto(long precio_producto) {
    this.precio_producto = precio_producto;
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

  public String getEn_oferta() {
    return en_oferta;
  }

  public void setEn_oferta(String en_oferta) {
    this.en_oferta = en_oferta;
  }

  public String getFecha_creacion() {
    return fecha_creacion;
  }

  public void setFecha_creacion(String fecha_creacion) {
    this.fecha_creacion = fecha_creacion;
  }
}
