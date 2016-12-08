package com.br.pb.sisbus.enuns;

public enum TipoEstadoCivil {

	SOLTEIRO("Solteiro(a)", 1), UNIAO_ESTAVEL("União Estável",2), CASADO("Casado(a)", 3), DIVORCIADO("Divorciado(a)", 4), VIUVU("Viúvo(a)", 5);

	private String item;
	private Integer value;

	private TipoEstadoCivil(String item, Integer value) {
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