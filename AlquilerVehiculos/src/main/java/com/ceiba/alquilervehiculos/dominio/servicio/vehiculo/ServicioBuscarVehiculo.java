package com.ceiba.alquilervehiculos.dominio.servicio.vehiculo;

import java.util.List;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioVehiculo;

public class ServicioBuscarVehiculo {

	private RepositorioVehiculo repositorioVehiculo;

	public ServicioBuscarVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}

	public ComandoVehiculo buscarVehiculo(String placa) {
		List<ComandoVehiculo> vehiculos = repositorioVehiculo.buscarVehiculo(placa);
		for (int i = 0; i < vehiculos.size(); i++) {
			if (vehiculos.get(i).getPlaca().equals(placa)) {
				return vehiculos.get(i);
			}
		}
		return null;
	}
}