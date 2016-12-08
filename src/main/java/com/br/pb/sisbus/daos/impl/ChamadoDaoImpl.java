package com.br.pb.sisbus.daos.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.br.pb.sisbus.daos.ChamadoDao;
import com.br.pb.sisbus.enuns.StatusChamado;
import com.br.pb.sisbus.models.Chamado;
import com.br.pb.sisbus.models.PaginatedList;

@Repository
public class ChamadoDaoImpl implements ChamadoDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Chamado> all() {
		return manager.createQuery("select c from Chamado c", Chamado.class).getResultList();
	}
	
	@Override
	@Transactional
	public void save(Chamado chamado) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		Date dateHora = new Date();
		dateFormat.format(date);
		horaFormat.format(dateHora);
		
		chamado.setDataChamado(date);
		chamado.setHoraChamado(dateHora);
		chamado.setStatus(StatusChamado.ABERTO);
		manager.persist(chamado);		
	}
	
	public Chamado findById(Long id) {
		return manager.find(Chamado.class, id);
	}

	public void remove(Chamado chamado) {
		manager.remove(chamado);
	}

	public void update(Chamado chamado) {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//Date date = new Date();
		//dateFormat.format(date);
		//chamado.setData_fechamento(date);
		manager.merge(chamado);
	}
	
	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Chamado.class, page, max);
	}

	@Override
	public Chamado findByIdChamado(Long idChamado) {
		Chamado chamado = manager.createQuery("SELECT c FROM Chamado c WHERE c.usuario_id = :idUsuario", Chamado.class).setParameter("usuario_id", idChamado).getSingleResult();
		return chamado;
	}
	
	
	

}
