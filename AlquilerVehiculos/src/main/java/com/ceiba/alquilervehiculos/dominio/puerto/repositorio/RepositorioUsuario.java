package com.ceiba.alquilervehiculos.dominio.puerto.repositorio;

import com.ceiba.alquilervehiculos.dominio.modelo.Usuario;
import com.ceiba.alquilervehiculos.dominio.modelo.dto.UsuarioDTO;

public interface RepositorioUsuario {

	public void registrarUsuario(Usuario usuario);

	public UsuarioDTO buscarUsuario(Long cedula);
}
