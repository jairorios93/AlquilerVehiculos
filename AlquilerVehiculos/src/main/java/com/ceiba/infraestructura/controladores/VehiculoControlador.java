package com.ceiba.infraestructura.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculoControlador {

	@RequestMapping("/prueba")
	public String prueba() {
		return "Consumo servicio";
	}
}