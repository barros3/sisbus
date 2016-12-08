package com.br.pb.sisbus.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author root
 *
 */

@Entity
@Table(name = "tb_veiculo")
public class Veiculo {

	@Id
	@Column(name = "idVeiculo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false , unique = true, name = "num_ordem")
	private Integer numeroOrdem;

	@Column(length = 30, unique = true, nullable = false , name = "placa")
	private String placa;

	@Column(nullable = false , name = "validade_placa")
	@Temporal(TemporalType.DATE)
	private Date validadeEmplacamento;

	@Column(length = 30, nullable = false , name = "tipocarroceria")
	private String tipoCarroceria;

	@Column(length = 11, nullable = false , name = "capacidadePassageiro")
	private Integer capacidadeTotalPassageiros;

	@Column(length = 15, unique = true, nullable = false , name = "codRoleta")
	private String codigoRoleta;

	@Column(length = 30, nullable = false , name = "tipoChassi")
	private String tipoChassi;

	@Column(nullable = true, precision=10, scale=2 , name = "consumo_combustivel")
	private double consumoCombustivel;

	@Column(nullable = false , name = "validade_bateria")
	@Temporal(TemporalType.DATE)
	private Date dataValidadeBateria;
	
	@ManyToOne
	@JoinColumn(name = "usuario_idusuario")
	private Usuario usuario;

	@JoinColumn(name = "pneu_idpneu")
	@OneToOne(cascade = CascadeType.ALL, optional = true, orphanRemoval = true, fetch = FetchType.EAGER)
	private Pneu pneu;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;	
	}
	public Integer getNumeroOrdem() {
		return numeroOrdem;
	}
	public void setNumeroOrdem(Integer numeroOrdem) {
		this.numeroOrdem = numeroOrdem;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public Date getValidadeEmplacamento() {
		return validadeEmplacamento;
	}
	public void setValidadeEmplacamento(Date validadeEmplacamento) {
		this.validadeEmplacamento = validadeEmplacamento;
	}
	public String getTipoCarroceria() {
		return tipoCarroceria;
	}
	public void setTipoCarroceria(String tipoCarroceria) {
		this.tipoCarroceria = tipoCarroceria;
	}
	public Integer getCapacidadeTotalPassageiros() {
		return capacidadeTotalPassageiros;
	}
	public void setCapacidadeTotalPassageiros(Integer capacidadeTotalPassageiros) {
		this.capacidadeTotalPassageiros = capacidadeTotalPassageiros;
	}
	public String getCodigoRoleta() {
		return codigoRoleta;
	}
	public void setCodigoRoleta(String codigoRoleta) {
		this.codigoRoleta = codigoRoleta;
	}
	public String getTipoChassi() {
		return tipoChassi;
	}
	public void setTipoChassi(String tipoChassi) {
		this.tipoChassi = tipoChassi;
	}
	public double getConsumoCombustivel() {
		return consumoCombustivel;
	}
	public void setConsumoCombustivel(double consumoCombustivel) {
		this.consumoCombustivel = consumoCombustivel;
	}
	public Date getDataValidadeBateria() {
		return dataValidadeBateria;
	}
	public void setDataValidadeBateria(Date dataValidadeBateria) {
		this.dataValidadeBateria = dataValidadeBateria;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Pneu getPneu() {
		return pneu;
	}
	public void setPneu(Pneu pneu) {
		this.pneu = pneu;
	}
}
