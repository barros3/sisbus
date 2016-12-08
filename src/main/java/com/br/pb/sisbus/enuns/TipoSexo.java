package com.br.pb.sisbus.enuns;

public enum TipoSexo {

	MASCULINO("Masculino", 1), FEMININO("Feminino", 2);

	private String item;
	private Integer value;

	private TipoSexo(String item, Integer value) {
		this.item = item;
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public String getItem() {
		return item;
	}
}