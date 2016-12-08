package com.br.pb.sisbus.daos;

import java.util.List;

import com.br.pb.sisbus.models.Administrador;
import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.models.Usuario;

public interface AdministradorDao {

	public void save(Administrador administrador);
	public void remove(Administrador administrador);
	public void update(Administrador administrador);
	public Usuario findUsuarioByAdministrador(Administrador administrador);
	public Administrador findById(Long id);
	public List<Administrador> all();
	public PaginatedList paginated(int page, int max);
	
}
