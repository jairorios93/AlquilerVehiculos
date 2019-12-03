package com.ceiba.alquilervehiculos.dominio.modelo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.databuilder.VehiculoDataBuilder;

public class VehiculoTest {

	@Test
	void instanciaCorrecta() {
		Vehiculo vehiculo = new VehiculoDataBuilder().build();

		assertNotNull(vehiculo);
	}

	@Test
	void getters() {
		Vehiculo vehiculo = new VehiculoDataBuilder().build();
		assertNotNull(vehiculo.getPlaca());
		assertNotNull(vehiculo.getModelo());
		assertNotNull(vehiculo.getMarca());
		assertNotNull(vehiculo.getColor());
		assertNotNull(vehiculo.getPrecio());
	}

	@Test
	void setters() {
		Vehiculo vehiculo = new VehiculoDataBuilder().build();
		vehiculo.setId(null);
		vehiculo.setPlaca(null);
		vehiculo.setModelo(null);
		vehiculo.setMarca(null);
		vehiculo.setColor(null);
		vehiculo.setPrecio(0);

		assertNull(vehiculo.getId());
		assertNull(vehiculo.getPlaca());
		assertNull(vehiculo.getModelo());
		assertNull(vehiculo.getMarca());
		assertNull(vehiculo.getColor());
		assertEquals(0, vehiculo.getPrecio(), 0.0);
	}
}
