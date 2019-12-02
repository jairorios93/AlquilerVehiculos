package com.ceiba.alquilervehiculos.dominio.modelo;

public class Vehiculo {

	private Long id;

	private String modelo;

	private String marca;

	private String color;

	private double precio;

	public Vehiculo() {
	}

	public Vehiculo(String modelo, String marca, String color, double precio) {
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.precio = precio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

}