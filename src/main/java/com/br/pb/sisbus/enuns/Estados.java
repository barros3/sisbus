package com.br.pb.sisbus.enuns;

public enum Estados {

	AC("AC"), // Acre
    AL("AL"), // Alagoas
    AP("AP"), // Amapá
    AM("AM"), // Amazonas
    BA("BA"), // Bahia
    CE("CE"), // Ceará
    DF("DF"), // Distrito Federal
    ES("ES"), // Espírito Santo
    GO("GO"), // Goiás
    MA("MA"), // Maranhão
    MT("MT"), // Mato Grosso
    MS("MS"), // Mato Grosso do Sul
    MG("MG"), // Minas Gerais
    PA("PA"), // Pará
    PB("PB"), // Paraíba
    PR("PR"), // Paraná
    PE("PE"), // Pernambuco
    PI("PI"), // Piauí
    RR("RR"), // Roraima
    RO("RO"), // Rondônia
    RJ("RJ"), // Rio de Janeiro
    RN("RN"), // Rio Grande do Norte
    RS("RS"), // Rio Grande do Sul
    SC("SC"), // Santa Catarina
    SP("SP"), // São Paulo
    SE("SE"), // Sergipe
    TO("TO"); // Tocantins
    
    private String value;
    
    Estados(String value){
        this.value = value;
    }

    public String toString(){
        return value;
    } 
    
	
}
