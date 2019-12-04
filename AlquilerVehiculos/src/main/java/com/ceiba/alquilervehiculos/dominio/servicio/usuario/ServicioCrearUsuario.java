package com.ceiba.alquilervehiculos.dominio.servicio.usuario;

import com.ceiba.alquilervehiculos.dominio.modelo.Usuario;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioUsuario;

public class ServicioCrearUsuario {

	private RepositorioUsuario repositorioUsuario;

	public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}

	public void ejecutar(Usuario usuario) {
		// Logica
		repositorioUsuario.registrarUsuario(usuario);
	}
}
