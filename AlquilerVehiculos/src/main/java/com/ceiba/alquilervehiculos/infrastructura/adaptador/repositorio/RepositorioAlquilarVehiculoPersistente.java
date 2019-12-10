package com.ceiba.alquilervehiculos.infrastructura.adaptador.repositorio;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.ceiba.alquilervehiculos.dominio.modelo.AlquilarVehiculo;
import com.ceiba.alquilervehiculos.dominio.modelo.dto.AlquilarVehiculoDTO;
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
		alquilarVehiculoRepositorioJPA.findAll();
	}

	@Override
	public AlquilarVehiculoDTO buscarAlquilarVehiculo(String placa) {
		AlquilarVehiculoEntidad alquilarVehiculoEntidad = alquilarVehiculoRepositorioJPA.buscarAlquiler(placa);
		if (alquilarVehiculoEntidad != null) {
			return modelMapper.map(alquilarVehiculoEntidad, AlquilarVehiculoDTO.class);
		} else {
			return null;
		}
	}

	@Override
	public void devolverVehiculo(Long id, boolean estado, Date fecha, double valor) {
		alquilarVehiculoRepositorioJPA.devolverVehiculo(id, estado, fecha, valor);
	}

}