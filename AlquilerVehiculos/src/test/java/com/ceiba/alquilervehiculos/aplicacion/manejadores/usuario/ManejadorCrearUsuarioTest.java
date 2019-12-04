package com.ceiba.alquilervehiculos.aplicacion.manejadores.usuario;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;
import com.ceiba.alquilervehiculos.aplicacion.fabrica.FabricaUsuario;
import com.ceiba.alquilervehiculos.databuilder.ComandoUsuarioDataBuilder;
import com.ceiba.alquilervehiculos.dominio.servicio.usuario.ServicioCrearUsuario;

public class ManejadorCrearUsuarioTest {

	@Test
	public void execute() {
		ComandoUsuario command = new ComandoUsuarioDataBuilder().build();
		ServicioCrearUsuario service = mock(ServicioCrearUsuario.class);

		FabricaUsuario fabricaUsuario = new FabricaUsuario();
		ManejadorCrearUsuario handler = new ManejadorCrearUsuario(fabricaUsuario, service);

		assertDoesNotThrow(() -> handler.registrarUsuario(command));
	}

}
