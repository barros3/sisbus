package com.br.pb.sisbus.enuns;

public enum TipoJornadaTrabalho {

	LABORAL("LABORAL"), SERVICO("SERVICO");

	private String value;

	TipoJornadaTrabalho(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
