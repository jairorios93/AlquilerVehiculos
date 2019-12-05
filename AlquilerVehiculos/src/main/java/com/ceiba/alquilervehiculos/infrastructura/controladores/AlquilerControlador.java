package com.ceiba.alquilervehiculos.infrastructura.controladores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoAlquilarVehiculo;
import com.ceiba.alquilervehiculos.aplicacion.manejadores.alquiler.ManejadorAlquilarVehiculo;

@RestController
@RequestMapping("/alquiler")
public class AlquilerControlador {

	private final ManejadorAlquilarVehiculo manejadorAlquilarVehiculo;

	public AlquilerControlador(ManejadorAlquilarVehiculo manejadorAlquilarVehiculo) {
		this.manejadorAlquilarVehiculo = manejadorAlquilarVehiculo;
	}

	@PostMapping("/alquilarVehiculo")
	public void alquilarVehiculo(@RequestBody ComandoAlquilarVehiculo alquilarVehiculo) {
		manejadorAlquilarVehiculo.alquilarVehiculo(alquilarVehiculo);
	}

}