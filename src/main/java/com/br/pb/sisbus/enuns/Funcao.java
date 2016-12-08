package com.br.pb.sisbus.enuns;

public enum Funcao {
	
	FISCAL("Fiscal"),
	COBRADOR("Cobrador"),
	MOTORISTA("Motorista");
	
	private String value;
	
	Funcao(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}

}
