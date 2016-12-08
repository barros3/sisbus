package com.br.pb.sisbus.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.models.Rota;

public interface RotaDao {
	
	public void setManager(EntityManager manager);
	public List<Rota> all();
	public void save(Rota rota);
	public Rota findById(Long id);
	public void remove(Rota rota);
	public void update(Rota rota);
	public PaginatedList paginated(int page, int max);

}
