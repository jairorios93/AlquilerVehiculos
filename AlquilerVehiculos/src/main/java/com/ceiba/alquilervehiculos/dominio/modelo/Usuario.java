package com.ceiba.alquilervehiculos.dominio.modelo;

import java.util.Date;

public class Usuario {

	private Long cedula;

	private String nombres;

	private String apellidos;

	private Date fechaNacimiento;

	public Usuario(Long cedula, String nombres, String apellidos, Date fechaNacimiento) {
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getCedula() {
		return cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

}