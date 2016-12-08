package com.br.pb.sisbus.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.br.pb.sisbus.models.Funcionario;

/**
 * 
 * @author root
 *
 */

@Component
public class ValidatorFuncionario implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matricula", "field.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "field.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cpf", "field.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rg", "field.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "exameDeSaude", "field.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "funcao", "field.empty");

		Funcionario funcionario = (Funcionario) target;

		if (isValidCPF(funcionario.getCpf()) == false) {
			errors.rejectValue("cpf", "field.cpc", "CPF inválido");
		}
		if(funcionario.getRg().length() > 16){
			errors.rejectValue("rg", "field.cpc", "Impossivel cadastrar RG com mais de 15 dígitos !!!");
		}
			
	}
	
	private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
	   private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
	   private static int calcularDigito(String str, int[] peso) {
	      int soma = 0;
	      for (int indice=str.length()-1, digito; indice >= 0; indice-- ) {
	         digito = Integer.parseInt(str.substring(indice,indice+1));
	         soma += digito*peso[peso.length-str.length()+indice];
	      }
	      soma = 11 - soma % 11;
	      return soma > 9 ? 0 : soma;
	   }
	
	public static boolean isValidCPF(String cpf) {   
	      if ((cpf==null) || (cpf.replaceAll("\\W","").length()!=11)) return false;   
	      
	      String cpfNoChar = cpf.replaceAll("\\W","");
	      Integer digito1 = calcularDigito(cpfNoChar.substring(0,9), pesoCPF);   
	      Integer digito2 = calcularDigito(cpfNoChar.substring(0,9) + digito1, pesoCPF);   
	      
	      return cpfNoChar.equals(cpfNoChar.substring(0,9) + digito1.toString() + digito2.toString());   
	   }
	
	 public static boolean isValidCNPJ(String cnpj) {
	      if ((cnpj==null)||(cnpj.length()!=14)) return false;
	      Integer digito1 = calcularDigito(cnpj.substring(0,12), pesoCNPJ);
	      Integer digito2 = calcularDigito(cnpj.substring(0,12) + digito1, pesoCNPJ);
	      return cnpj.equals(cnpj.substring(0,12) + digito1.toString() + digito2.toString());
	   }
	
}
