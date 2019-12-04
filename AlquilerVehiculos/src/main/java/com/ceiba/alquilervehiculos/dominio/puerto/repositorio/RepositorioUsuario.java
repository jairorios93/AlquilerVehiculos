package com.ceiba.alquilervehiculos.dominio.puerto.repositorio;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;
import com.ceiba.alquilervehiculos.dominio.modelo.Usuario;

public interface RepositorioUsuario {

	public void registrarUsuario(Usuario usuario);

	public ComandoUsuario buscarUsuario(Long cedula);
}
