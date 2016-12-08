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

import com.br.pb.sisbus.models.ConfigQuadroHorario;
import com.br.pb.sisbus.models.Escala;
import com.br.pb.sisbus.system.dao.services.SystemSisBusQuadroHorarioGeradoService;
/**
 * 
 * @author root
 *
 */

@Controller
@RequestMapping("/config_quadro_horario/gerado")
@Transactional
public class SystemSisBusQuadroHorarioGeradoController {
	
	@Autowired
	private SystemSisBusQuadroHorarioGeradoService systemSisBusQuadroHorarioGeradoService;
	
	@InitBinder
    public void initHourBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping("/gerado/form")
	public ModelAndView form(Escala Escala) {
		ModelAndView modelAndView = new ModelAndView("config_quadro_horario/gerado/form-add");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Escala escala, BindingResult bindingResult) {
		if (bindingResult.hasErrors()){			
			return form(escala);
		}else{
			return new ModelAndView("config_quadro_horario/gerado/success");
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("config_quadro_horario/gerado/form-update");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("config_quadro_horario/gerado/list");
		modelAndView.addObject("paginatedList", systemSisBusQuadroHorarioGeradoService.gerarQuadroHorarioEscala(page, 10));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		return "redirect:/config_quadro_horario/gerado";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid ConfigQuadroHorario configQuadroHorario,
			BindingResult bindingResult) {
		configQuadroHorario.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("config_quadro_horario/gerado/form-update");
		}else{
			return new ModelAndView("config_quadro_horario/gerado/success");
		}
		
	}
}