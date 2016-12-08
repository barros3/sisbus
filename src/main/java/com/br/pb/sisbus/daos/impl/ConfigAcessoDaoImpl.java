package com.br.pb.sisbus.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.ConfigAcessoDao;
import com.br.pb.sisbus.models.ConfigAcesso;
import com.br.pb.sisbus.models.PaginatedList;

@Repository
public class ConfigAcessoDaoImpl implements ConfigAcessoDao {

	@PersistenceContext
	private EntityManager manager;

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public List<ConfigAcesso> all() {
		return manager.createQuery("select p from ConfigAcesso p", ConfigAcesso.class).getResultList();
	}

	public void save(ConfigAcesso configAcesso) {
		manager.persist(configAcesso);
	}

	public ConfigAcesso findById(Long id) {
		return manager.find(ConfigAcesso.class, id);
	}

	public void remove(ConfigAcesso configAcesso) {
		manager.remove(configAcesso);
	}

	public void update(ConfigAcesso configAcesso) {
		manager.merge(configAcesso);
	}

	public ConfigAcesso merge(ConfigAcesso configAcesso) {
		return manager.merge(configAcesso);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, ConfigAcesso.class, page, max);
	}

}
