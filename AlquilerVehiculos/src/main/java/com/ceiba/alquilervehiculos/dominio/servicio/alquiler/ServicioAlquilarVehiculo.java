package com.ceiba.alquilervehiculos.dominio.servicio.alquiler;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.alquilervehiculos.dominio.excepciones.ExcepcionNegocio;
import com.ceiba.alquilervehiculos.dominio.modelo.AlquilarVehiculo;
import com.ceiba.alquilervehiculos.dominio.modelo.dto.AlquilarVehiculoDTO;
import com.ceiba.alquilervehiculos.dominio.puerto.repositorio.RepositorioAlquilarVehiculo;

public class ServicioAlquilarVehiculo {

	private RepositorioAlquilarVehiculo repositorioAlquilarVehiculo;
	private static final String VEHICULO_SIN_DEVOLVER = "El vehiculo no ha sido devuelto todavia";
	private static final double DESCUENTO_CUMPLEANIOS = 0.1;

	public ServicioAlquilarVehiculo(RepositorioAlquilarVehiculo repositorioAlquilarVehiculo) {
		this.repositorioAlquilarVehiculo = repositorioAlquilarVehiculo;
	}

	public void alquilarVehiculo(AlquilarVehiculo alquilarVehiculo) {
		AlquilarVehiculoDTO alquilarVehiculoDTO = repositorioAlquilarVehiculo
				.buscarAlquilarVehiculo(alquilarVehiculo.getVehiculo().getPlaca());
		if (alquilarVehiculoDTO != null && alquilarVehiculoDTO.isEstado()) {
			throw new ExcepcionNegocio(VEHICULO_SIN_DEVOLVER);
		} else {
			alquilarVehiculo.setEstado(true);

			GregorianCalendar fechaNacimiento = fechaAjustada(alquilarVehiculo.getUsuario().getFechaNacimiento());
			alquilarVehiculo.getUsuario().setFechaNacimiento(fechaNacimiento.getTime());

			GregorianCalendar fechaPrestamo = fechaAjustada(alquilarVehiculo.getFechaInicio());
			alquilarVehiculo.setFechaInicio(fechaPrestamo.getTime());

			GregorianCalendar fechaDevolucion = fechaAjustada(alquilarVehiculo.getFechaFin());
			alquilarVehiculo.setFechaFin(fechaDevolucion.getTime());

			if (fechaNacimiento.get(Calendar.MONTH) == fechaPrestamo.get(Calendar.MONTH)
					&& fechaNacimiento.get(Calendar.DAY_OF_MONTH) == fechaPrestamo.get(Calendar.DAY_OF_MONTH)) {

				double nuevoValorAlquiler = alquilarVehiculo.getVehiculo().getPrecio()
						- (alquilarVehiculo.getVehiculo().getPrecio() * DESCUENTO_CUMPLEANIOS);

				alquilarVehiculo.setValor(nuevoValorAlquiler);
			}
			repositorioAlquilarVehiculo.alquilarVehiculo(alquilarVehiculo);
		}
	}
	
	public GregorianCalendar fechaAjustada(Date fechaOriginal) {
		GregorianCalendar fechaAjustada = new GregorianCalendar();
		fechaAjustada.setTime(fechaOriginal);
		fechaAjustada.add(Calendar.DATE, 1);
		return fechaAjustada;
	}
}