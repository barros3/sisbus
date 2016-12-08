package com.br.pb.sisbus.daos.services;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.pb.sisbus.daos.AdministradorDao;
import com.br.pb.sisbus.models.Administrador;
import com.br.pb.sisbus.models.Role;

@Service
public class AdministradorDaoService {
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	AdministradorDao administradorDao;

	public final void saveAdministrador(Administrador administrador) {
		try {
//			CRIPTOGRAFA E SETA A SENHA DO administrador
			administrador.getUsuario().setSenha(passwordEncoder.encode(administrador.getUsuario().getSenha()));
			
			Set<Role> listRole = new HashSet<Role>();
			Role role = new Role("ADMIN");
			listRole.add(role);
			administrador.getUsuario().setRoles(listRole);
			
			administradorDao.save(administrador);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
// 	A SENHA NAO PODE SER ALTERADA PELO updateUsuario 
	public final void updateUsuario(Administrador administrador) {
		try {
//			Usuario usuario = usuarioSessionDao.findByName(administrador.getUsuario().getLogin());
//			administrador.setUsuario(usuario);
//			Set<Role> listRole = new HashSet<Role>();
//			Role role = new Role("ADMIN");
//			listRole.add(role);
//			administrador.getUsuario().setRoles(listRole);
			administrador = administradorDao.findById(administrador.getId());
			administradorDao.update(administrador);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void deleteAdministrador(Administrador administrador){
		try {
//			BUSCA O administrador PELO id PARA REMOVER
			administrador = administradorDao.findById(administrador.getId());
			administradorDao.remove(administrador);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}