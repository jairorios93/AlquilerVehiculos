package com.ceiba.alquilervehiculos.dominio.servicio.vehiculo;

import com.ceiba.alquilervehiculos.dominio.modelo.Vehiculo;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioVehiculo;

public class ServicioCrearVehiculo {

	private RepositorioVehiculo repositorioVehiculo;

	public ServicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}

	public void registrarVehiculo(Vehiculo vehiculo) {
		// Logica
		repositorioVehiculo.registrarVehiculo(vehiculo);
	}
}