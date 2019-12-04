package com.ceiba.alquilervehiculos.infrastructura.controlador.usuario;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;
import com.ceiba.alquilervehiculos.aplicacion.manejadores.usuario.ManejadorBuscarUsuario;
import com.ceiba.alquilervehiculos.aplicacion.manejadores.usuario.ManejadorCrearUsuario;
import com.ceiba.alquilervehiculos.databuilder.ComandoUsuarioDataBuilder;
import com.ceiba.alquilervehiculos.infrastructura.controladores.UsuarioControlador;

public class UsuarioControladorTest {

	private ManejadorCrearUsuario manejadorCrearUsuario = mock(ManejadorCrearUsuario.class);
	private ManejadorBuscarUsuario manejadorBuscarUsuario = mock(ManejadorBuscarUsuario.class);

	@Test
	void registrarUsuario() {
		ComandoUsuario usuario = new ComandoUsuarioDataBuilder().build();

		UsuarioControlador controlador = new UsuarioControlador(manejadorCrearUsuario, manejadorBuscarUsuario);
		controlador.registrarUsuario(usuario);

		assertDoesNotThrow(() -> controlador.registrarUsuario(usuario));
	}

	@Test
	void buscarUsuario() {
		UsuarioControlador controlador = new UsuarioControlador(manejadorCrearUsuario, manejadorBuscarUsuario);
		assertDoesNotThrow(() -> controlador.buscarUsuario(1L));
	}
}
