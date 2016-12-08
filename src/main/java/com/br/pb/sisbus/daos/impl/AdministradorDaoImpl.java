package com.br.pb.sisbus.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.AdministradorDao;
import com.br.pb.sisbus.models.Administrador;
import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.models.Usuario;

@Repository
public class AdministradorDaoImpl implements AdministradorDao{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Administrador> all() {
		return manager.createQuery("select a from Administrador a", Administrador.class).getResultList();
	}
	
	public void save(Administrador administrador) {
		manager.persist(administrador);
	}

	public Administrador findById(Long id) {
		return manager.find(Administrador.class, id);
	}

	public void remove(Administrador administrador) {
		manager.remove(administrador);
	}

	public void update(Administrador administrador) {
		manager.merge(administrador);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Administrador.class, page, max);
	}
	
	@Override
	public Usuario findUsuarioByAdministrador(Administrador administrador) {
		Usuario usuario = new Usuario();
		try {
			usuario = (Usuario) manager.createQuery("", Usuario.class).setParameter("", Usuario.class);
		} catch (Exception e) {
			return null;
		}
		return null;
	}
}