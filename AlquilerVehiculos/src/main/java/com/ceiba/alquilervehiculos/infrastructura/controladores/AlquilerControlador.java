package com.ceiba.alquilervehiculos.infrastructura.controladores;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoAlquilarVehiculo;
import com.ceiba.alquilervehiculos.aplicacion.manejadores.alquiler.ManejadorAlquilarVehiculo;
import com.ceiba.alquilervehiculos.aplicacion.manejadores.alquiler.ManejadorDevolverVehiculo;

@RestController
@CrossOrigin
@RequestMapping("/alquiler")
public class AlquilerControlador {

	private final ManejadorAlquilarVehiculo manejadorAlquilarVehiculo;
	private final ManejadorDevolverVehiculo manejadorDevolverVehiculo;

	public AlquilerControlador(ManejadorAlquilarVehiculo manejadorAlquilarVehiculo,
			ManejadorDevolverVehiculo manejadorDevolverVehiculo) {
		this.manejadorAlquilarVehiculo = manejadorAlquilarVehiculo;
		this.manejadorDevolverVehiculo = manejadorDevolverVehiculo;
	}

	@PostMapping("/alquilarVehiculo")
	public void alquilarVehiculo(@RequestBody ComandoAlquilarVehiculo alquilarVehiculo) {
		manejadorAlquilarVehiculo.alquilarVehiculo(alquilarVehiculo);
	}

	@GetMapping("/devolverVehiculo/{PLACA}")
	public void devolverVehiculo(@PathVariable(name = "PLACA") String placa) {
		manejadorDevolverVehiculo.devolverVehiculo(placa);
	}
}