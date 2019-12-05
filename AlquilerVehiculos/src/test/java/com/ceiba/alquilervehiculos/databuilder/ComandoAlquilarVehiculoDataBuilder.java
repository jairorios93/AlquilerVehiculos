package com.ceiba.alquilervehiculos.databuilder;

import java.util.Calendar;
import java.util.Date;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoAlquilarVehiculo;
import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;
import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;

public class ComandoAlquilarVehiculoDataBuilder {

	private ComandoUsuario usuario;

	private ComandoVehiculo vehiculo;

	private Date fechaInicio;

	private Date fechaFin;

	private boolean estado;

	private double valor;

	public ComandoAlquilarVehiculoDataBuilder() {
		usuario = new ComandoUsuarioDataBuilder().build();
		vehiculo = new ComandoVehiculoDataBuilder().build();
		fechaInicio = Calendar.getInstance().getTime();
		fechaFin = Calendar.getInstance().getTime();
		estado = true;
		valor = 1050000;
	}

	public ComandoAlquilarVehiculo build() {
		return new ComandoAlquilarVehiculo(usuario, vehiculo, fechaInicio, fechaFin, estado, valor);
	}

}
