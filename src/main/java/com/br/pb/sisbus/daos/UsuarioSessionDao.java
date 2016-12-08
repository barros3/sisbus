package com.br.pb.sisbus.daos;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.security.core.userdetails.UserDetails;

import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.models.Usuario;

public interface UsuarioSessionDao {

	public void setManager(EntityManager manager);
	public void save(Usuario usuario);
	public void remove(Usuario usuario);
	public void update(Usuario usuario);
	public Usuario findById(Long id);
	public Usuario findByLogin(String username);
	public Usuario findByLoginAndSenha(String login, String senha);
	public Usuario findUsuarioByIdFuncionario(Long idFuncionario);
	public List<Usuario> all();
	public UserDetails loadUserByUsername(String login);
	public PaginatedList paginated(int page, int max);
}