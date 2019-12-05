package com.ceiba.alquilervehiculos.dominio.servicio.vehiculo;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioVehiculo;

public class ServicioBuscarVehiculo {

	private RepositorioVehiculo repositorioVehiculo;

	public ServicioBuscarVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}

	public ComandoVehiculo buscarVehiculo(String placa) {
		return repositorioVehiculo.buscarVehiculo(placa);
	}
}