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
import com.br.pb.sisbus.daos.EnderecoDao;
import com.br.pb.sisbus.models.Endereco;


@Controller
@RequestMapping("/funcionario/endereco")
@Transactional
public class EnderecoController {

	@Autowired
	private EnderecoDao enderecoDao;
	
	@RequestMapping("/form")
	public ModelAndView form(Endereco endereco) {
		ModelAndView modelAndView = new ModelAndView("endereco/form-add");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Endereco endereco, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(endereco);
		}else{
			enderecoDao.save(endereco);
			return new ModelAndView("endereco/success");
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("endereco/form-update");
		modelAndView.addObject("endereco", enderecoDao.findById(id));
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("endereco/list");
		modelAndView.addObject("paginatedList", enderecoDao.paginated(page, 10));
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		Endereco endereco = enderecoDao.findById(id);
		enderecoDao.remove(endereco);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		return "redirect:/funcionario";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid Endereco endereco,
		BindingResult bindingResult) {
		endereco.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("endereco/form-update");
		}else{
			enderecoDao.update(endereco);
			return new ModelAndView("endereco/success");
		}
		
	}	
}
