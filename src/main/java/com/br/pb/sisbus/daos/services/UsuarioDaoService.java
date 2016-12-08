package com.br.pb.sisbus.daos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.pb.sisbus.daos.EnderecoDao;
import com.br.pb.sisbus.daos.FuncionarioDao;
import com.br.pb.sisbus.daos.UsuarioDao;
import com.br.pb.sisbus.daos.UsuarioSessionDao;
import com.br.pb.sisbus.models.Endereco;
import com.br.pb.sisbus.models.Funcionario;
import com.br.pb.sisbus.models.Usuario;


/**
 * @author root
 *
 * Esta classe é responsavel por fazer a ligacao entre oo funcionario e o usuario.
 *
 *
 */

@Service
public class UsuarioDaoService {
	
//	@Autowired
//	EnderecoDao enderecoDao;
//
//	@Autowired
//	FuncionarioDao funcionarioDao;
//
//	@Autowired
//	PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	UsuarioDao usuarioDao;
//	
//	@Autowired
//	private UsuarioSessionDao usuarioSessionDao;
//
//	public final void saveUsuario(Funcionario funcionario) {
//		try {
//			Endereco endereco = new Endereco();
//
////			CRIPTOGRAFA E SETA A SENHA DO USUARIO
//			funcionario.getUsuario().setSenha(passwordEncoder.encode(funcionario.getUsuario().getSenha()));
//			
////			BUSCA O ENDERECO DO USUARIO
//			Endereco resultEndereco = new Endereco();
//			resultEndereco = enderecoDao.findByCEP(funcionario.getEndereco().getCep());
//			
////			VERIFICA SE EXISTE O endereco: SE NAO EXISTIR PERSISTE O endereco, SENAO PERSISTE O resultEndereco
//			if(resultEndereco == null || resultEndereco.equals(null)){
//				endereco = funcionario.getEndereco();
//				enderecoDao.save(endereco);
//				funcionarioDao.save(funcionario);				
//			}else{
//				funcionario.setEndereco(resultEndereco);
//				funcionarioDao.save(funcionario);				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public final void updateUsuario(Funcionario funcionario) {
//		try {
//			
//			Endereco endereco = new Endereco();
////			BUSCA O ENDERECO DO USUARIO
//			Endereco resultEndereco = new Endereco();
//			resultEndereco = enderecoDao.findByCEP(funcionario.getEndereco().getCep());
////			Usuario usuario = new Usuario();
////			usuario = usuarioSessionDao.findByLogin(funcionario.getUsuario().getLogin());
//			
////			VERIFICA SE EXISTE O endereco: SE NAO EXISTIR PERSISTE O endereco, SENAO PERSISTE O resultEndereco
//			if(resultEndereco == null || resultEndereco.equals(null)){
//				enderecoDao.save(funcionario.getEndereco());
////				endereco = funcionario.getEndereco();
//				funcionarioDao.update(funcionario);				
//			}else{
////				funcionario.setUsuario(usuario);
//				funcionario.getEndereco().setId(resultEndereco.getId());
//				usuarioSessionDao.update(funcionario.getUsuario());
//				funcionarioDao.update(funcionario);				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public final void deleteFuncionario(Funcionario funcionario){
//		try {
////			BUSCA O funcionario PELO id, SETA O endereco COMO null E REMOVE
//			funcionario = funcionarioDao.findById(funcionario.getId());
//			funcionario.setEndereco(null);
//			funcionarioDao.remove(funcionario);				
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
}