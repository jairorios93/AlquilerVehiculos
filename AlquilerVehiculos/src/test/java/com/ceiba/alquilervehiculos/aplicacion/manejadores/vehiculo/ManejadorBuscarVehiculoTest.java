package com.ceiba.alquilervehiculos.aplicacion.manejadores.vehiculo;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;
import com.ceiba.alquilervehiculos.databuilder.ComandoVehiculoDataBuilder;
import com.ceiba.alquilervehiculos.dominio.servicio.vehiculo.ServicioBuscarVehiculo;

public class ManejadorBuscarVehiculoTest {

	@Test
	public void execute() {
		ComandoVehiculo command = new ComandoVehiculoDataBuilder().build();
		ServicioBuscarVehiculo service = mock(ServicioBuscarVehiculo.class);
		doReturn(command).when(service).buscarVehiculo("ASF122");

		ManejadorBuscarVehiculo handler = new ManejadorBuscarVehiculo(service);
		// act - assert
		assertNotNull(handler.buscarVehiculo("ASF122"));
	}
}
