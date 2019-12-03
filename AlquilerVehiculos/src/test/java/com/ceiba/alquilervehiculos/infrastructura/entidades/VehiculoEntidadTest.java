package com.ceiba.alquilervehiculos.infrastructura.entidades;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.databuilder.VehiculoEntidadDataBuilder;

public class VehiculoEntidadTest {

	@Test
	void instanciaCorrecta() {
		VehiculoEntidad vehiculo = new VehiculoEntidadDataBuilder().build();

		assertNotNull(vehiculo);
	}

	@Test
	void getters() {
		VehiculoEntidad vehiculo = new VehiculoEntidadDataBuilder().build();
		assertNotNull(vehiculo.getPlaca());
		assertNotNull(vehiculo.getModelo());
		assertNotNull(vehiculo.getMarca());
		assertNotNull(vehiculo.getColor());
		assertNotNull(vehiculo.getPrecio());
	}

	@Test
	void setters() {
		VehiculoEntidad vehiculo = new VehiculoEntidadDataBuilder().build();
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
