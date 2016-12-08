package com.br.pb.sisbus.enuns;

public enum TipoPermissao {

	ROLE_ADMIN("ADMINISTRADOR", "ADMIN"), ROLE_GESTOR("GESTOR", "GESTOR"), ROLE_FUNC("FUNCIONARIO", "FUNCIONARIO");

	private final String item;
	private final String value;

	private TipoPermissao(String item, String value) {
		this.item = item;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String getItem() {
		return item;
	}
}