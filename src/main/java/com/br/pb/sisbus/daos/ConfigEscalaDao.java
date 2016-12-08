package com.br.pb.sisbus.daos;

import java.util.List;

import com.br.pb.sisbus.models.ConfigEscala;
import com.br.pb.sisbus.models.PaginatedList;

public interface ConfigEscalaDao {

	public void save(ConfigEscala configEscala);
	public void remove(ConfigEscala configEscala);
	public void update(ConfigEscala configEscala);
	public ConfigEscala findById(Long id);
	public ConfigEscala merge(ConfigEscala configEscala);
	public List<ConfigEscala> all();
	public PaginatedList paginated(int page, int max);
	
}