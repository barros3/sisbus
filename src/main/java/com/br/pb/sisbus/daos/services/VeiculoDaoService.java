package com.br.pb.sisbus.daos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.br.pb.sisbus.daos.UsuarioSessionDao;
import com.br.pb.sisbus.daos.VeiculoDao;
import com.br.pb.sisbus.models.Usuario;
import com.br.pb.sisbus.models.Veiculo;

@Service
public class VeiculoDaoService {

	@Autowired
	private VeiculoDao veiculoDao;
	
	@Autowired
	private UsuarioSessionDao usuarioSessionDao;
	
	public final void saveVeiculo(Veiculo veiculo) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nome = auth.getName();
		try {
			
//			BUSCA O ID DO USUARIO DA SESSAO E ATRIBUI PARA O VEICULO
			Usuario usuario = usuarioSessionDao.findByLogin(nome);			
			veiculo.setUsuario(usuario);
			
//			SALVO O VEICULO			
			veiculoDao.save(veiculo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	EDITA O VEICULO
	public final void updateVeiculo(Veiculo veiculo){
		try {
			veiculoDao.update(veiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	REMOVE O VEICULO E EM CASCATA O PNEU
	public final void deleteVeiculo(Veiculo veiculo){
		try {
			veiculo.setUsuario(null);
			veiculoDao.remove(veiculo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}