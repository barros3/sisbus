package com.br.pb.sisbus.system.dao.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.system.dao.SystemSisBusQuadroHorarioAnaliseDao;
import com.br.pb.sisbus.system.dao.services.SystemSisBusQuadroHorarioAnaliseService;

/**
 * @author root
 * 
 * Verificar itinerário 
 * Verificar quantidade de passageiros por viagem
 * Verifivar horário
 * Verificar escala
 * Informar a quantidade de funcionários necessários por horario
 * Apresentar quadro de horario
 * 
 * Enviar análise por email para: GESTOR, ADMIN_MASTER e apresentar sugestão para escala de funcionários
 */

@Repository
public class SystemSisBusQuadroHorarioAnaliseServiceImpl implements SystemSisBusQuadroHorarioAnaliseService{

	@Autowired
	private SystemSisBusQuadroHorarioAnaliseDao systemSisBusQuadroHorarioAnaliseDao;

	@Override
	public PaginatedList gerarQuadroHorarioEscala(int page, int max) {
		return null;
	}
	
}