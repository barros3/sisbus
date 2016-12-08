package com.br.pb.sisbus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author root
 *
 */

@Entity
@Table(name = "tb_pneu")
public class Pneu {
	
	@Id
	@Column(name="idpneu")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (length = 11, nullable = false, precision=10, scale=2)
	private Integer milimetro;
		
	@Column (length = 30, nullable = true , name="fabricante")
	private String fabricante;
	
	@Column (nullable = false , name="quantidade")
	private Integer quantidade;
	
	@Column (length = 15, nullable = false , name="modelo")
	private String modelo;
	
	public Integer getMilimetro() {
		return milimetro;
	}
	public void setMilimetro(Integer milimetro) {
		this.milimetro = milimetro;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
