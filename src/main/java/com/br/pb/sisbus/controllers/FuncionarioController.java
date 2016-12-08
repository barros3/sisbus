package com.br.pb.sisbus.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.pb.sisbus.daos.FuncionarioDao;
import com.br.pb.sisbus.daos.RoleDao;
import com.br.pb.sisbus.daos.services.FuncionarioDaoService;
import com.br.pb.sisbus.enuns.TipoPermissao;
import com.br.pb.sisbus.models.Funcionario;
import com.br.pb.sisbus.models.Role;
import com.br.pb.sisbus.validators.ValidatorFuncionario;

@Controller
@RequestMapping("/admin/funcionario")
@Transactional
public class FuncionarioController {

	@Autowired
	private FuncionarioDao funcionarioDao;
	
	@Autowired
	private FuncionarioDaoService funcionarioDaoService;

	@RequestMapping("/form")
	public ModelAndView form(Funcionario funcionario) {
		
		ModelAndView modelAndView = new ModelAndView("admin/funcionario/form-add");
		
		return modelAndView;
	}

	@Autowired
	RoleDao roleDao;
	
	ValidatorFuncionario validatorFuncionario = new ValidatorFuncionario();
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Funcionario funcionario, BindingResult bindingResult) {
		
		
//		NAO APAGAR :D
//		modelAndView.addObject("permissoes", TipoPermissao.values());
//		Set<Role> roles = new HashSet<>();
//		roles.add(funcionario.getRole());
//		funcionario.getUsuario().setRoles(roles);
		
		validatorFuncionario.validate(funcionario, bindingResult);
		
		if (bindingResult.hasErrors()) {
			
			return form(funcionario);
		}else{
			funcionarioDaoService.saveFuncionario(funcionario);
			
			return new ModelAndView("admin/funcionario/success");
		}
		
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		
		ModelAndView modelAndView = new ModelAndView("admin/funcionario/form-update");
		modelAndView.addObject("funcionario", funcionarioDao.findById(id));
		
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		
		ModelAndView modelAndView = new ModelAndView("admin/funcionario/list");
		modelAndView.addObject("paginatedList", funcionarioDao.paginated(page, 10));
		
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Long id) {
		
		Funcionario funcionario = funcionarioDao.findById(id);
		funcionarioDaoService.deleteFuncionario(funcionario);
		
		return "redirect:/admin/funcionario";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Long id, @Valid Funcionario funcionario, BindingResult bindingResult) {
		funcionario.setId(id);
		
		if (bindingResult.hasErrors()) {
			return new ModelAndView("admin/funcionario/form-update");
		}else{
			
			funcionarioDaoService.updateFuncionario(funcionario);
			return new ModelAndView("admin/funcionario/success");
		}
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}