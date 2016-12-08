package com.br.pb.sisbus.system.dao.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.system.dao.SystemSisBusQuadroHorarioGeradoDao;
import com.br.pb.sisbus.system.dao.services.SystemSisBusQuadroHorarioGeradoService;

/**
 * @author root
 * 
 * Verificar a quantidade de funcionarios escalados por dia
 * Separar escalas por horario de entrada
 * MONTAR O QUADRO DE HORARIO - campos: matricula, data e hora de entrada'
 * Atualizar diariamente na interface de quadro de horario
 * 
 */

@Repository
public class SystemSisBusQuadroHorarioGeradoServiceImpl implements SystemSisBusQuadroHorarioGeradoService{

	@Autowired
	SystemSisBusQuadroHorarioGeradoDao systemSisBusQuadroHorarioGeradoDao;

	@Override
	public PaginatedList gerarQuadroHorarioEscala(int page, int max) {
		return systemSisBusQuadroHorarioGeradoDao.paginatedListEscalaByDay(page, max);
	}
	
}