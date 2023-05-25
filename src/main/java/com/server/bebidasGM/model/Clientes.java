package com.server.bebidasGM.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Clientes")
public class Clientes implements Serializable {
  /*
    CREATE TABLE Clientes (
      id_cliente NUMBER PRIMARY KEY,
      nombre_cliente VARCHAR2(100) NOT NULL,
    apellidos_cliente VARCHAR2(100) NOT NULL,
    direccion_cliente VARCHAR2(200),
    telefono_cliente VARCHAR2(20),
    correo_electronico VARCHAR2(100),
    fecha_registro DATE DEFAULT SYSDATE
  );
    */
  @Id
  @Column(name = "id_cliente")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idCliente;

  @Column(name="nombre_cliente")
  private String nombreCliente;

  @Column(name="apellidos_cliente")
  private String apellidosCliente;

  @Column(name="direccion_cliente")
  private String direccionCliente;

  @Column(name="telefono_cliente")
  private String telefonoCliente;

  @Column(name="correo_electronico")
  private String correoElectronico;

  @Column(name="fecha_registro")
  @Temporal(TemporalType.DATE)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "DD-MON-YY HH:MI:SS")
  private String fechaRegistro;

  public Clientes() {
  }

  public Clientes(long idCliente, String nombreCliente, String apellidosCliente, String direccionCliente, String telefonoCliente, String correoElectronico, String fechaRegistro) {
    this.idCliente = idCliente;
    this.nombreCliente = nombreCliente;
    this.apellidosCliente = apellidosCliente;
    this.direccionCliente = direccionCliente;
    this.telefonoCliente = telefonoCliente;
    this.correoElectronico = correoElectronico;
    this.fechaRegistro = fechaRegistro;
  }

  @SequenceGenerator(name = "producto_seq", sequenceName = "incProductos", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_seq")
  public long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(long idCliente) {
    this.idCliente = idCliente;
  }

  public String getNombreCliente() {
    return nombreCliente;
  }

  public void setNombreCliente(String nombreCliente) {
    this.nombreCliente = nombreCliente;
  }

  public String getApellidosCliente() {
    return apellidosCliente;
  }

  public void setApellidosCliente(String apellidosCliente) {
    this.apellidosCliente = apellidosCliente;
  }

  public String getDireccionCliente() {
    return direccionCliente;
  }

  public void setDireccionCliente(String direccionCliente) {
    this.direccionCliente = direccionCliente;
  }

  public String getTelefonoCliente() {
    return telefonoCliente;
  }

  public void setTelefonoCliente(String telefonoCliente) {
    this.telefonoCliente = telefonoCliente;
  }

  public String getCorreoElectronico() {
    return correoElectronico;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  public String getFechaRegistro() {
    return fechaRegistro;
  }

  public void setFechaRegistro(String fechaRegistro) {
    this.fechaRegistro = fechaRegistro;
  }
}
