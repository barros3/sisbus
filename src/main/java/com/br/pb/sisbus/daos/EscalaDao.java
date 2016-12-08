package com.br.pb.sisbus.daos;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.br.pb.sisbus.models.Escala;
import com.br.pb.sisbus.models.PaginatedList;

public interface EscalaDao {

	public void setManager(EntityManager manager);
	
	public List<Escala> all();
	public void save(Escala escala);
	public Escala findById(Long id);
	public void remove(Escala escala);
	public void update(Escala escala);
	public Escala merge(Escala escala);
	
	public PaginatedList paginated(int page, int max);
	public PaginatedList paginatedMatricula(Integer matricula, int page, int max);
	public PaginatedList paginatedDataEscala(Date date, int page, int max);
	
	public Escala findByMatricula(Integer matricula);
	public List<Escala> findByDataEscala(Date date);
	public List<Escala> findByItinerario(String itinerario);
	
	public List<Escala> findByMatriculaAndDateEscale(Integer matricula,  Date date);
	public List<Escala> findByMatriculaAndItinerario(Integer matricula, String itinerario);
	public List<Escala> findByDataEscalaAndItinerario(Date date, String itinerario);
	
	public List<Escala> findByMatriculaDataEscalaItinerario(Integer matricula, Date date, String itinerario);
	
}
