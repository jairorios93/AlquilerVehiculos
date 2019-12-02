package com.ceiba.alquilervehiculos.dominio.repositorio.persistencia;

import javax.persistence.EntityManager;

import com.ceiba.alquilervehiculos.dominio.modelo.Vehiculo;
import com.ceiba.alquilervehiculos.dominio.repositorio.RepositorioVehiculo;
import com.ceiba.alquilervehiculos.dominio.repositorio.persistencia.builder.VehiculoBuilder;

public class RepositorioVehiculoPersistente implements RepositorioVehiculo {

	private EntityManager entityManager;

	public RepositorioVehiculoPersistente(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void registrarVehiculo(Vehiculo vehiculo) {
		entityManager.persist(VehiculoBuilder.convertirAEntity(vehiculo));
	}

}