package com.br.pb.sisbus.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.ConfigEscalaDao;
import com.br.pb.sisbus.models.ConfigEscala;
import com.br.pb.sisbus.models.PaginatedList;

@Repository
public class ConfigEscalaDaoImpl implements ConfigEscalaDao {

	@PersistenceContext
	private EntityManager manager;

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public List<ConfigEscala> all() {
		return manager.createQuery("select p from ConfigEscala p", ConfigEscala.class).getResultList();
	}

	public void save(ConfigEscala configEscala) {
		manager.persist(configEscala);
	}

	public ConfigEscala findById(Long id) {
		return manager.find(ConfigEscala.class, id);
	}

	public void remove(ConfigEscala configEscala) {
		manager.remove(configEscala);
	}

	public void update(ConfigEscala configEscala) {
		manager.merge(configEscala);
	}

	public ConfigEscala merge(ConfigEscala configEscala) {
		return manager.merge(configEscala);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, com.br.pb.sisbus.models.ConfigEscala.class, page, max);
	}	
}