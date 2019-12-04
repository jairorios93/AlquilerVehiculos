package com.ceiba.alquilervehiculos.infrastructura.adaptador.builder;

import com.ceiba.alquilervehiculos.dominio.modelo.Usuario;
import com.ceiba.alquilervehiculos.infrastructura.entidades.UsuarioEntidad;

public class UsuarioBuilder {

	public UsuarioBuilder() {
	}

	public static UsuarioEntidad convertirAEntity(Usuario usuario) {
		UsuarioEntidad usuarioEntidad = new UsuarioEntidad();
		usuarioEntidad.setCedula(usuario.getCedula());
		usuarioEntidad.setNombres(usuario.getNombres());
		usuarioEntidad.setApellidos(usuario.getApellidos());
		usuarioEntidad.setFechaNacimiento(usuario.getFechaNacimiento());
		return usuarioEntidad;
	}
}
