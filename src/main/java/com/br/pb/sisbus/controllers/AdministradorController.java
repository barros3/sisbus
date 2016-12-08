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

import com.br.pb.sisbus.daos.AdministradorDao;
import com.br.pb.sisbus.daos.services.AdministradorDaoService;
import com.br.pb.sisbus.models.Administrador;


@Controller
@RequestMapping("/admin_master/administrador")
@Transactional
public class AdministradorController {
	
	@Autowired
	private AdministradorDao administradorDao;
	
	@Autowired
	private AdministradorDaoService administradorDaoService;
	
	@RequestMapping("/form")
	public ModelAndView form(Administrador administrador) {
		ModelAndView modelAndView = new ModelAndView("admin_master/administrador/form-add");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Administrador administrador, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(administrador);
		}else{
			administradorDaoService.saveAdministrador(administrador);
			return new ModelAndView("admin_master/administrador/success");
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("admin_master/administrador/form-update");
		modelAndView.addObject("administrador", administradorDao.findById(id));
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("admin_master/administrador/list");
		modelAndView.addObject("paginatedList", administradorDao.paginated(page, 10));
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		Administrador administrador = administradorDao.findById(id);
		administradorDao.remove(administrador);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		return "redirect:/admin_master/administrador";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid Administrador administrador,
		BindingResult bindingResult) {
			administrador.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("admin_master/administrador/form-update");
		}else{
			administradorDaoService.updateUsuario(administrador);	
			return new ModelAndView("admin_master/administrador/success");
		}
		
	}
}