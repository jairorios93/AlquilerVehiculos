package com.ceiba.alquilervehiculos.dominio.servicio.vehiculo;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

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
		
		List<ComandoVehiculo> vehiculos = new ArrayList<ComandoVehiculo>();
		vehiculos.add(comandoVehiculo);
		
		Mockito.when(repositorioVehiculo.buscarVehiculo("ASF13")).thenReturn(vehiculos);
		ServicioBuscarVehiculo service = new ServicioBuscarVehiculo(repositorioVehiculo);

		ComandoVehiculo resultado = service.buscarVehiculo("ASF13");

		assertNotNull(resultado);
	}
}
