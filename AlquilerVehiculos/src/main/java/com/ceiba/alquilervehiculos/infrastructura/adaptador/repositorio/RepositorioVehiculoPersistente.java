package com.ceiba.alquilervehiculos.infrastructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;
import com.ceiba.alquilervehiculos.dominio.modelo.Vehiculo;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioVehiculo;
import com.ceiba.alquilervehiculos.infrastructura.VehiculoRepositorioJPA;
import com.ceiba.alquilervehiculos.infrastructura.entidades.VehiculoEntidad;

@Repository
public class RepositorioVehiculoPersistente implements RepositorioVehiculo {

	private final VehiculoRepositorioJPA vehiculoRepositorioJPA;
	private ModelMapper modelMapper = new ModelMapper();

	public RepositorioVehiculoPersistente(VehiculoRepositorioJPA vehiculoRepositorioJPA) {
		this.vehiculoRepositorioJPA = vehiculoRepositorioJPA;
	}

	@Override
	public void registrarVehiculo(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad = modelMapper.map(vehiculo, VehiculoEntidad.class);
		vehiculoRepositorioJPA.save(vehiculoEntidad);
	}

	@Override
	public List<ComandoVehiculo> buscarVehiculo(String placa) {
		List<VehiculoEntidad> vehiculosEntidad = vehiculoRepositorioJPA.findAll();
		List<ComandoVehiculo> vehiculosComando = new ArrayList<>();
		for (VehiculoEntidad vehiculo : vehiculosEntidad) {
			ComandoVehiculo comandoVehiculo = modelMapper.map(vehiculo, ComandoVehiculo.class);
			vehiculosComando.add(comandoVehiculo);
		}
		return vehiculosComando;
	}

}