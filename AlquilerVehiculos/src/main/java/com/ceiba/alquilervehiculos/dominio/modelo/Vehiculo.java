package com.ceiba.alquilervehiculos.dominio.modelo;

public class Vehiculo {

	private Long id;

	private String placa;

	private String modelo;

	private String marca;

	private String color;

	private double precio;

	public Vehiculo() {
	}

	public Vehiculo(Long id, String placa, String modelo, String marca, String color, double precio) {
		this.id = id;
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.color = color;
		this.precio = precio;
	}

}