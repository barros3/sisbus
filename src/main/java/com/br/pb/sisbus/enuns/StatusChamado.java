package com.br.pb.sisbus.enuns;

public enum StatusChamado {
	
	ABERTO("Aberto"),
	FECHADO("Fechado");
	
	private String value;
	
	
	StatusChamado(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}

}
