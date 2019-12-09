package com.ceiba.alquilervehiculos.infrastructura;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ceiba.alquilervehiculos.infrastructura.entidades.AlquilarVehiculoEntidad;

@Repository
public interface AlquilarVehiculoRepositorioJPA extends JpaRepository<AlquilarVehiculoEntidad, Long> {

	@Query("select a from AlquilarVehiculoEntidad a where a.vehiculo.placa = ?1")
	public AlquilarVehiculoEntidad buscarAlquiler(String placa);

	@Modifying
	@Query("update AlquilarVehiculoEntidad a set a.estado = ?2, a.fechaFin = ?3, a.valor = ?4 where a.id = ?1")
	public void devolverVehiculo(Long id, boolean estado, Date fecha, double valor);
}
