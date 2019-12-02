package com.ceiba.persistencia.repositorio;

import javax.persistence.EntityManager;

import com.ceiba.dominio.Vehiculo.RepositorioVehiculo;


public class RepositorioVehiculoPersistente implements RepositorioVehiculo{

	private EntityManager entityManager;

	public RepositorioVehiculoPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
