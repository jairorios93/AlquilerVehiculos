package com.ceiba.alquilervehiculos.infrastructura.controladores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;
import com.ceiba.alquilervehiculos.aplicacion.manejadores.usuario.ManejadorCrearUsuario;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

	private final ManejadorCrearUsuario manejadorCrearUsuario;

	public UsuarioControlador(ManejadorCrearUsuario manejadorCrearUsuario) {
		this.manejadorCrearUsuario = manejadorCrearUsuario;
	}
	
	@PostMapping("/registrarUsuario")
	public void registrarUsuario(@RequestBody ComandoUsuario usuario) {
		manejadorCrearUsuario.registrarUsuario(usuario);
	}

}
