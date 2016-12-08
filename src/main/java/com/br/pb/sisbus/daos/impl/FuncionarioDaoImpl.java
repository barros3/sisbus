package com.br.pb.sisbus.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.FuncionarioDao;
import com.br.pb.sisbus.models.Funcionario;
import com.br.pb.sisbus.models.PaginatedList;

@Repository
public class FuncionarioDaoImpl implements FuncionarioDao {

	@PersistenceContext
	private EntityManager manager;

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public List<Funcionario> all() {
		return manager.createQuery("select p from Funcionario p", Funcionario.class).getResultList();
	}

	public void save(Funcionario funcionario) {
		manager.persist(funcionario);
	}

	public Funcionario findById(Long id) {
		return manager.find(Funcionario.class, id);
	}

	public void remove(Funcionario funcionario) {
		manager.remove(funcionario);
	}

	public void update(Funcionario funcionario) {
		manager.merge(funcionario);
	}

	public Funcionario merge(Funcionario funcionario) {
		return manager.merge(funcionario);
	}

	public PaginatedList paginated(int page, int max) {
		return new PaginatorQueryHelper().list(manager, Funcionario.class, page, max);
	}

	public Funcionario findByLoginAndSenha(String login, String senha) {
		return (Funcionario) manager
				.createQuery("select c from Funcionario where c.login = :login and c.senha = :senha")
				.setParameter("login", login).setParameter("senha", senha).getSingleResult();
	}

	@Override
	public Integer lastFuncionario() {
		Integer resultInt = 0;
		try {
			Query result = (Query) manager.createQuery("SELECT LAST_INSERT_ID(idFuncionario) from Funcionario ORDER BY idFuncionario DESC", Funcionario.class).setMaxResults(1).setFirstResult(0);
			String resultMatricula = (String) result.getParameterValue("matricula");
			resultInt = Integer.valueOf(resultMatricula);
		} catch (Exception e) {
		}
		return resultInt;
	}
}
