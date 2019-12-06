package com.ceiba.alquilervehiculos.dominio.servicio.vehiculo;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.alquilervehiculos.databuilder.VehiculoDTODataBuilder;
import com.ceiba.alquilervehiculos.dominio.modelo.dto.VehiculoDTO;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioVehiculo;

public class ServicioBuscarVehiculoTest {

	@Test
	void obtenerUsuario() {
		RepositorioVehiculo repositorioVehiculo = mock(RepositorioVehiculo.class);
		VehiculoDTO vehiculoDTO = new VehiculoDTODataBuilder().build();

		Mockito.when(repositorioVehiculo.buscarVehiculo("ASF13")).thenReturn(vehiculoDTO);
		ServicioBuscarVehiculo service = new ServicioBuscarVehiculo(repositorioVehiculo);

		VehiculoDTO resultado = service.buscarVehiculo("ASF13");

		assertNotNull(resultado);
	}
}
