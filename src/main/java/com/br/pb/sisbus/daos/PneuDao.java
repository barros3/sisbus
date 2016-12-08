package com.br.pb.sisbus.daos;

import java.util.List;

import javax.persistence.EntityManager;

import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.models.Pneu;
import com.br.pb.sisbus.models.Veiculo;

public interface PneuDao {

	public void setManager(EntityManager manager);
	public List<Pneu> all();
	public void save(Pneu pneu);
	public Pneu findById(Long id);
	public Pneu findPneuByVeiculo(Veiculo veiculo);
	public void remove(Pneu pneu);
	public void update(Pneu pneu);
	public Pneu updateWithReturn(Pneu pneu);
	public PaginatedList paginated(int page, int max);

}
