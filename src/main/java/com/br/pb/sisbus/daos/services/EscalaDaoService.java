package com.br.pb.sisbus.daos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.pb.sisbus.daos.EscalaDao;
import com.br.pb.sisbus.models.Escala;
/**
 * 
 * @author root
 *
 */

@Service
public class EscalaDaoService {

	@Autowired 
	private EscalaDao escalaDao;
	
	public final void saveEscala(Escala escala){
		try{
			escalaDao.save(escala);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
