package com.br.pb.sisbus.enuns;

public enum AvariaChamado {
	
	COLISÃO("Colisão"),
	QUEBROU("Quebrou"),
	TRANSITO("Transito");
	
	private String value;
		
	AvariaChamado(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}

}
