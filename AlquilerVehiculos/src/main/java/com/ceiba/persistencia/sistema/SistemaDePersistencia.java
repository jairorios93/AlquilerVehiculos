package com.ceiba.persistencia.sistema;

import javax.persistence.EntityManager;

import com.ceiba.dominio.Vehiculo.RepositorioVehiculo;
import com.ceiba.persistencia.conexion.ConexionJPA;
import com.ceiba.persistencia.repositorio.RepositorioVehiculoPersistente;

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
