package com.ceiba.alquilervehiculos.dominio.repositorio.persistencia;

import javax.persistence.EntityManager;

import com.ceiba.alquilervehiculos.dominio.conexion.ConexionJPA;
import com.ceiba.alquilervehiculos.dominio.repositorio.RepositorioVehiculo;

public class SistemaDePersistencia {

	private EntityManager entityManager;

	public SistemaDePersistencia() {
		this.entityManager = new ConexionJPA().createEntityManager();
	}

	public RepositorioVehiculo obtenerRepositorioVehiculos() {
		return new RepositorioVehiculoPersistente(entityManager);
	}

	public void iniciar() {
		entityManager.getTransaction().begin();
	}

	public void terminar() {
		entityManager.getTransaction().commit();
	}

}