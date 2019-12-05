package com.ceiba.alquilervehiculos.infrastructura.controlador.alquiler;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoAlquilarVehiculo;
import com.ceiba.alquilervehiculos.aplicacion.manejadores.alquiler.ManejadorAlquilarVehiculo;
import com.ceiba.alquilervehiculos.databuilder.ComandoAlquilarVehiculoDataBuilder;
import com.ceiba.alquilervehiculos.infrastructura.controladores.AlquilerControlador;

public class AlquilerControladorTest {

	private ManejadorAlquilarVehiculo manejadorAlquilarVehiculo = mock(ManejadorAlquilarVehiculo.class);

	@Test
	void alquilarVehiculo() {
		ComandoAlquilarVehiculo alquilarVehiculo = new ComandoAlquilarVehiculoDataBuilder().build();

		AlquilerControlador controlador = new AlquilerControlador(manejadorAlquilarVehiculo);
		controlador.alquilarVehiculo(alquilarVehiculo);

		assertDoesNotThrow(() -> controlador.alquilarVehiculo(alquilarVehiculo));
	}
}
