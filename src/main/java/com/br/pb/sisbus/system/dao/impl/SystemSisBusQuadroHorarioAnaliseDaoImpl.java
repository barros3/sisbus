package com.br.pb.sisbus.system.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.RotaDao;
import com.br.pb.sisbus.models.Rota;
import com.br.pb.sisbus.system.dao.SystemSisBusQuadroHorarioAnaliseDao;

/**
 * @author root
 * 
 */

@Repository
public class SystemSisBusQuadroHorarioAnaliseDaoImpl implements SystemSisBusQuadroHorarioAnaliseDao{

	@PersistenceContext
	private EntityManager manager;
	
	
	@Autowired
	private RotaDao rotaDao;
	
	@Override
	public List<Rota> listRotaByCodigoItinerario() {
		List<Rota> resultList = new ArrayList<Rota>();

		try{
		
			List<Rota> listRota = rotaDao.all();
			
			for(Rota rota: resultList){
//				if()
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
	
}