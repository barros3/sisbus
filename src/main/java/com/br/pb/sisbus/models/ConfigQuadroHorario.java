package com.br.pb.sisbus.models;


import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.br.pb.sisbus.converters.ConverterLocalTimeAttribute;
import com.br.pb.sisbus.enuns.TipoCargaHoraria;
import com.br.pb.sisbus.enuns.TipoIntervalo;

/**
 * 
 * @author root
 *
 */

@Entity
@Table(name = "tb_config_quadro_horario")
public class ConfigQuadroHorario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.ORDINAL)
	@Column(nullable = false , name = "tipointervalo")
	private TipoIntervalo tipoIntervalo;
	
	@Column (nullable = false)
	@Enumerated(EnumType.ORDINAL)
	private TipoCargaHoraria tipoCargaHoraria;
	
	@Column(nullable = false, name = "tempoDeIntervalo")
	@Convert(converter = ConverterLocalTimeAttribute.class)
	private LocalTime tempoIntervalo;
	
	@Column(length = 255, nullable = true)
	private String intervalo;
	
	@Column(length = 25, nullable = true)
	private String intervaloCompleto;
	
	@Column(nullable = true)
	@Convert(converter = ConverterLocalTimeAttribute.class)
	private LocalTime tempoParaIntervalo;
	
	@Column(nullable = true)
	private Integer cargaHoraria;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoIntervalo getTipoIntervalo() {
		return tipoIntervalo;
	}
	public void setTipoIntervalo(TipoIntervalo tipoIntervalo) {
		this.tipoIntervalo = tipoIntervalo;
	}
	public TipoCargaHoraria getTipoCargaHoraria() {
		return tipoCargaHoraria;
	}
	public void setTipoCargaHoraria(TipoCargaHoraria tipoCargaHoraria) {
		this.tipoCargaHoraria = tipoCargaHoraria;
	}
	public LocalTime getTempoIntervalo() {
		return tempoIntervalo;
	}
	public void setTempoIntervalo(LocalTime tempoIntervalo) {
		this.tempoIntervalo = tempoIntervalo;
	}
	public String getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(String intervalo) {
		this.intervalo = intervalo;
	}
	public String getIntervaloCompleto() {
		return intervaloCompleto;
	}
	public void setIntervaloCompleto(String intervaloCompleto) {
		this.intervaloCompleto = intervaloCompleto;
	}
	public LocalTime getTempoParaIntervalo() {
		return tempoParaIntervalo;
	}
	public void setTempoParaIntervalo(LocalTime tempoParaIntervalo) {
		this.tempoParaIntervalo = tempoParaIntervalo;
	}
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public ConfigQuadroHorario(){}
}