package com.br.pb.sisbus.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.models.Veiculo;

public interface VeiculoDao {

	public void setManager(EntityManager manager);
	public void save(Veiculo veiculo);	
	public void remove(Veiculo veiculo);
	public void update(Veiculo veiculo);
	public Veiculo findById(Long id);
	public List<Veiculo> all();
	public PaginatedList paginated(int page, int max);
}
