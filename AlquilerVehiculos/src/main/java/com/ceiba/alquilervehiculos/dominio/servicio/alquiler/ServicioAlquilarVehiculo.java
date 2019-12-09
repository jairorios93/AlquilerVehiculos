package com.ceiba.alquilervehiculos.dominio.servicio.alquiler;

import java.util.Calendar;
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

			GregorianCalendar fechaNacimiento = new GregorianCalendar();
			fechaNacimiento.setTime(alquilarVehiculo.getUsuario().getFechaNacimiento());
			fechaNacimiento.add(Calendar.DATE, 1);
			alquilarVehiculo.getUsuario().setFechaNacimiento(fechaNacimiento.getTime());

			GregorianCalendar fechaPrestamo = new GregorianCalendar();
			fechaPrestamo.setTime(alquilarVehiculo.getFechaInicio());
			fechaPrestamo.add(Calendar.DATE, 1);
			alquilarVehiculo.setFechaInicio(fechaPrestamo.getTime());

			GregorianCalendar fechaDevolucion = new GregorianCalendar();
			fechaDevolucion.setTime(alquilarVehiculo.getFechaFin());
			fechaDevolucion.add(Calendar.DATE, 1);
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
}