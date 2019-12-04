package com.ceiba.alquilervehiculos.aplicacion.manejadores.usuario;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;
import com.ceiba.alquilervehiculos.databuilder.ComandoUsuarioDataBuilder;
import com.ceiba.alquilervehiculos.dominio.servicio.usuario.ServicioBuscarUsuario;

public class ManejadorBuscarUsuarioTest {

	@Test
	public void execute() {
		ComandoUsuario command = new ComandoUsuarioDataBuilder().build();
		ServicioBuscarUsuario service = mock(ServicioBuscarUsuario.class);
		doReturn(command).when(service).buscarUsuario(Long.valueOf("1094935130"));

		ManejadorBuscarUsuario handler = new ManejadorBuscarUsuario(service);
		// act - assert
		assertNotNull(handler.buscarUsuario(Long.valueOf("1094935130")));
	}
}
