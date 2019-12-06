package com.ceiba.alquilervehiculos.infrastructura.controlador.usuario;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;
import com.ceiba.alquilervehiculos.aplicacion.manejadores.usuario.ManejadorBuscarUsuario;
import com.ceiba.alquilervehiculos.aplicacion.manejadores.usuario.ManejadorCrearUsuario;
import com.ceiba.alquilervehiculos.databuilder.ComandoUsuarioDataBuilder;
import com.ceiba.alquilervehiculos.infrastructura.controladores.UsuarioControlador;

public class UsuarioControladorTest {

	private ManejadorCrearUsuario manejadorCrearUsuario = mock(ManejadorCrearUsuario.class);
	private ManejadorBuscarUsuario manejadorBuscarUsuario = mock(ManejadorBuscarUsuario.class);

	@Autowired
	private MockMvc mvc;

	@Test
	void registrarUsuario() {
		ComandoUsuario usuario = new ComandoUsuarioDataBuilder().build();

		UsuarioControlador controlador = new UsuarioControlador(manejadorCrearUsuario, manejadorBuscarUsuario);
		controlador.registrarUsuario(usuario);

		assertDoesNotThrow(() -> controlador.registrarUsuario(usuario));
	}

	@Test
	void buscarUsuario() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/buscarUsuario/{CEDULA}", 1094935130).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

	}
}
