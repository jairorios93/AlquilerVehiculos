package com.ceiba.alquilervehiculos.databuilder;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;

public class ComandoVehiculoDataBuilder {

	private Long id;

	private String placa;

	private String modelo;

	private String marca;

	private String color;

	private double precio;

	public ComandoVehiculoDataBuilder() {
		placa = "ASF13";
		modelo = "Z3";
		marca = "BMW";
		color = "Gris";
		precio = 45000;
		id = 1L;
	}

	public ComandoVehiculo build() {
		return new ComandoVehiculo(id, placa, modelo, marca, color, precio);
	}
	
	
	public ComandoVehiculo conPlaca(String placa) {
		return new ComandoVehiculo(id, placa, modelo, marca, color, precio);
	}
}