package com.br.pb.sisbus.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.ConfigQuadroHorarioDao;
import com.br.pb.sisbus.models.ConfigQuadroHorario;
import com.br.pb.sisbus.models.PaginatedList;

@Repository
public class ConfigQuadroHorarioDaoImpl implements ConfigQuadroHorarioDao {

	@PersistenceContext
	private EntityManager manager;

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public List<ConfigQuadroHorario> all() {
		return manager.createQuery("select p from ConfigQuadroHorario p", ConfigQuadroHorario.class).getResultList();
	}

	public void save(ConfigQuadroHorario configQuadroHorario) {
		manager.persist(configQuadroHorario);
	}

	public ConfigQuadroHorario findById(Long id) {
		return manager.find(ConfigQuadroHorario.class, id);
	}

	public void remove(ConfigQuadroHorario configQuadroHorario) {
		manager.remove(configQuadroHorario);
	}

	public void update(ConfigQuadroHorario configQuadroHorario) {
		manager.merge(configQuadroHorario);
	}

	public ConfigQuadroHorario merge(ConfigQuadroHorario configQuadroHorario) {
		return manager.merge(configQuadroHorario);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, com.br.pb.sisbus.models.ConfigQuadroHorario.class, page, max);
	}	
}