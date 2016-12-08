package com.br.pb.sisbus.enuns;

public enum PrioridadeChamado {
	
	NORMAL("Normal"),
	URGENTE("Urgente");
	
	private String value;
	
	
	PrioridadeChamado(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}

}
