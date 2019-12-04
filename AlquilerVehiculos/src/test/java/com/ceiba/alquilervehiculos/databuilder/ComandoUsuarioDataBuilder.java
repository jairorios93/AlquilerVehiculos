package com.ceiba.alquilervehiculos.databuilder;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;

public class ComandoUsuarioDataBuilder {

	private String cedula;

	private String nombres;

	private String apellidos;

	private Date fechaNacimiento;

	public ComandoUsuarioDataBuilder() {
		cedula = "109493513";
		nombres = "Jairo Andres";
		apellidos = "Rios Franco";
		fechaNacimiento = Calendar.getInstance().getTime();
	}

	public ComandoUsuario conNombre(String nombres) {
		return new ComandoUsuario(cedula, nombres, apellidos, fechaNacimiento);
	}

	public ComandoUsuario build() {
		return new ComandoUsuario(cedula, nombres, apellidos, fechaNacimiento);
	}
}
