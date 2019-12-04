package com.ceiba.alquilervehiculos.infrastructura.respositorio.usuario;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.databuilder.UsuarioDataBuilder;
import com.ceiba.alquilervehiculos.databuilder.UsuarioEntidadDataBuilder;
import com.ceiba.alquilervehiculos.dominio.modelo.Usuario;
import com.ceiba.alquilervehiculos.infrastructura.UsuarioRepositorioJPA;
import com.ceiba.alquilervehiculos.infrastructura.adaptador.repositorio.RepositorioUsuarioPersistente;
import com.ceiba.alquilervehiculos.infrastructura.entidades.UsuarioEntidad;

public class UsuarioRepositorioTest {

	@Test
	void registrarUsuario() {
		UsuarioEntidad usuarioEntidad = new UsuarioEntidadDataBuilder().build();
		Usuario usuario = new UsuarioDataBuilder().build();

		UsuarioRepositorioJPA usuarioRepositorioJPA = mock(UsuarioRepositorioJPA.class);

		RepositorioUsuarioPersistente repositorioUsuarioPersistente = new RepositorioUsuarioPersistente(
				usuarioRepositorioJPA);

		assertDoesNotThrow(() -> usuarioRepositorioJPA.save(usuarioEntidad));
		assertDoesNotThrow(() -> repositorioUsuarioPersistente.registrarUsuario(usuario));
	}
}
