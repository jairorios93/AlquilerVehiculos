package com.ceiba.alquilervehiculos.dominio.servicio.alquiler;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.databuilder.AlquilarVehiculoDataBuilder;
import com.ceiba.alquilervehiculos.dominio.modelo.AlquilarVehiculo;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioAlquilarVehiculo;

public class ServicioAlquilarVehiculoTest {

	@Test
	void alquilarVehiculo() {
		AlquilarVehiculo alquilarVehiculo = new AlquilarVehiculoDataBuilder().build();
		RepositorioAlquilarVehiculo repositorioAlquilarVehiculo = mock(RepositorioAlquilarVehiculo.class);

		ServicioAlquilarVehiculo service = new ServicioAlquilarVehiculo(repositorioAlquilarVehiculo);
		assertDoesNotThrow(() -> service.alquilarVehiculo(alquilarVehiculo));
	}
}
