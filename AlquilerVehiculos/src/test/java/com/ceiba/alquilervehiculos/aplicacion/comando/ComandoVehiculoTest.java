package com.ceiba.alquilervehiculos.aplicacion.comando;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.databuilder.ComandoVehiculoDataBuilder;

public class ComandoVehiculoTest {

	@Test
	void getters() {
		ComandoVehiculo command = new ComandoVehiculo();
		assertNull(command.getId());
		assertNull(command.getPlaca());
		assertNull(command.getModelo());
		assertNull(command.getMarca());
		assertNull(command.getColor());
		assertEquals(0, command.getPrecio(), 0.0);
	}

	@Test
	void setters() {
		ComandoVehiculo command = new ComandoVehiculoDataBuilder().build();
		command.setId(null);
		command.setPlaca(null);
		command.setModelo(null);
		command.setMarca(null);
		command.setColor(null);
		command.setPrecio(0);

		assertNull(command.getId());
		assertNull(command.getPlaca());
		assertNull(command.getModelo());
		assertNull(command.getMarca());
		assertNull(command.getColor());
		assertEquals(0, command.getPrecio(), 0.0);
	}
}
