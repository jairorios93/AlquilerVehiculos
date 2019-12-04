package com.ceiba.alquilervehiculos.infrastructura.adaptador.repositorio;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import java.util.Optional;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;
import com.ceiba.alquilervehiculos.dominio.modelo.Usuario;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioUsuario;
import com.ceiba.alquilervehiculos.infrastructura.UsuarioRepositorioJPA;
import com.ceiba.alquilervehiculos.infrastructura.adaptador.builder.UsuarioBuilder;
import com.ceiba.alquilervehiculos.infrastructura.entidades.UsuarioEntidad;

@Repository
public class RepositorioUsuarioPersistente implements RepositorioUsuario {

	private final UsuarioRepositorioJPA usuarioRepositorioJPA;
	private ModelMapper modelMapper = new ModelMapper();

	public RepositorioUsuarioPersistente(UsuarioRepositorioJPA usuarioRepositorioJPA) {
		this.usuarioRepositorioJPA = usuarioRepositorioJPA;
	}

	@Override
	public void registrarUsuario(Usuario usuario) {
		usuarioRepositorioJPA.save(UsuarioBuilder.convertirAEntity(usuario));
	}

	@Override
	public ComandoUsuario buscarUsuario(Long cedula) {
		Optional<UsuarioEntidad> usuarioEntidad = usuarioRepositorioJPA.findById(cedula);
		return usuarioEntidad.isPresent() ? modelMapper.map(usuarioEntidad.get(), ComandoUsuario.class) : null;
	}

}