package com.br.pb.sisbus.system.dao.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.models.Escala;
import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.system.dao.SystemSisBusQuadroHorarioGeradoDao;

/**
 * @author root
 * 
 */

@Repository
public class SystemSisBusQuadroHorarioGeradoDaoImpl implements SystemSisBusQuadroHorarioGeradoDao{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public PaginatedList paginatedListEscalaByDay(int page, int max) {
		
		return new SystemSisBusQuadroHorarioGeradoDaoImpl().listEscalaPorDia(manager, Escala.class, page, max);
	
	}
	
	public <T> PaginatedList listEscalaPorDia(EntityManager manager, Class<T> klass, int currentPage, int max) {

		if (!klass.isAnnotationPresent(Entity.class)) {
			throw new IllegalArgumentException("Sua Entidade não tem anotação: @Entity");
		}

		
		/**
		 * as proximas duas linhas pegam a data de hoje
		 */
		
		Calendar calendar = Calendar.getInstance();
		Date hoje = calendar.getTime();
		
		TypedQuery<T> resultQuery = (TypedQuery<T>) manager.createQuery("SELECT e FROM  " + klass.getSimpleName() + " e WHERE e.dataEscala = :hoje ORDER BY e.horaEntrada" , klass)
				.setParameter("hoje", hoje);
		
		TypedQuery<Number> countQuery = manager.createQuery("select count(1) from " + klass.getSimpleName() + " o",
				Number.class);

		
		return list(resultQuery, countQuery, currentPage, max);
	}
	
	public <T> PaginatedList list(TypedQuery<T> query, TypedQuery<Number> countQuery, int currentPage, int max) {
		
		List<T> currentList = query.setFirstResult(currentPage * max).setMaxResults(max).getResultList();
		
		Number count = countQuery.getSingleResult();
		
		return new PaginatedList(currentList, count);
		
	}
	
}