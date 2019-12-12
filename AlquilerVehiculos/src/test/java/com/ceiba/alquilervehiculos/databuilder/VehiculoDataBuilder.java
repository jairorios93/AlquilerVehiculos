package com.ceiba.alquilervehiculos.databuilder;

import com.ceiba.alquilervehiculos.dominio.modelo.Vehiculo;

public class VehiculoDataBuilder {

	private Long id;

	private String placa;

	private String modelo;

	private String marca;

	private String color;

	private double precio;

	public VehiculoDataBuilder() {
		placa = "ASF12";
		modelo = "Z3";
		marca = "BMW";
		color = "Gris";
		precio = 45000;
		id = 1L;
	}

	public Vehiculo build() {
		return new Vehiculo(placa, modelo, marca, color, precio);
	}
}