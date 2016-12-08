package com.br.pb.sisbus.system.dao.services;

import com.br.pb.sisbus.models.PaginatedList;

/**
 * @author root
 *
 */

public interface SystemSisBusQuadroHorarioAnaliseService {
	
	public PaginatedList gerarQuadroHorarioEscala(int page, int max);
	
}