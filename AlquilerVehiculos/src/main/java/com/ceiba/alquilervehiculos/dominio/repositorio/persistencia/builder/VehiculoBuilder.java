package com.ceiba.alquilervehiculos.dominio.repositorio.persistencia.builder;

import com.ceiba.alquilervehiculos.dominio.modelo.Vehiculo;
import com.ceiba.alquilervehiculos.dominio.modelo.entidad.VehiculoEntidad;

public class VehiculoBuilder {

	public VehiculoBuilder() {
	}

	public static VehiculoEntidad convertirAEntity(Vehiculo vehiculo) {
		VehiculoEntidad vehiculoEntidad = new VehiculoEntidad();
		vehiculoEntidad.setModelo(vehiculo.getModelo());
		vehiculoEntidad.setMarca(vehiculo.getMarca());
		vehiculoEntidad.setColor(vehiculo.getColor());
		vehiculoEntidad.setPrecio(vehiculo.getPrecio());
		return vehiculoEntidad;
	}

}
