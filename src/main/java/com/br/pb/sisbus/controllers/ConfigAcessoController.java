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

import com.br.pb.sisbus.daos.ConfigAcessoDao;
import com.br.pb.sisbus.models.ConfigAcesso;

@Controller
@RequestMapping("/config_acesso")
@Transactional
public class ConfigAcessoController {
	
	@Autowired
	private ConfigAcessoDao configAcessoDao;
	
	@RequestMapping("/form")
	public ModelAndView form(ConfigAcesso configAcesso) {
		ModelAndView modelAndView = new ModelAndView("config_acesso/form-add");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid ConfigAcesso configAcesso, BindingResult bindingResult) {
		if (bindingResult.hasErrors()){			
			return form(configAcesso);
		}else{
//			configEscalaDao.save(configAcesso);
			return new ModelAndView("config_acesso/success");
		}
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("config_acesso/form-update");
		modelAndView.addObject("controleUsuario", configAcessoDao.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("config_acesso/list");
		modelAndView.addObject("paginatedList", configAcessoDao.paginated(page, 10));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
//		ConfigEscala configEscala = configEscalaDao.findById(id);
//		configEscalaDao.remove(configEscala);
		return "redirect:/config_acesso";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid ConfigAcesso configAcesso,
			BindingResult bindingResult) {
		configAcesso.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("config_acesso/form-update");
		}else{
			configAcessoDao.update(configAcesso);
			return new ModelAndView("config_acesso/success");
		}
		
	}
}