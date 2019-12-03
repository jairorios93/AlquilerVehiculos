package com.ceiba.alquilervehiculos.infrastructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.alquilervehiculos.dominio.servicio.vehiculo.ServicioCrearVehiculo;

@Configuration
public class ServicioBean {

	@Bean
	public ServicioCrearVehiculo crearServicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		return new ServicioCrearVehiculo(repositorioVehiculo);
	}
}
