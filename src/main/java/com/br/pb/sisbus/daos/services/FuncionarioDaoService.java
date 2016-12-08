package com.br.pb.sisbus.daos.services;

import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.pb.sisbus.daos.EnderecoDao;
import com.br.pb.sisbus.daos.FuncionarioDao;
import com.br.pb.sisbus.models.Endereco;
import com.br.pb.sisbus.models.Funcionario;

/**
 * 
 * @author root
 *
 */

@Service
public class FuncionarioDaoService {
	
	@Autowired
	EnderecoDao enderecoDao;

	@Autowired
	FuncionarioDao funcionarioDao;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	public final void saveFuncionario(Funcionario funcionario) {
		try {
			Endereco endereco = new Endereco();
			
			funcionario.setMatricula(matriculationGenerated());
			/**	
			 * Busca o enderedo do usuario
			 * 
			*/	
			Endereco resultEndereco = new Endereco();
			resultEndereco = enderecoDao.findByCEP(funcionario.getEndereco().getCep());

			/**
			 * VERIFICA SE EXISTE O endereco: SE NAO EXISTIR PERSISTE O endereco, SENAO PERSISTE O resultEndereco
			 */
			
			if(resultEndereco == null || resultEndereco.equals(null)){
				endereco = funcionario.getEndereco();
				enderecoDao.save(endereco);
				funcionarioDao.save(funcionario);				
			}else{
				funcionario.setEndereco(resultEndereco);
				funcionarioDao.save(funcionario);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void updateFuncionario(Funcionario funcionario) {
		try {

			funcionario.setMatricula(matriculationGenerated());
			
			/**
			 * BUSCA O ENDERECO DO USUARIO
			 */
			Endereco resultEndereco = new Endereco();
			resultEndereco = enderecoDao.findByCEP(funcionario.getEndereco().getCep());
			
			/**
			 * VERIFICA SE EXISTE O endereco: SE NAO EXISTIR PERSISTE O endereco, SENAO PERSISTE O resultEndereco
			 */
			
			if(resultEndereco == null || resultEndereco.equals(null)){
				enderecoDao.save(funcionario.getEndereco());
				funcionarioDao.update(funcionario);				
			}else{
				funcionario.getEndereco().setId(resultEndereco.getId());
				funcionarioDao.update(funcionario);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public final void deleteFuncionario(Funcionario funcionario){
		try {
			
			/**
			 * BUSCA O funcionario PELO id, SETA O endereco COMO null E REMOVE
			 */
			
			funcionario = funcionarioDao.findById(funcionario.getId());
			funcionario.setEndereco(null);
			funcionarioDao.remove(funcionario);				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public Integer matriculationGenerated(){
		Period period = new Period();
		
		int ano = period.getYears();
		int mes = period.getMonths();
		
		funcionarioDao.lastFuncionario();
		
		
		String matriculaResult =  String.valueOf(period.getYears()) + String.valueOf(period.getMonths()) + String.valueOf(funcionarioDao.lastFuncionario());  
		
		int valor = Integer.valueOf(matriculaResult);
		
		return valor;
	}
	
}