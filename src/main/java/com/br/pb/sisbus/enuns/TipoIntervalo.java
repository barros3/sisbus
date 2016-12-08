package com.br.pb.sisbus.enuns;

public enum TipoIntervalo {

	FIXO(1), ESCALONAR(2);

	private Integer value;

	TipoIntervalo(Integer value) {
		this.value = value;
	}
	public Integer getValue() {
		return value;
	}
}