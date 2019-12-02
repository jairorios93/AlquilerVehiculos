package com.ceiba.alquilervehiculos.infrastructura.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.alquilervehiculos.aplicacion.servicios.VehiculoServicio;
import com.ceiba.alquilervehiculos.dominio.modelo.Vehiculo;

@RestController
@RequestMapping(value = "/vehiculo")
public class VehiculoControlador {

	private final VehiculoServicio vehiculoServicio;

	public VehiculoControlador(VehiculoServicio vehiculoServicio) {
		this.vehiculoServicio = vehiculoServicio;
	}

	@PostMapping("/registrarVehiculo")
	public void registrarVehiculo(@RequestBody Vehiculo vehiculo) {
		vehiculoServicio.registrarVehiculo(vehiculo);
	}
}