package com.br.pb.sisbus.enuns;

public enum TipoPercurso {
	
	ROTA_CIRCULAR("Rota Circular", "Rota Circular"),
	ROTA_IDA_E_VOLTA("Rota Ida/Volta", "Rota Ida/Volta");
	
	private String value;
	private String item;
	
	TipoPercurso(String item, String value){
		this.item = item;
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
	
	public String getItem(){
		return item;
	}
	
	
	
}
