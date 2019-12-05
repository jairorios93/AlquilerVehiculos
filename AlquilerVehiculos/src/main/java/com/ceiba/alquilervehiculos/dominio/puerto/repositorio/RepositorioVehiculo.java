package com.ceiba.alquilervehiculos.dominio.puerto.repositorio;

import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;
import com.ceiba.alquilervehiculos.dominio.modelo.Vehiculo;

public interface RepositorioVehiculo {

	public void registrarVehiculo(Vehiculo vehiculo);

	public ComandoVehiculo buscarVehiculo(String placa);
}