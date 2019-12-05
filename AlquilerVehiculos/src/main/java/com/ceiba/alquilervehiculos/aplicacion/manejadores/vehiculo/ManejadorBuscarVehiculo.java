package com.ceiba.alquilervehiculos.aplicacion.manejadores.vehiculo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;
import com.ceiba.alquilervehiculos.dominio.servicio.vehiculo.ServicioBuscarVehiculo;

@Service
public class ManejadorBuscarVehiculo {

	private final ServicioBuscarVehiculo servicioBuscarVehiculo;

	public ManejadorBuscarVehiculo(ServicioBuscarVehiculo servicioBuscarVehiculo) {
		this.servicioBuscarVehiculo = servicioBuscarVehiculo;
	}

	@Transactional
	public ComandoVehiculo buscarVehiculo(String placa) {
		return servicioBuscarVehiculo.buscarVehiculo(placa);
	}

}