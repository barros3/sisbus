package com.br.pb.sisbus.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.br.pb.sisbus.models.ConfigAcesso;
import com.br.pb.sisbus.models.PaginatedList;

public interface ConfigAcessoDao {

	public void setManager(EntityManager manager);
	public void save(ConfigAcesso configAcesso);
	public void remove(ConfigAcesso configAcesso);
	public void update(ConfigAcesso configAcesso);
	public ConfigAcesso findById(Long id);
	public ConfigAcesso merge(ConfigAcesso configAcesso);
	public List<ConfigAcesso> all();
	public PaginatedList paginated(int page, int max);
}