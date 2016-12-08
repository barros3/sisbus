package com.br.pb.sisbus.enuns;

public enum TipoCargaHoraria {

	VINTE_QUATRO_HRS("24 horas", 1), OUTROS("Outros", 2);

	private String item;
	private Integer value;

	TipoCargaHoraria(String item, Integer value) {
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