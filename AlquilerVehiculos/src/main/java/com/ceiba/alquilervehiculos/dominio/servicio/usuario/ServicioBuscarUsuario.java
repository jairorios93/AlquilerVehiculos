package com.ceiba.alquilervehiculos.dominio.servicio.usuario;

import com.ceiba.alquilervehiculos.dominio.modelo.dto.UsuarioDTO;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioUsuario;

public class ServicioBuscarUsuario {

	private RepositorioUsuario repositorioUsuario;

	public ServicioBuscarUsuario(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}

	public UsuarioDTO buscarUsuario(Long cedula) {
		return repositorioUsuario.buscarUsuario(cedula);
	}
}
