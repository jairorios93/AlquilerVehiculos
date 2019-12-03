package com.ceiba.alquilervehiculos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.alquilervehiculos.databuilder.VehiculoDataBuilder;
import com.ceiba.alquilervehiculos.dominio.modelo.Vehiculo;
import com.ceiba.alquilervehiculos.infrastructura.adaptador.repositorio.RepositorioVehiculoPersistente;
import com.ceiba.alquilervehiculos.infrastructura.entidades.VehiculoEntidad;

@RunWith(SpringRunner.class)
@AutoConfigureTestEntityManager
@Transactional
@SpringBootTest
public class IntegracionTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private RepositorioVehiculoPersistente repositorioVehiculoPersistente;

	@Test
	public void registrarVehiculoTest() {
		Vehiculo vehiculo = new VehiculoDataBuilder().build();
		repositorioVehiculoPersistente.registrarVehiculo(vehiculo);

		VehiculoEntidad vehiculoEntidad = entityManager.find(VehiculoEntidad.class, 1L);
		assertEquals(vehiculo.getPlaca(), vehiculoEntidad.getPlaca());
	}
}
