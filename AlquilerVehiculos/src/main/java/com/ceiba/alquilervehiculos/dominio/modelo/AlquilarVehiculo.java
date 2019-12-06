package com.ceiba.alquilervehiculos.dominio.modelo;

import java.util.Date;

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

	public Usuario getUsuario() {
		return usuario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public boolean isEstado() {
		return estado;
	}

	public double getValor() {
		return valor;
	}

}