package com.br.pb.sisbus.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.RotaDao;
import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.models.Rota;

@Repository
public class RotaDaoImpl implements RotaDao {

	@PersistenceContext
	private EntityManager manager;

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public List<Rota> all() {
		return manager.createQuery("select p from Rota p", Rota.class).getResultList();
	}

	public void save(Rota rota) {
		manager.persist(rota);
	}

	public Rota findById(Long id) {
		return manager.find(Rota.class, id);
	}

	public void remove(Rota rota) {
		manager.remove(rota);
	}

	public void update(Rota rota) {
		manager.merge(rota);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Rota.class, page, max);
	}

}