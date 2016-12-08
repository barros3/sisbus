package com.br.pb.sisbus.system.dao;

import java.util.List;

import com.br.pb.sisbus.models.Rota;

/**
 * @author root
 * 
 */

public interface SystemSisBusQuadroHorarioAnaliseDao {
	
	public List<Rota> listRotaByCodigoItinerario();
	
}