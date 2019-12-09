package com.juniorArt.JuniorArt.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import com.juniorArt.JuniorArt.models.Usuario;

@Controller
public class UseController {
	
	private Usuario usuario;
	
	public UseController() {
		usuario = new Usuario();
		SecurityContext context = SecurityContextHolder.getContext();
		if(context instanceof SecurityContext) {
			Authentication authentication = context.getAuthentication();
			if(authentication instanceof Authentication) {
				usuario.setLogin(((User)authentication.getPrincipal()).getUsername());
			}
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
