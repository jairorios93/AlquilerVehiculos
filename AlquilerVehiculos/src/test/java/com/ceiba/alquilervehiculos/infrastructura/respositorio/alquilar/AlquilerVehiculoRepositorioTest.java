package com.ceiba.alquilervehiculos.infrastructura.respositorio.alquilar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.databuilder.AlquilarVehiculoDataBuilder;
import com.ceiba.alquilervehiculos.databuilder.AlquilarVehiculoEntidadDataBuilder;
import com.ceiba.alquilervehiculos.dominio.modelo.AlquilarVehiculo;
import com.ceiba.alquilervehiculos.infrastructura.AlquilarVehiculoRepositorioJPA;
import com.ceiba.alquilervehiculos.infrastructura.adaptador.repositorio.RepositorioAlquilarVehiculoPersistente;
import com.ceiba.alquilervehiculos.infrastructura.entidades.AlquilarVehiculoEntidad;

public class AlquilerVehiculoRepositorioTest {

	@Test
	void alquilarVehiculo() {
		AlquilarVehiculoEntidad alquilarVehiculoEntidad = new AlquilarVehiculoEntidadDataBuilder().build();
		AlquilarVehiculo alquilarVehiculo = new AlquilarVehiculoDataBuilder().build();

		AlquilarVehiculoRepositorioJPA alquilarVehiculoRepositorioJPA = mock(AlquilarVehiculoRepositorioJPA.class);

		RepositorioAlquilarVehiculoPersistente repositorioAlquilarVehiculoPersistente = new RepositorioAlquilarVehiculoPersistente(
				alquilarVehiculoRepositorioJPA);

		assertDoesNotThrow(() -> alquilarVehiculoRepositorioJPA.save(alquilarVehiculoEntidad));
		assertDoesNotThrow(() -> repositorioAlquilarVehiculoPersistente.alquilarVehiculo(alquilarVehiculo));
	}
}
