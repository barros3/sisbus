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
import com.br.pb.sisbus.daos.RotaDao;
import com.br.pb.sisbus.models.Rota;

@Controller
@RequestMapping("/gestor/rota")
@Transactional
public class RotaController {

	@Autowired
	private RotaDao rotaDao;

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping("/form")
	public ModelAndView form(Rota rota) {
		ModelAndView modelAndView = new ModelAndView("gestor/rota/form-add");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Rota rota, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(rota);
		}else{
			rotaDao.save(rota);
			return new ModelAndView("gestor/rota/success");
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("gestor/rota/form-update");
		modelAndView.addObject("rota", rotaDao.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("gestor/rota/list");
		modelAndView.addObject("paginatedList", rotaDao.paginated(page, 10));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		Rota rota = rotaDao.findById(id);
		rotaDao.remove(rota);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		return "redirect:/gestor/rota";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid Rota rota,
			BindingResult bindingResult) {
		rota.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("gestor/rota/form-update");
		}else{
			rotaDao.update(rota);
			return new ModelAndView("gestor/rota/success");
		}
		
	}
}