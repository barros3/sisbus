package com.br.pb.sisbus.models;


import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.br.pb.sisbus.converters.ConverterLocalTimeAttribute;
import com.br.pb.sisbus.enuns.TipoJornadaTrabalho;
import com.br.pb.sisbus.enuns.TipoRepouso;

@Entity
@Table(name = "tb_config_escala")
public class ConfigEscala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false , name = "jornadaTrabalho")
	private TipoJornadaTrabalho jornadaTrabalho;
	
	@Column (length = 11, nullable = false, precision=10, scale=2)
	private Integer cargaHorario;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIME)
	private Date excedente;
	
	@Column(nullable = false)
	private Boolean bancoHora;
	
	@Column(nullable = true)
	private Integer limiteBancoHora;
	
	@Column(length = 20, nullable = true , name = "tipoRepouso")
	private TipoRepouso tipoRepouso;
	
	@Column(nullable = true)
	private String repouso;
	
	@Column(nullable = true)
	@Convert(converter = ConverterLocalTimeAttribute.class)
	private LocalTime tempoMaxRepouso;
	
	@Column(nullable = true)
	private Integer quantidadeViagem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoJornadaTrabalho getJornadaTrabalho() {
		return jornadaTrabalho;
	}
	public void setJornadaTrabalho(TipoJornadaTrabalho jornadaTrabalho) {
		this.jornadaTrabalho = jornadaTrabalho;
	}
	public Integer getCargaHorario() {
		return cargaHorario;
	}
	public void setCargaHorario(Integer cargaHorario) {
		this.cargaHorario = cargaHorario;
	}
	public Date getExcedente() {
		return excedente;
	}
	public void setExcedente(Date excedente) {
		this.excedente = excedente;
	}
	public Boolean getBancoHora() {
		return bancoHora;
	}
	public void setBancoHora(Boolean bancoHora) {
		this.bancoHora = bancoHora;
	}
	public Integer getLimiteBancoHora() {
		return limiteBancoHora;
	}
	public void setLimiteBancoHora(Integer limiteBancoHora) {
		this.limiteBancoHora = limiteBancoHora;
	}
	public TipoRepouso getTipoRepouso() {
		return tipoRepouso;
	}
	public void setTipoRepouso(TipoRepouso tipoRepouso) {
		this.tipoRepouso = tipoRepouso;
	}
	public LocalTime getTempoMaxRepouso() {
		return tempoMaxRepouso;
	}
	public void setTempoMaxRepouso(LocalTime tempoMaxRepouso) {
		this.tempoMaxRepouso = tempoMaxRepouso;
	}
	public Integer getQuantidadeViagem() {
		return quantidadeViagem;
	}
	public void setQuantidadeViagem(Integer quantidadeViagem) {
		this.quantidadeViagem = quantidadeViagem;
	}
	public String getRepouso() {
		return repouso;
	}
	public void setRepouso(String repouso) {
		this.repouso = repouso;
	}
	public ConfigEscala(){}
}