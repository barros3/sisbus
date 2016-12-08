package com.br.pb.sisbus.enuns;

/**
 * 
 * @author root
 *
 * font: https://www.tcm.go.gov.br/portal/arquivos-tcm/tabela-codificacao/Tabela_de_Escolaridade.pdf
 */

public enum TipoEscolaridade {

	FUNDAMENTAL_INCOMPLETO("Fundamental - Incompleto", 1),
	
	FUNDAMENTAL_COMPLETO("Fundamental - Completo", 2),
	
	MEDIO_INCOMPLETO("Médio - Incompleto", 3),
	
	MEDIO_COMPLETO("Médio - Completo", 4), 
	
	SUPERIOR_INCOMPLETO("Superior - Incompleto", 5),
	
	SUPERIOR_COMPLETO("Superior - Completo", 6),
	
	POS_GRADUACAO_LATO_SENSO_INCOMPLETO("Pós-graduação (Lato senso) - Incompleto", 7),
	
	POS_GRADUACAO_LATO_SENSO_COMPLETO("Pós-graduação (Lato senso) - Completo", 8),
	
	POS_GRADUACAO_STRICTO_SENSU_NIVEL_MESTRADO_INCOMPLETO("Pós-graduação (Stricto sensu, nível mestrado) - Incompleto", 9),
	
	POS_GRADUACAO_STRICTO_SENSU_NIVEL_MESTRADO_COMPLETO("Pós-graduação (Stricto sensu, nível mestrado) - Completo", 10),
	
	POS_GRADUAÇÃO_STRICTO_SENSU_NIVEL_DOUTOR_INCOMPLETO("Pós-graduação (Stricto sensu, nível doutor) - Incompleto", 11),
	
	POS_GRADUACAO_STRICTO_SENSU_NIVEL_DOUTOR_COMPLETO("Pós-graduação (Stricto sensu, nível doutor) - Completo", 12);

	private String item;
	private Integer value;

	private TipoEscolaridade(String item, Integer value) {
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