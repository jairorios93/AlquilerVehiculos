package com.ceiba.alquilervehiculos.aplicacion.comando;

import java.util.Date;

public class ComandoAlquilarVehiculo {

	private Long id;

	private ComandoUsuario usuario;

	private ComandoVehiculo vehiculo;

	private Date fechaInicio;

	private Date fechaFin;

	private boolean estado;

	private double valor;

	public ComandoAlquilarVehiculo() {
	}

	public ComandoAlquilarVehiculo(Long id, ComandoUsuario usuario, ComandoVehiculo vehiculo, Date fechaInicio,
			Date fechaFin, boolean estado, double valor) {
		this.id = id;
		this.usuario = usuario;
		this.vehiculo = vehiculo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ComandoUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(ComandoUsuario usuario) {
		this.usuario = usuario;
	}

	public ComandoVehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(ComandoVehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}