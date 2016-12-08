package com.br.pb.sisbus.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.br.pb.sisbus.models.Funcionario;
import com.br.pb.sisbus.models.PaginatedList;

public interface FuncionarioDao {

	public void setManager(EntityManager manager);
	
	public void save(Funcionario funcionario);
	
	public void remove(Funcionario funcionario);
	
	public void update(Funcionario funcionario);
	
	public Funcionario findById(Long id);
	
	public Funcionario merge(Funcionario funcionario);
	
	public Integer lastFuncionario();
	
	public List<Funcionario> all();
	
	public PaginatedList paginated(int page, int max);
	
	public Funcionario findByLoginAndSenha(String login, String senha);
}