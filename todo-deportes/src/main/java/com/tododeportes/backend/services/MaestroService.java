package com.tododeportes.backend.services;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tododeportes.backend.dto.maestros.MaestroCanchas;
import com.tododeportes.backend.dto.maestros.MaestroCanchaxUnidad;
import com.tododeportes.backend.dto.maestros.MaestroPersona;
import com.tododeportes.backend.dto.maestros.MaestroReservas;
import com.tododeportes.backend.dto.maestros.MaestroUnidadDeportiva;
import com.tododeportes.backend.dto.maestros.MaestroUsuario;

@RestController
@RequestMapping("/maestros")
public class MaestroService {
	
	@RequestMapping(value="/verCancha", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody MaestroCanchas verCancha(){
		MaestroCanchas maestro = new MaestroCanchas();
		maestro.setTipoDeporte(1);
		maestro.setTipoEscenario(2);
		maestro.setNombre("Nombre de la Cancha");
		
		return maestro;
	}

	@RequestMapping(value="/verPersona", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody MaestroPersona verPersona(){
		MaestroPersona persona = new MaestroPersona();
		persona.setNumeroDocumento("12345678");
		persona.setApellidos("CAMELO");
		persona.setNombres("BENITO");
		persona.setIdCiudad(70);
		persona.setIdTipoDocumento(3);
		persona.setDireccion("Aqui va la direccion");
		persona.setEmail("correo@123.com");
		persona.setTelefonoFijo("2349000");
		persona.setTelefonoCelular("3006789000");
		persona.setLogin("nombre_usuario");
		persona.setPassword("Aqui va el password");
		
		return persona;
	}
	
	@RequestMapping(value="/verReserva", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody MaestroReservas verReserva(){
		MaestroReservas reserva = new MaestroReservas();
		reserva.setLogin("nombre_usuario");
		reserva.setHoraInicio(new Date());
		reserva.setHoraFin(new Date());
		reserva.setFechaReserva(new Date());
		reserva.setIdCancha(10);
		reserva.setTiempo(2);
		reserva.setValorHora(120000L);
		
		return reserva;
	}
	
	@RequestMapping(value="/verUnidadDeportiva", method=RequestMethod.GET, produces="application/JSON")
	public MaestroUnidadDeportiva verUnidadDeportiva(){
		MaestroUnidadDeportiva unidadDeportiva = new MaestroUnidadDeportiva();
		unidadDeportiva.setNombre("Nombre de la Unidad Deportiva");
		unidadDeportiva.setDireccion("Direccion U. Deportiva");
		unidadDeportiva.setTelefono("3456789");
		unidadDeportiva.setContacto("Nombre del Contacto");
		unidadDeportiva.setIdLocalidad(12);
		unidadDeportiva.setEstado(1);
		
		return unidadDeportiva;
	}
	
	@RequestMapping(value="/verUsuario", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody MaestroUsuario verUsuario(){
		MaestroUsuario usuario = new MaestroUsuario();
		usuario.setLogin("nombre_usuario");
		usuario.setPassword("contraseña");
		usuario.setIdPersona("12345678");
		usuario.setIdRol(2L);
		usuario.setIdEstado(2L);
		
		return usuario;
	}

	@RequestMapping(value="/verCanchaxUnidad", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody MaestroCanchaxUnidad verCanchaxUnidad(){
		MaestroCanchaxUnidad maestro = new MaestroCanchaxUnidad();
		MaestroCanchas cancha = new MaestroCanchas();
		MaestroUnidadDeportiva unidad = new MaestroUnidadDeportiva();
		
		cancha.setTipoDeporte(3);
		cancha.setTipoEscenario(7);
		cancha.setNombre("Nombre nueva Cancha");
		
		unidad.setNombre("Nombre de la Unidad Deportiva");
		unidad.setDireccion("Direccion U. Deportiva");
		unidad.setTelefono("3456789");
		unidad.setContacto("Nombre del Contacto");
		unidad.setIdLocalidad(12);
		unidad.setEstado(1);
	
		maestro.setIdCancha(3);
		maestro.setIdUnidadDeportiva(4);
		maestro.setIdEstado(1);
		maestro.setNombre("Nombre de Cancha por Unidad Deportiva");
		maestro.setDisponibleInicio(new Date());
		maestro.setDisponibleFin(new Date());
		maestro.setCancha(cancha);
		maestro.setUnidadDeportiva(unidad);
		
		return maestro;
	}
}
