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

import com.br.pb.sisbus.daos.ConfigQuadroHorarioDao;
import com.br.pb.sisbus.daos.services.ConfigQuadroHorarioDaoService;
import com.br.pb.sisbus.models.ConfigQuadroHorario;


@Controller
@RequestMapping("/config_quadro_horario")
@Transactional
public class ConfigQuadroHorarioController {
	
	@Autowired	
	private ConfigQuadroHorarioDao configQuadroHorarioDao;
	
	@Autowired 
	private ConfigQuadroHorarioDaoService configQuadroHorarioDaoService;
	
	@InitBinder
    public void initHourBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping("/form")
	public ModelAndView form(ConfigQuadroHorario configQuadroHorario) {
		ModelAndView modelAndView = new ModelAndView("config_quadro_horario/form-add");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid ConfigQuadroHorario configQuadroHorario, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()){			
		
			return form(configQuadroHorario);
		}else{
			/**
			 * Pega a string de entrada do campo intervalo
			 */
			String result = "";
			String intervaloFront = (String) bindingResult.getFieldValue("intervaloCompleto");
			
			/**
			 * se for vazia -> seta null em intervalo
			 */
			if(intervaloFront == null){
				configQuadroHorario.setIntervalo(null);
				configQuadroHorario.setIntervaloCompleto(null);
			}
			if(intervaloFront != null){
				result = configQuadroHorarioDaoService.managerInputHours(intervaloFront);
				configQuadroHorario.setIntervalo(result);
				configQuadroHorario.setIntervaloCompleto(intervaloFront);
			}
			
			configQuadroHorarioDaoService.saveConfigQuadroHorario(configQuadroHorario);
			
			return new ModelAndView("config_quadro_horario/success");
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("config_quadro_horario/form-update");
		modelAndView.addObject("configquadrohorario", configQuadroHorarioDao.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("config_quadro_horario/list");
		modelAndView.addObject("paginatedList", configQuadroHorarioDao.paginated(page, 10));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		ConfigQuadroHorario configQuadroHorario = configQuadroHorarioDao.findById(id);
		configQuadroHorarioDao.remove(configQuadroHorario);
		return "redirect:/config_quadro_horario";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid ConfigQuadroHorario configQuadroHorario,
			BindingResult bindingResult) {
		configQuadroHorario.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("config_quadro_horario/form-update");
		}else{
			configQuadroHorarioDao.update(configQuadroHorario);
			return new ModelAndView("config_quadro_horario/success");
		}
		
	}
}