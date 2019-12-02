package com.ceiba.alquilervehiculos.dominio.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {
	
	private static final String ALQUILER = "alquiler";
	private static EntityManagerFactory entityManagerFactory;

	public ConexionJPA() {
		entityManagerFactory = Persistence.createEntityManagerFactory(ALQUILER);
	}
	
	public EntityManager createEntityManager() {
		return entityManagerFactory.createEntityManager();
	}
}
