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

import com.ceiba.alquilervehiculos.databuilder.AlquilarVehiculoDataBuilder;
import com.ceiba.alquilervehiculos.databuilder.UsuarioDataBuilder;
import com.ceiba.alquilervehiculos.databuilder.VehiculoDataBuilder;
import com.ceiba.alquilervehiculos.dominio.modelo.AlquilarVehiculo;
import com.ceiba.alquilervehiculos.dominio.modelo.Usuario;
import com.ceiba.alquilervehiculos.dominio.modelo.Vehiculo;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioAlquilarVehiculo;
import com.ceiba.alquilervehiculos.infrastructura.adaptador.repositorio.RepositorioUsuarioPersistente;
import com.ceiba.alquilervehiculos.infrastructura.adaptador.repositorio.RepositorioVehiculoPersistente;
import com.ceiba.alquilervehiculos.infrastructura.entidades.AlquilarVehiculoEntidad;
import com.ceiba.alquilervehiculos.infrastructura.entidades.UsuarioEntidad;
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

	@Autowired
	private RepositorioUsuarioPersistente repositorioUsuarioPersistente;

	@Autowired
	private RepositorioAlquilarVehiculo repositorioAlquilarVehiculo;

	@Test
	public void alquilarVehiculo() {
		// Se guarda el vehiculo
		Vehiculo vehiculo = new VehiculoDataBuilder().build();
		repositorioVehiculoPersistente.registrarVehiculo(vehiculo);

		VehiculoEntidad vehiculoEntidad = entityManager.find(VehiculoEntidad.class, 1L);
		assertEquals(vehiculo.getPlaca(), vehiculoEntidad.getPlaca());

		// Se guarda el usuario
		Usuario usuario = new UsuarioDataBuilder().build();
		repositorioUsuarioPersistente.registrarUsuario(usuario);

		UsuarioEntidad usuarioEntidad = entityManager.find(UsuarioEntidad.class, usuario.getCedula());
		assertEquals(usuario.getCedula(), usuarioEntidad.getCedula());

		// Se guarda el alquiler
		AlquilarVehiculo alquilarVehiculo = new AlquilarVehiculoDataBuilder().build();

		alquilarVehiculo.setUsuario(usuario);
		alquilarVehiculo.setVehiculo(vehiculo);

		repositorioAlquilarVehiculo.alquilarVehiculo(alquilarVehiculo);
		AlquilarVehiculoEntidad alquilarVehiculoEntidad = entityManager.find(AlquilarVehiculoEntidad.class, 2L);

		assertEquals(alquilarVehiculo.getValor(), alquilarVehiculoEntidad.getValor());
	}

}
