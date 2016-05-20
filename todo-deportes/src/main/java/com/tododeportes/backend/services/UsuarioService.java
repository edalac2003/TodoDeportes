package com.tododeportes.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.ngc.UsuariosNGC;
import com.tododeportes.backend.util.exception.ExcepcionesNGC;

@RestController
@RequestMapping("/usuario")
public class UsuarioService {

	@Autowired
	UsuariosNGC usuarioNgc;
	
	TbUsuarios usuario;
	
	@RequestMapping(value="/guardarUsuario", method=RequestMethod.POST)
	public void guardarUsuario(@RequestBody TbUsuarios usuario){
		try {
			usuarioNgc.guardarUsuario(usuario);
		} catch (ExcepcionesNGC e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/validarUsuario", method=RequestMethod.GET, produces="application/JSON")
	public boolean validarUsuario(@RequestParam(value="login")String login, @RequestParam(value="pwd")String pwd){
		boolean validar = false;
		
		try {
			validar = usuarioNgc.validarUsuario(login, pwd);
		} catch (ExcepcionesNGC e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return validar;
	}
	
	@RequestMapping(value="/obtenerUsuario", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody TbUsuarios obtenerUsuario(@RequestParam(value="login") String login){
		
		
		try {
			usuario = usuarioNgc.obtenerUsuarioxLogin(login);
		} catch (ExcepcionesNGC e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return usuario;
	}
}
