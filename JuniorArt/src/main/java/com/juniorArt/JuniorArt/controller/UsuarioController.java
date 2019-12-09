package com.juniorArt.JuniorArt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.juniorArt.JuniorArt.models.Usuario;
import com.juniorArt.JuniorArt.repository.ClienteRepository;


@Controller 
public class UsuarioController {
	
	@Autowired
	private ClienteRepository cr;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String form() {
		return "index";
		
	}
	
	@RequestMapping(value="/formC", method=RequestMethod.GET)
	public String formularioCliente() {
		return "formCliente";
	}
	
	@RequestMapping(value="/formC", method=RequestMethod.POST)
	public String clienteCad(Usuario usuario) {
		
		String senha = new BCryptPasswordEncoder().encode(usuario.getSenha());
		usuario.setSenha(senha);

		cr.save(usuario);
		
		return "formCliente";
	}
	@RequestMapping("/usuarios")
	public ModelAndView listaClientes() {
		ModelAndView mv = new ModelAndView("JA/listaClientes");
		Iterable<Usuario> usuarios = cr.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
	
	}
	
}
