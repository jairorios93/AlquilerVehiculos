package com.ceiba.alquilervehiculos.dominio.servicio.usuario;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;
import com.ceiba.alquilervehiculos.databuilder.ComandoUsuarioDataBuilder;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioUsuario;

public class ServicioBuscarUsuarioTest {

	@Test
	void obtenerUsuario() {
		RepositorioUsuario repositorioUsuario = mock(RepositorioUsuario.class);
		ComandoUsuario comandoUsuario = new ComandoUsuarioDataBuilder().build();
		Mockito.when(repositorioUsuario.buscarUsuario(Long.valueOf("1094935130"))).thenReturn(comandoUsuario);
		ServicioBuscarUsuario service = new ServicioBuscarUsuario(repositorioUsuario);

		ComandoUsuario resultado = service.buscarUsuario(Long.valueOf("1094935130"));

		assertNotNull(resultado);
	}
}
