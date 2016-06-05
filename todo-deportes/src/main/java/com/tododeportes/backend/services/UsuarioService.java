package com.tododeportes.backend.services;

/**
 * Esta clase contiene las entradas a los servicios relacionados con la entidad TbUsuario.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tododeportes.backend.dto.TbUsuarios;
import com.tododeportes.backend.ngc.UsuariosNGC;

@RestController
@RequestMapping("/usuario")
public class UsuarioService {

	@Autowired
	UsuariosNGC usuarioNgc;
		
	@RequestMapping(value="/guardarUsuario", method=RequestMethod.POST)
	public void guardarUsuario(@RequestBody TbUsuarios usuario)throws Exception{
		usuarioNgc.guardarUsuario(usuario);
	}
	
	@RequestMapping(value="/validarUsuario", method=RequestMethod.GET, produces="application/JSON")
	public boolean validarUsuario(@RequestParam(value="login")String login, @RequestParam(value="pwd")String pwd)throws Exception{				
		return usuarioNgc.validarUsuario(login, pwd);
	}
	
	@RequestMapping(value="/obtenerUsuario", method=RequestMethod.GET, produces="application/JSON")
	public @ResponseBody TbUsuarios obtenerUsuario(@RequestParam(value="login") String login)throws Exception{
		return usuarioNgc.obtenerUsuarioxLogin(login);
	}
}
