package com.ceiba.alquilervehiculos.infrastructura.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.alquilervehiculos.dominio.modelo.Usuario;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioUsuario;
import com.ceiba.alquilervehiculos.infrastructura.UsuarioRepositorioJPA;
import com.ceiba.alquilervehiculos.infrastructura.adaptador.builder.UsuarioBuilder;

@Repository
public class RepositorioUsuarioPersistente implements RepositorioUsuario {

	private final UsuarioRepositorioJPA usuarioRepositorioJPA;

	public RepositorioUsuarioPersistente(UsuarioRepositorioJPA usuarioRepositorioJPA) {
		this.usuarioRepositorioJPA = usuarioRepositorioJPA;
	}

	@Override
	public void registrarUsuario(Usuario usuario) {
		usuarioRepositorioJPA.save(UsuarioBuilder.convertirAEntity(usuario));
	}

}
