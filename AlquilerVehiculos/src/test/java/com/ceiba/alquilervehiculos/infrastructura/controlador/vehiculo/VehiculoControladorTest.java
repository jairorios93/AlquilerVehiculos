package com.ceiba.alquilervehiculos.infrastructura.controlador.vehiculo;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;
import com.ceiba.alquilervehiculos.aplicacion.manejadores.vehiculo.ManejadorCrearVehiculo;
import com.ceiba.alquilervehiculos.databuilder.ComandoVehiculoDataBuilder;
import com.ceiba.alquilervehiculos.infrastructura.controladores.VehiculoControlador;

public class VehiculoControladorTest {

	private ManejadorCrearVehiculo manejadorCrearVehiculo = mock(ManejadorCrearVehiculo.class);
	
	@Test
	void registrarVehiculo() {
		ComandoVehiculo vehiculo = new ComandoVehiculoDataBuilder().build();

		VehiculoControlador controlador = new VehiculoControlador(manejadorCrearVehiculo);

		assertDoesNotThrow(() -> controlador.registrarVehiculo(vehiculo));
	}
}