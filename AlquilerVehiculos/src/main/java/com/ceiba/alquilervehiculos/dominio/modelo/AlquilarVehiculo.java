package com.ceiba.alquilervehiculos.dominio.modelo;

import java.util.Date;

@SuppressWarnings("unused")
public class AlquilarVehiculo {

	private Usuario usuario;

	private Vehiculo vehiculo;

	private Date fechaInicio;

	private Date fechaFin;

	private boolean estado;

	private double valor;

	public AlquilarVehiculo(Usuario usuario, Vehiculo vehiculo, Date fechaInicio, Date fechaFin, boolean estado,
			double valor) {
		this.usuario = usuario;
		this.vehiculo = vehiculo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.valor = valor;
	}

}