package com.br.pb.sisbus.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.br.pb.sisbus.daos.ChamadoDao;
import com.br.pb.sisbus.models.Chamado;

@Controller
@RequestMapping("/gestor/chamado")
@Transactional
public class ChamadoController {
	
	@Autowired
	private ChamadoDao chamadoDao;
	
	@RequestMapping("/form")
	public ModelAndView form(Chamado chamado) {
		ModelAndView modelAndView = new ModelAndView("gestor/chamado/form-add");
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Chamado chamado, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(chamado);
		}else{
			chamadoDao.save(chamado);
			return new ModelAndView("gestor/chamado/success");
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("gestor/chamado/form-update");
		modelAndView.addObject("chamado", chamadoDao.findById(id));
		return modelAndView;
	}
	
	/*
	 * Visualizar dados
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/visualizar/{id}")
	public ModelAndView visualizar(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("gestor/chamado/visualizar");
		modelAndView.addObject("chamado", chamadoDao.findById(id));
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("gestor/chamado/list");
		modelAndView.addObject("paginatedList", chamadoDao.paginated(page, 10));
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		Chamado chamado = chamadoDao.findById(id);
		chamadoDao.remove(chamado);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		return "redirect:/gestor/chamado";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid Chamado chamado, BindingResult bindingResult) {
		chamado.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("gestor/chamado/form-update");
		}else{
			chamadoDao.update(chamado);
			return new ModelAndView("gestor/chamado/success");
		}
		
	}
	
	//	PESQUISA POR STATUS
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(HttpServletRequest request, @RequestParam(value = "status", required= false) String status){
		ModelAndView mav = new ModelAndView("gestor/chamado/list");
		status = request.getParameter("status");
		System.err.println(status);
		return mav;		
	}
			

}
