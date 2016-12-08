package com.br.pb.sisbus.daos;

import java.util.List;
import javax.persistence.EntityManager;
import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.models.Chamado;

public interface ChamadoDao {

	public void setManager(EntityManager manager);
	
	public List<Chamado> all();
	
	public void save(Chamado chamado);
	
	public Chamado findById(Long id);
	
	public Chamado findByIdChamado(Long idChamado);
	
	public void remove(Chamado chamado);
	
	public void update(Chamado chamado);
	
	public PaginatedList paginated(int page, int max);
	
}
