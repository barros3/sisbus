package com.br.pb.sisbus.enuns;

public enum TipoRepouso {

	VARIAVEL("VARIAVEL"), FIXO("FIXO");

	private String value;

	TipoRepouso(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}
