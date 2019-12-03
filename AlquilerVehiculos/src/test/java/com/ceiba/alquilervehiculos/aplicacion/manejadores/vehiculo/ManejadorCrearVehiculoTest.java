package com.ceiba.alquilervehiculos.aplicacion.manejadores.vehiculo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;
import com.ceiba.alquilervehiculos.aplicacion.fabrica.FabricaVehiculo;
import com.ceiba.alquilervehiculos.databuilder.ComandoVehiculoDataBuilder;
import com.ceiba.alquilervehiculos.dominio.servicio.vehiculo.ServicioCrearVehiculo;

public class ManejadorCrearVehiculoTest {

	@Test
	void execute() {
		ComandoVehiculo command = new ComandoVehiculoDataBuilder().build();
		ServicioCrearVehiculo service = mock(ServicioCrearVehiculo.class);

		FabricaVehiculo fabricaVehiculo = new FabricaVehiculo();
		ManejadorCrearVehiculo handler = new ManejadorCrearVehiculo(fabricaVehiculo, service);

		assertDoesNotThrow(() -> handler.registrarVehiculo(command));
	}
}
