package com.ceiba.alquilervehiculos.databuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoAlquilarVehiculo;
import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;
import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;

public class ComandoAlquilarVehiculoDataBuilder {

	private Long id;

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
		
		GregorianCalendar fechaAjustada = new GregorianCalendar();
		fechaAjustada.setTime(fechaInicio);
		fechaAjustada.add(Calendar.DATE, 1);
		fechaFin = fechaAjustada.getTime();
		
		estado = true;
		valor = 1050000;
		id = 1L;
	}

	public ComandoAlquilarVehiculo build() {
		return new ComandoAlquilarVehiculo(id, usuario, vehiculo, fechaInicio, fechaFin, estado, valor);
	}

}
