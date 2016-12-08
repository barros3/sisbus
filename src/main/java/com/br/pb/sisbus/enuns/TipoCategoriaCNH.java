package com.br.pb.sisbus.enuns;

public enum TipoCategoriaCNH {

	MOTO("A", 1), CARRO("B", 2), CARRO_MOTO("AB", 3), MOTO_CARRO_CARGA("AC", 4),
	
	MOTO_CARRO_CARGA_VIVA("AD", 5), MOTO_CARRO_CARGA_VIVA_TRUQUE("AE", 6),
	
	CARRO_CARGA("BC", 7), CARRO_CARGA_VIVA("BD", 8), CARRO_CARGA_VIVA_TRUQUE("BE", 9);

	private String item;
	private Integer value;

	private TipoCategoriaCNH(String item, Integer value) {
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