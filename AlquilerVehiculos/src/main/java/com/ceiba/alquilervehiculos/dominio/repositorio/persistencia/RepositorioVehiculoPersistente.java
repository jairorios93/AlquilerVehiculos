package com.ceiba.alquilervehiculos.dominio.repositorio.persistencia;

import javax.persistence.EntityManager;

import com.ceiba.alquilervehiculos.dominio.repositorio.RepositorioVehiculo;

public class RepositorioVehiculoPersistente implements RepositorioVehiculo {

	private EntityManager entityManager;

	public RepositorioVehiculoPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
