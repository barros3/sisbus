package com.br.pb.sisbus.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.br.pb.sisbus.models.ConfigQuadroHorario;
import com.br.pb.sisbus.models.PaginatedList;

public interface ConfigQuadroHorarioDao {

	public void setManager(EntityManager manager);
	
	public void save(ConfigQuadroHorario configQuadroHorario);
	public void remove(ConfigQuadroHorario configQuadroHorario);
	public void update(ConfigQuadroHorario configQuadroHorario);
	public ConfigQuadroHorario findById(Long id);
	public ConfigQuadroHorario merge(ConfigQuadroHorario configQuadroHorario);
	public List<ConfigQuadroHorario> all();
	public PaginatedList paginated(int page, int max);
	
}