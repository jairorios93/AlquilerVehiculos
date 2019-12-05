package com.ceiba.alquilervehiculos.infrastructura.respositorio.vehiculo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.databuilder.VehiculoDataBuilder;
import com.ceiba.alquilervehiculos.databuilder.VehiculoEntidadDataBuilder;
import com.ceiba.alquilervehiculos.dominio.modelo.Vehiculo;
import com.ceiba.alquilervehiculos.infrastructura.VehiculoRepositorioJPA;
import com.ceiba.alquilervehiculos.infrastructura.adaptador.repositorio.RepositorioVehiculoPersistente;
import com.ceiba.alquilervehiculos.infrastructura.entidades.VehiculoEntidad;

public class VehiculoRepositorioTest {

	@Test
	void registrarVehiculo() {
		VehiculoEntidad vehiculoEntidad = new VehiculoEntidadDataBuilder().build();
		Vehiculo vehiculo = new VehiculoDataBuilder().build();
		VehiculoRepositorioJPA vehiculoRepositorioJPA = mock(VehiculoRepositorioJPA.class);
		RepositorioVehiculoPersistente repositorioVehiculoPersistente = new RepositorioVehiculoPersistente(
				vehiculoRepositorioJPA);

		assertDoesNotThrow(() -> vehiculoRepositorioJPA.save(vehiculoEntidad));
		assertDoesNotThrow(() -> repositorioVehiculoPersistente.registrarVehiculo(vehiculo));

	}

	@Test
	void buscarVehiculo() {
		VehiculoEntidad vehiculoEntidad = new VehiculoEntidadDataBuilder().build();
		VehiculoRepositorioJPA vehiculoRepositorioJPA = mock(VehiculoRepositorioJPA.class);
		RepositorioVehiculoPersistente repositorioVehiculoPersistente = new RepositorioVehiculoPersistente(
				vehiculoRepositorioJPA);

		when(vehiculoRepositorioJPA.buscarVehiculo("ASF12")).thenReturn(vehiculoEntidad);

		assertNotNull(repositorioVehiculoPersistente.buscarVehiculo("ASF12"));
	}
}
