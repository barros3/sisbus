package com.br.pb.sisbus.daos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.pb.sisbus.daos.UsuarioDao;
import com.br.pb.sisbus.models.Usuario;

@Service
public class UsuarioOddDaoService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UsuarioDao usuarioDao;

	public final void saveUsuarioOdd(Usuario usuario) {
		try {
			usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
			usuarioDao.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void updateUsuarioOdd(Usuario usuario){
		try {
			Usuario resultUsuario = usuarioDao.findById(usuario.getId());
			usuario.setSenha(resultUsuario.getSenha());
			usuarioDao.update(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}