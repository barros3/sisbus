package com.br.pb.sisbus.system.dao.services;

import com.br.pb.sisbus.models.PaginatedList;

/**
 * @author root
 *
 */

public interface SystemSisBusQuadroHorarioGeradoService {
	
	public PaginatedList gerarQuadroHorarioEscala(int page, int max);
	
}