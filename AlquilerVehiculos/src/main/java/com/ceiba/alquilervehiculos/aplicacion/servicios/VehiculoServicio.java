package com.ceiba.alquilervehiculos.aplicacion.servicios;

import org.springframework.stereotype.Component;

import com.ceiba.alquilervehiculos.AlquilerVehiculosApplication;
import com.ceiba.alquilervehiculos.aplicacion.servicios.interfaces.IVehiculoServicio;
import com.ceiba.alquilervehiculos.dominio.modelo.Vehiculo;

@Component
public class VehiculoServicio implements IVehiculoServicio {

	@Override
	public void registrarVehiculo(Vehiculo vehiculo) {
		AlquilerVehiculosApplication.repositorioVehiculo.registrarVehiculo(vehiculo);
	}
}