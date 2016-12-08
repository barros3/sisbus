package com.br.pb.sisbus.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.PneuDao;
import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.models.Pneu;
import com.br.pb.sisbus.models.Veiculo;

@Repository
public class PneuDaoImpl implements PneuDao{
	
	@PersistenceContext
	private EntityManager manager;
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Pneu> all() {
		return manager.createQuery("select c from Pneu c", Pneu.class).getResultList();
	}

	public void save(Pneu pneu) {
		manager.persist(pneu);
	}

	public Pneu findById(Long id) {
		return manager.find(Pneu.class, id);
	}

	public void remove(Pneu pneu) {
		manager.remove(pneu);
	}

	public void update(Pneu pneu) {
		manager.merge(pneu);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Pneu.class, page, max);
	}

	@Override
	public Pneu updateWithReturn(Pneu pneu) {
		return manager.merge(pneu);
	}

	@Override
	public Pneu findPneuByVeiculo(Veiculo veiculo) {
		Pneu pneu = manager.createQuery("SELECT p FROM Pneu p WHERE p.veiculo_idVeiculo = :idVeiculo", Pneu.class)
				.setParameter("veiculo_idVeiculo", veiculo).getSingleResult();
		return pneu;
	}

}
