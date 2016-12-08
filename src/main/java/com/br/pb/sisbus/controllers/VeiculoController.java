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

import com.br.pb.sisbus.daos.PneuDao;
import com.br.pb.sisbus.daos.VeiculoDao;
import com.br.pb.sisbus.daos.services.VeiculoDaoService;
import com.br.pb.sisbus.models.Veiculo;

@Controller
@RequestMapping("/gestor/veiculo")
@Transactional
public class VeiculoController {

	@Autowired
	private VeiculoDao veiculoDao;
	
	@Autowired
	VeiculoDaoService veiculoDaoService;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

	@RequestMapping("/form")
	public ModelAndView form(Veiculo veiculo) {
		ModelAndView modelAndView = new ModelAndView("gestor/veiculo/form-add");
		return loadFormDependencies(modelAndView);

	}

	private ModelAndView loadFormDependencies(ModelAndView modelAndView) {
		modelAndView.addObject("veiculoList", veiculoDao.all());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Veiculo veiculo, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(veiculo);
		}else{
			veiculoDaoService.saveVeiculo(veiculo);
			return new ModelAndView("gestor/veiculo/success");
		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("gestor/veiculo/form-update");
		modelAndView.addObject("veiculo", veiculoDao.findById(id));
		loadFormDependencies(modelAndView);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("gestor/veiculo/list");
		modelAndView.addObject("paginatedList", veiculoDao.paginated(page, 10));
		return modelAndView;
	}
	
	@Autowired
	PneuDao pneuDao;

	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		Veiculo veiculo = veiculoDao.findById(id);
		veiculoDaoService.deleteVeiculo(veiculo);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		return "redirect:/gestor/veiculo";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid Veiculo veiculo, BindingResult bindingResult) {
		veiculo.setId(id);
		if (bindingResult.hasErrors()) {
			return loadFormDependencies(new ModelAndView("gestor/veiculo/form-update"));
		}else{
			veiculoDaoService.updateVeiculo(veiculo);
			return new ModelAndView("gestor/veiculo/success");
		}
		
	}
}