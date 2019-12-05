package com.ceiba.alquilervehiculos.aplicacion.manejadores.alquiler;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoAlquilarVehiculo;
import com.ceiba.alquilervehiculos.aplicacion.fabrica.FabricaAlquilarVehiculo;
import com.ceiba.alquilervehiculos.databuilder.ComandoAlquilarVehiculoDataBuilder;
import com.ceiba.alquilervehiculos.dominio.servicio.alquiler.ServicioAlquilarVehiculo;


public class ManejadorAlquilarVehiculoTest {

	@Test
	public void execute() {
		ComandoAlquilarVehiculo command = new ComandoAlquilarVehiculoDataBuilder().build();
		ServicioAlquilarVehiculo service = mock(ServicioAlquilarVehiculo.class);

		FabricaAlquilarVehiculo fabricaAlquilarVehiculo = new FabricaAlquilarVehiculo();
		ManejadorAlquilarVehiculo handler = new ManejadorAlquilarVehiculo(fabricaAlquilarVehiculo, service);

		assertDoesNotThrow(() -> handler.alquilarVehiculo(command));
	}
}
