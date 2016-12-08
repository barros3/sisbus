package com.br.pb.sisbus.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.VeiculoDao;
import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.models.Veiculo;

@Repository
public class VeiculoDaoImpl implements VeiculoDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Veiculo> all() {
		return manager.createQuery("select c from Veiculo c", Veiculo.class).getResultList();
	}

	@Override
	public void save(Veiculo veiculo) {
		manager.persist(veiculo);
	}

	@Override
	public Veiculo findById(Long id) {
		return manager.find(Veiculo.class, id);
	}

	@Override
	public void remove(Veiculo veiculo) {
		manager.remove(veiculo);
	}

	@Override
	public void update(Veiculo veiculo) {
		manager.merge(veiculo);
	}

	@Override
	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Veiculo.class, page, max);
	}
	
}