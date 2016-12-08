package com.br.pb.sisbus.enuns;

public enum ExameDeSaude {

	SIM("Sim"), 
	NÃO("Não");

	private String value;

	ExameDeSaude(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
