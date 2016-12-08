package com.br.pb.sisbus.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.br.pb.sisbus.daos.RoleDao;
import com.br.pb.sisbus.daos.UsuarioSessionDao;
import com.br.pb.sisbus.models.Usuario;

@Controller
@RequestMapping({ "/login", "/" })
public class LoginController {

	@Autowired
	UsuarioSessionDao usuarioSessionDaoImpl;
	
	@Autowired
	RoleDao roleDao;
	
	@RequestMapping(value = "" , method = RequestMethod.GET)
	public String login(ModelMap modelMap, @Valid Usuario usuario) {
		modelMap.addAttribute("usuario", usuario);
		return "login/form";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = (Authentication) SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null)	{
			new SecurityContextLogoutHandler().logout(request, response, authentication);;
		}
		return "redirect:/login/";
	}

}
