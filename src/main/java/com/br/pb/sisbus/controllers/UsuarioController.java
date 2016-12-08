package com.br.pb.sisbus.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.pb.sisbus.daos.UsuarioDao;
import com.br.pb.sisbus.daos.services.UsuarioOddDaoService;
import com.br.pb.sisbus.models.Usuario;

@Controller
@RequestMapping("/admin_master/usuario")
@Transactional
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Autowired
	private UsuarioOddDaoService usuarioOddDaoService;
		
	@RequestMapping("/form")
	public ModelAndView form(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("admin_master/usuario/form-add");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Usuario usuario, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("redirect:/admin_master/usuario/form");
		}else{
			usuarioOddDaoService.saveUsuarioOdd(usuario);
			return new ModelAndView("admin_master/usuario/success");
		}	
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("admin_master/usuario/form-update");
		modelAndView.addObject("usuario", usuarioDao.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("admin_master/usuario/list");
		modelAndView.addObject("paginatedList", usuarioDao.paginated(page, 10));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		Usuario usuario = usuarioDao.findById(id);
		usuarioDao.remove(usuario);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		return "redirect:/admin_master/usuario";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid Usuario usuario, BindingResult bindingResult) {
		usuario.setId(id);
		if(bindingResult.hasErrors()) {
			return new ModelAndView("redirect:/admin_master/usuario/form");
		}else{
			usuarioOddDaoService.updateUsuarioOdd(usuario);
			return new ModelAndView("admin_master/usuario/success");
		}
		
	}		
}