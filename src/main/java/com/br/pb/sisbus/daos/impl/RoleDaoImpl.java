package com.br.pb.sisbus.daos.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.br.pb.sisbus.daos.RoleDao;
import com.br.pb.sisbus.models.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public List<Role> all() {
		return manager.createQuery("select c from Role c", Role.class).getResultList();
	}

	@Override
	public void save(Role role) {
		manager.persist(role);
	}

	@Override
	public Role findByName(String name) {
		List<Role> role = manager.createQuery("select c from Role c where c.name = :name" , Role.class).setParameter("name", name).getResultList();
		if(role.isEmpty()){			
			throw new UsernameNotFoundException("Não existe ROLE cadastrada");
		}
		return role.get(0);
	}

	@Override
	public void remove(Role role) {
		manager.remove(role);
	}

	@Override
	public void update(Role role) {
		manager.merge(role);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Role> findRolesUsuario() {
		return (Set<Role>) manager.createQuery("select r from Role r", Role.class).getResultList();
	}

	@Override
	public void merge(Role role) {
		manager.merge(role);
	}

	@Override
	public Role findRoleByIdUsuario(Long id) {
		List<Role> resultRole = manager.createQuery("SELECT r FROM Role r WHERE r.id = :id", Role.class).
				setParameter("id" , id).getResultList();
		if(resultRole.isEmpty()){
			System.out.println("Combinação Role e Funcionario não existente!");
		}
		return resultRole.get(0);
	}
}