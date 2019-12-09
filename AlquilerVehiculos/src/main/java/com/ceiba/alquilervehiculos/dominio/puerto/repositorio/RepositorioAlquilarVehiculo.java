package com.ceiba.alquilervehiculos.dominio.puerto.repositorio;

import java.util.Date;

import com.ceiba.alquilervehiculos.dominio.modelo.AlquilarVehiculo;
import com.ceiba.alquilervehiculos.dominio.modelo.dto.AlquilarVehiculoDTO;

public interface RepositorioAlquilarVehiculo {

	public void alquilarVehiculo(AlquilarVehiculo alquilarVehiculo);

	public AlquilarVehiculoDTO buscarAlquilarVehiculo(String placa);

	public void devolverVehiculo(Long id, boolean estado, Date fecha, double valor);

}