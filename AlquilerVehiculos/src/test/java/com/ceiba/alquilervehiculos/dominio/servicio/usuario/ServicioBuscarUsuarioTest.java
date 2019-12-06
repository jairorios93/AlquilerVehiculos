package com.ceiba.alquilervehiculos.dominio.servicio.usuario;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.alquilervehiculos.databuilder.UsuarioDTODataBuilder;
import com.ceiba.alquilervehiculos.dominio.modelo.dto.UsuarioDTO;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioUsuario;

public class ServicioBuscarUsuarioTest {

	@Test
	void obtenerUsuario() {
		RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
		UsuarioDTO usuarioDTO = new UsuarioDTODataBuilder().build();
		Mockito.when(repositorioUsuario.buscarUsuario(Long.valueOf("1094935130"))).thenReturn(usuarioDTO);
		ServicioBuscarUsuario service = new ServicioBuscarUsuario(repositorioUsuario);

		UsuarioDTO resultado = service.buscarUsuario(Long.valueOf("1094935130"));

		assertNotNull(resultado);
	}
}
