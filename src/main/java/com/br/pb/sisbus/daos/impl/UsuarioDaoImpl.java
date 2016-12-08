package com.br.pb.sisbus.daos.impl;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.UsuarioDao;
import com.br.pb.sisbus.models.PaginatedList;
import com.br.pb.sisbus.models.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{

	@PersistenceContext
	private EntityManager manager;

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public List<Usuario> all() {
		return manager.createQuery("select c from Usuario c", Usuario.class).getResultList();
	}

	public void save(Usuario usuario) {
		manager.persist(usuario);
	}

	public Usuario findById(Long id) {
		return manager.find(Usuario.class, id);
	}

	public void remove(Usuario usuario) {
		manager.remove(usuario);
	}

	public void update(Usuario usuario) {
		manager.merge(usuario);
	}
	
	public Usuario merge(Usuario usuario) {
		return manager.merge(usuario);
	}

	public Usuario findByLoginAndSenha(String login, String senha) {
//		List<Usuario> users = manager.createQuery("select c from Usuario c where c.login = :login and c.senha = :encodedPassword", Usuario.class)
//				.setParameter("login", login)
//				.setParameter("encodedPassword", senha).getResultList();
//		if (users.isEmpty()) {
//			throw new UsernameNotFoundException("Combinação de usuario e senha não existe");
//		}
//		return users.get(0);
		return null;
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Usuario.class, page, max);
	}

	@Override
	public Usuario findByName(String login) {
		Usuario user = manager.createQuery("select c from Usuario c where c.login = :login", Usuario.class)
				.setParameter("login", login).getSingleResult();
		return user;
	}
}