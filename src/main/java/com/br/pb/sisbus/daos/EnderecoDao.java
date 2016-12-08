package com.br.pb.sisbus.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.br.pb.sisbus.models.Endereco;
import com.br.pb.sisbus.models.PaginatedList;

public interface EnderecoDao {
	
	public void setManager(EntityManager manager);
	public void save(Endereco endereco);
	public void remove(Endereco endereco);
	public void update(Endereco endereco);
	public Endereco merge(Endereco endereco);
	public Endereco findById(Long id);
	public List<Endereco> all();
	public PaginatedList paginated(int page, int max);
	public Endereco findByCEP(String cep);
	
}