package com.br.pb.sisbus.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.pb.sisbus.daos.ConfigEscalaDao;
import com.br.pb.sisbus.models.ConfigEscala;

@Controller
@RequestMapping("/config_escala")
@Transactional
public class ConfigEscalaController {
	
	@Autowired
	private ConfigEscalaDao configEscalaDao;
	
	@InitBinder
    public void initHourBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping("/form")
	public ModelAndView form(ConfigEscala configEscala) {
		ModelAndView modelAndView = new ModelAndView("config_escala/form-add");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid ConfigEscala configEscala, BindingResult bindingResult) {
		if (bindingResult.hasErrors()){			
			return form(configEscala);
		}else{
			configEscalaDao.save(configEscala);
			return new ModelAndView("config_escala/success");
		}
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("config_escala/form-update");
		modelAndView.addObject("configescala", configEscalaDao.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("config_escala/list");
		modelAndView.addObject("paginatedList", configEscalaDao.paginated(page, 10));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		ConfigEscala configEscala = configEscalaDao.findById(id);
		configEscalaDao.remove(configEscala);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		return "redirect:/config_escala";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid ConfigEscala configEscala,
			BindingResult bindingResult) {
		configEscala.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("config_escala/form-update");
		}else{
			configEscalaDao.update(configEscala);
			return new ModelAndView("config_escala/success");
		}
		
	}
}