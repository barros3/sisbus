package com.br.pb.sisbus.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.EnderecoDao;
import com.br.pb.sisbus.models.Endereco;
import com.br.pb.sisbus.models.PaginatedList;

@Repository
public class EnderecoDaoImpl implements EnderecoDao{

	@PersistenceContext
	private EntityManager manager;
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public List<Endereco> all() {
		return manager.createQuery("select p from Endereco p", Endereco.class).getResultList();
	}

	public void save(Endereco endereco) {
		manager.persist(endereco);
	}

	public Endereco findById(Long id) {
		return manager.find(Endereco.class, id);
	}

	public void remove(Endereco endereco) {
		manager.remove(endereco);
	}

	public void update(Endereco endereco) {
		manager.merge(endereco);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Endereco.class, page, max);
	}

	@Override
	public Endereco findByCEP(String cep) throws IndexOutOfBoundsException{
		Endereco resultEndereco = new Endereco();
		try {
			resultEndereco = (Endereco) manager.createQuery("SELECT e FROM Endereco e where e.cep = :cep", Endereco.class)
					.setParameter("cep", cep).getSingleResult();
		} catch (Exception e) {
				return null;
		}
		return resultEndereco;
	}

	@Override
	public Endereco merge(Endereco endereco) {
		return manager.merge(endereco);
	}
}
