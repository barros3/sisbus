package com.br.pb.sisbus.system.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.br.pb.sisbus.models.PaginatedList;

/**
 * @author root
 * 
 */

public interface SystemSisBusQuadroHorarioGeradoDao {
	
	public PaginatedList paginatedListEscalaByDay(int page, int max);
	
	public <T> PaginatedList listEscalaPorDia(EntityManager manager, Class<T> klass, int currentPage, int max);

	public <T> PaginatedList list(TypedQuery<T> query, TypedQuery<Number> countQuery, int currentPage, int max);
	
}