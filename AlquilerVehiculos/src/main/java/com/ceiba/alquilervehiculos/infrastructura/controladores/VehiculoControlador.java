package com.ceiba.alquilervehiculos.infrastructura.controladores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;
import com.ceiba.alquilervehiculos.aplicacion.manejadores.vehiculo.ManejadorCrearVehiculo;

@RestController
@RequestMapping(value = "/vehiculo")
public class VehiculoControlador {

	private final ManejadorCrearVehiculo manejadorCrearVehiculo;

	public VehiculoControlador(ManejadorCrearVehiculo manejadorCrearVehiculo) {
		this.manejadorCrearVehiculo = manejadorCrearVehiculo;
	}

	@PostMapping("/registrarVehiculo")
	public void registrarVehiculo(@RequestBody ComandoVehiculo vehiculo) {
		manejadorCrearVehiculo.registrarVehiculo(vehiculo);
	}
}