package com.ceiba.alquilervehiculos.dominio.servicio.alquiler;

import com.ceiba.alquilervehiculos.dominio.modelo.AlquilarVehiculo;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioAlquilarVehiculo;

public class ServicioAlquilarVehiculo {

	private RepositorioAlquilarVehiculo repositorioAlquilarVehiculo;

	public ServicioAlquilarVehiculo(RepositorioAlquilarVehiculo repositorioAlquilarVehiculo) {
		this.repositorioAlquilarVehiculo = repositorioAlquilarVehiculo;
	}

	public void alquilarVehiculo(AlquilarVehiculo alquilarVehiculo) {
		repositorioAlquilarVehiculo.alquilarVehiculo(alquilarVehiculo);
	}
}
