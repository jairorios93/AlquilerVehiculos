package com.ceiba.alquilervehiculos.aplicacion.manejadores.usuario;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;
import com.ceiba.alquilervehiculos.dominio.servicio.usuario.ServicioBuscarUsuario;

@Service
public class ManejadorBuscarUsuario {

	private final ServicioBuscarUsuario servicioBuscarUsuario;

	public ManejadorBuscarUsuario(ServicioBuscarUsuario servicioBuscarUsuario) {
		this.servicioBuscarUsuario = servicioBuscarUsuario;
	}

	@Transactional
	public ComandoUsuario buscarUsuario(Long cedula) {
		return servicioBuscarUsuario.buscarUsuario(cedula);
	}
}