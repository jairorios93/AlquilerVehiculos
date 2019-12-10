package com.ceiba.alquilervehiculos.infrastructura.controlador.alquiler;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ceiba.alquilervehiculos.AlquilerVehiculosApplication;
import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoAlquilarVehiculo;
import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoUsuario;
import com.ceiba.alquilervehiculos.aplicacion.comando.ComandoVehiculo;
import com.ceiba.alquilervehiculos.databuilder.ComandoAlquilarVehiculoDataBuilder;
import com.ceiba.alquilervehiculos.databuilder.ComandoUsuarioDataBuilder;
import com.ceiba.alquilervehiculos.databuilder.ComandoVehiculoDataBuilder;
import com.ceiba.alquilervehiculos.databuilder.UsuarioDTODataBuilder;
import com.ceiba.alquilervehiculos.databuilder.VehiculoDTODataBuilder;
import com.ceiba.alquilervehiculos.dominio.modelo.dto.UsuarioDTO;
import com.ceiba.alquilervehiculos.dominio.modelo.dto.VehiculoDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlquilerVehiculosApplication.class)
@AutoConfigureMockMvc
@Transactional
public class AlquilerControladorTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private MockMvc mvc;

	@Before
	public void setup() throws Exception {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	void alquilarVehiculo() throws Exception {
		ComandoVehiculo comandoVehiculo = new ComandoVehiculoDataBuilder().build();
		mvc.perform(post("/vehiculo/registrarVehiculo").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(comandoVehiculo))).andDo(print()).andExpect(status().isOk());

		VehiculoDTO vehiculoDTO = new VehiculoDTODataBuilder().build();
		mvc.perform(
				get("/vehiculo/buscarVehiculo/{PLACA}", vehiculoDTO.getPlaca()).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

		ComandoUsuario comandoUsuario = new ComandoUsuarioDataBuilder().build();
		mvc.perform(post("/usuario/registrarUsuario").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(comandoUsuario))).andDo(print()).andExpect(status().isOk());

		UsuarioDTO usuarioDTO = new UsuarioDTODataBuilder().build();
		mvc.perform(
				get("/usuario/buscarUsuario/{CEDULA}", usuarioDTO.getCedula()).contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());

		ComandoAlquilarVehiculo comandoAlquilarVehiculo = new ComandoAlquilarVehiculoDataBuilder().build();
		mvc.perform(post("/alquiler/alquilarVehiculo").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(comandoAlquilarVehiculo))).andDo(print())
				.andExpect(status().isOk());

		
	}

}