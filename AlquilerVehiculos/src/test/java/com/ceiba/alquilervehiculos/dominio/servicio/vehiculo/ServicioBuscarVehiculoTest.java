package com.ceiba.alquilervehiculos.dominio.servicio.vehiculo;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;
import com.ceiba.alquilervehiculos.databuilder.ComandoVehiculoDataBuilder;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioVehiculo;

public class ServicioBuscarVehiculoTest {

	@Test
	void obtenerUsuario() {
		RepositorioVehiculo repositorioVehiculo = mock(RepositorioVehiculo.class);
		ComandoVehiculo comandoVehiculo = new ComandoVehiculoDataBuilder().build();

		Mockito.when(repositorioVehiculo.buscarVehiculo("ASF13")).thenReturn(comandoVehiculo);
		ServicioBuscarVehiculo service = new ServicioBuscarVehiculo(repositorioVehiculo);

		ComandoVehiculo resultado = service.buscarVehiculo("ASF13");

		assertNotNull(resultado);
	}
}
