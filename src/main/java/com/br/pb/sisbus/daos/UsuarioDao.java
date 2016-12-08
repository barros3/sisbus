package com.br.pb.sisbus.daos;
import java.util.List;

import javax.persistence.EntityManager;

import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.models.Usuario;

public interface UsuarioDao {

	public void setManager(EntityManager manager);
	public List<Usuario> all();
	public void save(Usuario usuario);
	public Usuario findById(Long id);
	public void remove(Usuario usuario);
	public void update(Usuario usuario);
	public Usuario merge(Usuario usuario);
	public Usuario findByLoginAndSenha(String login, String senha);
	public PaginatedList paginated(int page, int max);

	public Usuario findByName(String username);
	
}