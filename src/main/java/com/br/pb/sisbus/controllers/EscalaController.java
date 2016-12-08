package com.br.pb.sisbus.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.br.pb.sisbus.daos.EscalaDao;
import com.br.pb.sisbus.daos.services.EscalaDaoService;
import com.br.pb.sisbus.enuns.TipoPermissao;
import com.br.pb.sisbus.models.Escala;

@Controller
@RequestMapping("/escala")
@Transactional
public class EscalaController {
	
	@Autowired
	private EscalaDao escalaDao;
	
	@Autowired
	private EscalaDaoService escalaDaoService;
	
	
	@InitBinder
    public void initDataBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping("/form")
	public ModelAndView form(Escala escala) {
		ModelAndView modelAndView = new ModelAndView("escala/form-add");
		modelAndView.addObject("permissoes", TipoPermissao.values());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Escala escala, BindingResult bindingResult) {
		if (bindingResult.hasErrors()){
			return form(escala);
		}else{
			escalaDaoService.saveEscala(escala);
			return new ModelAndView("escala/success");
		}		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("escala/form-update");
		modelAndView.addObject("escala", escalaDao.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("escala/list");
		modelAndView.addObject("paginatedList", escalaDao.paginated(page, 10));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		Escala escala = escalaDao.findById(id);
		escalaDao.remove(escala);
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		return "redirect:/escala";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid Escala escala,
			BindingResult bindingResult) {
		escala.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("escala/form-update");
		}else{
			escalaDao.update(escala);
			return new ModelAndView("escala/success");
		}
		
	}
	
	@RequestMapping(value = "/search" , method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(value="searchItinerario") String searchItinerario, @RequestParam(value = "searchData") String searchData, @RequestParam(value = "searchMatricula") String searchMatricula){
		List<Escala> resultListEscalas =  new ArrayList<Escala>();
		ModelAndView modelAndView = new ModelAndView("escala/list");
		
// 			PESQUISA PERSONALIZADA ENTRE OS CAMPOS ITINERARIO - DATE - MATRICULA
		try {
//			PESQUISA POR: DATA - MATRICULA - ITINERARIO
			if (!searchItinerario.equals("") && !searchMatricula.equals("") && !searchData.equals("")){
				Integer searchMatriculaConv = Integer.parseInt(searchMatricula);
				try {
					SimpleDateFormat format = new SimpleDateFormat("HH:mm"); 
//					java.util.Date searchDate = (java.util.Date) format.parse(searchData);
//					resultListEscalas = escalaDao.findByMatriculaDataEscalaItinerario(searchMatriculaConv, (java.sql.Date) searchDate, searchItinerario);
					return modelAndView.addObject("paginatedList", resultListEscalas);
				} catch (Exception e) {
					System.out.println("Erro ao pesquisar por matricula - data - itinerario");
					e.printStackTrace();
				}
			}
//			PESQUISA POR: DATA - MATRICULA
			if (searchItinerario.equals("") && !searchMatricula.equals("") && !searchData.equals("")){
				try {
					Integer searchMatriculaConv = Integer.parseInt(searchMatricula);
					SimpleDateFormat format = new SimpleDateFormat("HH:mm"); 
//					java.util.Date searchDate = (java.util.Date) format.parse(searchData);
//					resultListEscalas = escalaDao.findByMatriculaAndDateEscale(searchMatriculaConv, (java.sql.Date) searchDate);
					return modelAndView.addObject("paginatedList", resultListEscalas);
				} catch (Exception e) {
					System.out.println("Erro ao pesquisar por matricula - data");
					e.printStackTrace();
				}
			}
//			PESQUISA POR: DATA - ITINERARIO
			if (!searchItinerario.equals("") && searchMatricula.equals("") && !searchData.equals("")){
				try {
					SimpleDateFormat format = new SimpleDateFormat("HH:mm"); 
//					java.util.Date searchDate = (java.util.Date) format.parse(searchData);
//					resultListEscalas = escalaDao.findByDataEscalaAndItinerario((java.sql.Date) searchDate , searchData);
					return modelAndView.addObject("paginatedList", resultListEscalas);
				} catch (Exception e) {
					System.out.println("Erro ao pesquisar por data - itinerario");
					e.printStackTrace();
				}
			}
//			PESQUISA POR: MATRICULA - ITINERARIO
			if (!searchItinerario.equals("") && !searchMatricula.equals("") && searchData.equals("")){
				try {
					Integer searchMatriculaConv = Integer.parseInt(searchMatricula);
					resultListEscalas = escalaDao.findByMatriculaAndItinerario(searchMatriculaConv, searchItinerario);
					return modelAndView.addObject("paginatedList", resultListEscalas);
				} catch (Exception e) {
					System.out.println("Erro ao pesquisar por matricula - itinerario");
					e.printStackTrace();
				}
			}
//			PESQUISA POR: ITINERARIO
			if (!searchItinerario.equals("") && searchMatricula.equals("") && searchData.equals("")){
				try {
					resultListEscalas = escalaDao.findByItinerario(searchItinerario);
					return modelAndView.addObject("paginatedList", resultListEscalas);
				} catch (Exception e) {
					System.out.println("Erro ao pesquisar por itinerario");
					e.printStackTrace();
				}
			}
//			PESQUISA POR: MATRICULA
			if (searchItinerario.equals("") && !searchMatricula.equals("") && searchData.equals("")){
				try {
					Integer searchMatriculaConv = Integer.parseInt(searchMatricula);
					return modelAndView.addObject("paginatedList", escalaDao.paginatedMatricula(searchMatriculaConv, 1, 1));
				} catch (Exception e) {
					System.out.println("Erro ao pesquisar por matricula");
					e.printStackTrace();
				}
			}
//			PESQUISA POR: DATA 
//			if (searchItinerario.equals("") && searchMatricula.equals("") && !searchData.equals("")){
//				try {
//					DateFormat dataConvertida = new SimpleDateFormat("aaaa-MM-dd", new Locale("pt", "br"));
//					Date dataFinal = dataConvertida.parse(searchData);
//					return modelAndView.addObject("paginatedList", escalaDao.paginatedDataEscala(dataFinal, 1, 10));
//				} catch (ParseException e) {
//					System.out.println("Erro ao pesquisar por data " + e);
//				}
//			}
		} catch (Exception e) {
			System.out.println("Erro ao listar todos: " + e.getMessage());;
			return modelAndView.addObject("errorAoListar", "Erro ao realizar a buscar, tente novamente!");
		}
		
		return modelAndView;
	}
	
}