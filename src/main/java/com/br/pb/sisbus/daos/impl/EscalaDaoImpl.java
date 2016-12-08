package com.br.pb.sisbus.daos.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.EscalaDao;
import com.br.pb.sisbus.models.Escala;
import com.br.pb.sisbus.models.PaginatedList;

@Repository
public class EscalaDaoImpl implements EscalaDao {

	@PersistenceContext
	private EntityManager manager;

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public List<Escala> all() {
		return manager.createQuery("select p from Escala p", Escala.class).getResultList();
	}

	public void save(Escala escala) {
		manager.persist(escala);
	}

	public Escala findById(Long id) {
		return manager.find(Escala.class, id);
	}

	public void remove(Escala escala) {
		manager.remove(escala);
	}

	public void update(Escala escala) {
		manager.merge(escala);
	}

	public Escala merge(Escala escala) {
		return manager.merge(escala);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, com.br.pb.sisbus.models.Escala.class, page, max);
	}
	
	public PaginatedList paginatedMatricula(Integer matricula, int page, int max) {
		return new PaginatorQueryHelper().listUniqueMatriculaEscala(manager, com.br.pb.sisbus.models.Escala.class, matricula, page, max);
	}

	public PaginatedList paginatedDataEscala(Date dataEscala, int page, int max) {
		return new PaginatorQueryHelper().listDateEscala(manager, com.br.pb.sisbus.models.Escala.class, dataEscala, page, max);
	}
	
	@Override
	public Escala findByMatricula(Integer matriculaFuncionario) {
		Escala escala = (Escala) manager.createQuery("SELECT e FROM Escala e WHERE e.matriculaFuncionario = :matriculaFuncionario" , Escala.class)
				.setParameter("matriculaFuncionario", matriculaFuncionario).getSingleResult();
		return escala;
	}

	@Override
	public List<Escala> findByDataEscala(Date dataEscala) {
		List<Escala> listEscala = (List<Escala>) 
				manager.createQuery("SELECT e FROM Escala e WHERE e.dataEscala = :dataEscala", Escala.class)
				.setParameter("dataEscala", dataEscala).getResultList();
		return listEscala;
	}

	@Override
	public List<Escala> findByItinerario(String itinerario) {
		List<Escala> listEscala = (List<Escala>) 
				manager.createQuery("SELECT e FROM Escala e WHERE e.itinerario = :itinerario", Escala.class)
				.setParameter("itinerario", itinerario).getResultList();
		return listEscala;
	}

	@Override
	public List<Escala> findByMatriculaAndDateEscale(Integer matricula, Date date) {
		List<Escala> listEscala = (List<Escala>) 
				manager.createQuery("SELECT e FROM Escala e WHERE e.matriculaFucionario = :matricula and e.dataEscala = :date", Escala.class)
				.setParameter("matriculaFucionario", matricula).setParameter("dataEscala", date).getResultList();
		return listEscala;
	}

	@Override
	public List<Escala> findByMatriculaAndItinerario(Integer matricula, String itinerario) {
		List<Escala> listEscala = (List<Escala>) 
				manager.createQuery("SELECT e FROM Escala e WHERE e.matriculaFucionario = :matricula and e.itinerario = :itinerario", Escala.class)
				.setParameter("matriculaFucionario", matricula).setParameter("itinerario", itinerario).getResultList();
		return listEscala;
	}

	@Override
	public List<Escala> findByDataEscalaAndItinerario(Date date, String itinerario) {
		List<Escala> listEscala = (List<Escala>) 
				manager.createQuery("SELECT e FROM Escala e WHERE e.dataEscala = :date and e.itinerario = :itinerario", Escala.class)
				.setParameter("dataEscala", date).setParameter("itinerario", itinerario).getResultList();
		return listEscala;
	}
	
	@Override
	public List<Escala> findByMatriculaDataEscalaItinerario(Integer matricula, Date date, String itinerario) {
		List<Escala> listEscala = (List<Escala>) 
				manager.createQuery("SELECT e FROM Escala e WHERE e.matriculaFucionario = :matricula and e.dataEscala = :date and e.itinerario = :itinerario", Escala.class)
				.setParameter("matriculaFucionario", matricula).setParameter("dataEscala", date).setParameter("itinerario", itinerario).getResultList();
		return listEscala;
	}

}