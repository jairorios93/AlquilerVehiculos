package com.ceiba.alquilervehiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ceiba.alquilervehiculos.dominio.repositorio.RepositorioVehiculo;
import com.ceiba.alquilervehiculos.dominio.repositorio.persistencia.SistemaDePersistencia;

@SpringBootApplication
@ComponentScan(basePackages = "com.ceiba")
public class AlquilerVehiculosApplication {

	public static SistemaDePersistencia sistemaPersistencia;
	public static RepositorioVehiculo repositorioVehiculo;

	public static void main(String[] args) {
		sistemaPersistencia = new SistemaDePersistencia();

		repositorioVehiculo = sistemaPersistencia.obtenerRepositorioVehiculos();

		sistemaPersistencia.iniciar();

		SpringApplication.run(AlquilerVehiculosApplication.class, args);
	}

}
