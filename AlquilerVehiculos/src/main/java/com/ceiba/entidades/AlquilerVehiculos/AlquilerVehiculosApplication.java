package com.ceiba.entidades.AlquilerVehiculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ceiba.dominio.Vehiculo.RepositorioVehiculo;
import com.ceiba.persistencia.sistema.SistemaDePersistencia;

@SpringBootApplication
@ComponentScan(basePackages = "com.ceiba")
public class AlquilerVehiculosApplication {

	private static SistemaDePersistencia sistemaPersistencia;
	private static RepositorioVehiculo repositorioVehiculo;

	public static void main(String[] args) {
		sistemaPersistencia = new SistemaDePersistencia();

		repositorioVehiculo = sistemaPersistencia.obtenerRepositorioVehiculos();

		sistemaPersistencia.iniciar();

		SpringApplication.run(AlquilerVehiculosApplication.class, args);
	}

}
