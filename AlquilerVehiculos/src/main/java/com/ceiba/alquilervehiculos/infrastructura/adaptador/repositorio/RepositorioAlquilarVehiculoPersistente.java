package com.ceiba.alquilervehiculos.infrastructura.adaptador.repositorio;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.ceiba.alquilervehiculos.dominio.modelo.AlquilarVehiculo;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioAlquilarVehiculo;
import com.ceiba.alquilervehiculos.infrastructura.AlquilarVehiculoRepositorioJPA;
import com.ceiba.alquilervehiculos.infrastructura.entidades.AlquilarVehiculoEntidad;

@Repository
public class RepositorioAlquilarVehiculoPersistente implements RepositorioAlquilarVehiculo {

	private final AlquilarVehiculoRepositorioJPA alquilarVehiculoRepositorioJPA;
	private ModelMapper modelMapper = new ModelMapper();

	public RepositorioAlquilarVehiculoPersistente(AlquilarVehiculoRepositorioJPA alquilarVehiculoRepositorioJPA) {
		this.alquilarVehiculoRepositorioJPA = alquilarVehiculoRepositorioJPA;
	}

	@Override
	public void alquilarVehiculo(AlquilarVehiculo alquilarVehiculo) {
		AlquilarVehiculoEntidad alquilarVehiculoEntidad = modelMapper.map(alquilarVehiculo,
				AlquilarVehiculoEntidad.class);
		alquilarVehiculoRepositorioJPA.save(alquilarVehiculoEntidad);
	}
}