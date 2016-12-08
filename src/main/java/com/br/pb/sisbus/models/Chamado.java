package com.br.pb.sisbus.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.br.pb.sisbus.enuns.AvariaChamado;
import com.br.pb.sisbus.enuns.PrioridadeChamado;
import com.br.pb.sisbus.enuns.StatusChamado;

@Entity
@Table(name = "tb_chamado")
public class Chamado {
	
	@Id
	@Column(name="id_chamado")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private AvariaChamado avaria;
	
	@Column(length = 50, nullable = false)	//	Obter da tabela Usuário
	private String responsavel;
	
	@Column(length = 15, nullable = false)
	private String codigoVeiculo;
	
	@Column(length = 40, nullable = false)
	private String localizacao;
	
	@Column(nullable = true)
	private String referencia;
	
	@Column(nullable = true)
	private String observacao;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PrioridadeChamado prioridade;
		
	@Column(columnDefinition = "VARCHAR(255) DEFAULT 'ABERTO'")
	@Enumerated(EnumType.STRING)
	private StatusChamado status;
	
	@Column(nullable = false , name = "data_chamado")
	@Temporal(TemporalType.DATE)
	private Date dataChamado;
	
	@Column(nullable = false , name = "hora_chamado")
	@Temporal(TemporalType.TIME)
	private Date horaChamado;
			
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
		
	@Column(nullable = true)
	private String responsavel_fechamento;
	
	@Column(nullable = true, columnDefinition = "TEXT")
	private String motivo_fechamento;
	
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_fechamento;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AvariaChamado getAvaria() {
		return avaria;
	}

	public void setAvaria(AvariaChamado avaria) {
		this.avaria = avaria;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getCodigoVeiculo() {
		return codigoVeiculo;
	}

	public void setCodigoVeiculo(String codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public PrioridadeChamado getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeChamado prioridade) {
		this.prioridade = prioridade;
	}

	public StatusChamado getStatus() {
		return status;
	}

	public void setStatus(StatusChamado status) {
		this.status = status;
	}
	
	public Date getDataChamado() {
		return dataChamado;
	}

	public void setDataChamado(Date dataChamado) {
		this.dataChamado = dataChamado;
	}

	public Date getHoraChamado() {
		return horaChamado;
	}

	public void setHoraChamado(Date horaChamado) {
		this.horaChamado = horaChamado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getResponsavel_fechamento() {
		return responsavel_fechamento;
	}

	public void setResponsavel_fechamento(String responsavel_fechamento) {
		this.responsavel_fechamento = responsavel_fechamento;
	}

	public String getMotivo_fechamento() {
		return motivo_fechamento;
	}

	public void setMotivo_fechamento(String motivo_fechamento) {
		this.motivo_fechamento = motivo_fechamento;
	}

	public Date getData_fechamento() {
		return data_fechamento;
	}

	public void setData_fechamento(Date data_fechamento) {
		this.data_fechamento = data_fechamento;
	}

	
}
