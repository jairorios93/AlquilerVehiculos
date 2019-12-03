package com.ceiba.alquilervehiculos.infrastructura.adaptador.repositorio;

import org.springframework.stereotype.Repository;

import com.ceiba.alquilervehiculos.dominio.modelo.Vehiculo;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.alquilervehiculos.infrastructura.VehiculoRepositorioJPA;
import com.ceiba.alquilervehiculos.infrastructura.adaptador.builder.VehiculoBuilder;

@Repository
public class RepositorioVehiculoPersistente implements RepositorioVehiculo {

	private final VehiculoRepositorioJPA vehiculoRepositorioJPA;

	public RepositorioVehiculoPersistente(VehiculoRepositorioJPA vehiculoRepositorioJPA) {
		this.vehiculoRepositorioJPA = vehiculoRepositorioJPA;
	}

	@Override
	public void registrarVehiculo(Vehiculo vehiculo) {
		vehiculoRepositorioJPA.save(VehiculoBuilder.convertirAEntity(vehiculo));
	}

}