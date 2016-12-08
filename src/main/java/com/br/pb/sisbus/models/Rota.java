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

import com.br.pb.sisbus.enuns.TipoPercurso;

@Entity
@Table(name="tb_rota")
public class Rota {
	
	@Id
	@Column(name="id_rota")
 	@GeneratedValue(strategy = GenerationType.AUTO)
 	private Long id;
	
	@Column (nullable = false, name = "tipo_percurso")
	private String tipoPercurso; 
	
 	/*
 	 * Rota Circular
 	 */
 	@Column (nullable = true , columnDefinition="TEXT", name="itinerario")
 	private String itinerario;
 	
	@Temporal (TemporalType.TIME)
 	@Column (nullable = true , name="tempopercuso")
 	private Date tempoPercurso;
 	
 	@Column (length=11, nullable = true, precision=10, scale=2 , name="quilometragem")
 	private double quilometragem;
 	
 	/*
 	 * Rota Ida/Volta
 	 */
 	@Column (nullable = true, name = "tragetoria_ida")
 	private String tragetoriaIda;

 	@Column (nullable = true, name = "tragetoria_volta")
 	private String tragetoriaVolta;
 	
 	@Temporal (TemporalType.TIME)
 	@Column (nullable = true, name = "tempo_ida")
 	private Date tempoIda;
 	
 	@Temporal (TemporalType.TIME)
 	@Column (nullable = true, name = "tempo_volta")
 	private Date tempoVolta;
 	
 	@Column(nullable = true, precision = 10, scale = 2, name = "quilometragem_ida")
 	private double quilometragemIda;
 	
 	@Column(nullable = true, precision = 10, scale = 2, name = "quilometragem_volta")
 	private double quilometragemVolta;
 	
 	@Column (nullable = true, name = "tempo_total")
 	@Temporal (TemporalType.TIME)
 	private Date tempoTotal;
 	
 	@ManyToOne
	@JoinColumn(name = "usuario_id")
 	private Usuario usuario;
 	
 	
 	public Long getId() {
 		return id;
 	}
 	public void setId(Long id) {
 		this.id = id;
 	}
	public String getTipoPercurso() {
		return tipoPercurso;
	}
	public void setTipoPercurso(String tipoPercurso) {
		this.tipoPercurso = tipoPercurso;
	}
	public String getItinerario() {
 		return itinerario;
 	}
 	public void setItinerario(String itinerario) {
 		this.itinerario = itinerario;
 	}
 	public Date getTempoPercurso() {
		return tempoPercurso;
	}
	public void setTempoPercurso(Date tempoPercurso) {
		this.tempoPercurso = tempoPercurso;
	}
 	public double getQuilometragem() {
		return quilometragem;
	}
	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}
	public String getTragetoriaIda() {
		return tragetoriaIda;
	}
	public void setTragetoriaIda(String tragetoriaIda) {
		this.tragetoriaIda = tragetoriaIda;
	}
	public String getTragetoriaVolta() {
		return tragetoriaVolta;
	}
	public void setTragetoriaVolta(String tragetoriaVolta) {
		this.tragetoriaVolta = tragetoriaVolta;
	}
	public Date getTempoIda() {
		return tempoIda;
	}
	public void setTempoIda(Date tempoIda) {
		this.tempoIda = tempoIda;
	}
	public Date getTempoVolta() {
		return tempoVolta;
	}
	public void setTempoVolta(Date tempoVolta) {
		this.tempoVolta = tempoVolta;
	}
	public double getQuilometragemIda() {
		return quilometragemIda;
	}
	public void setQuilometragemIda(double quilometragemIda) {
		this.quilometragemIda = quilometragemIda;
	}
	public double getQuilometragemVolta() {
		return quilometragemVolta;
	}
	public void setQuilometragemVolta(double quilometragemVolta) {
		this.quilometragemVolta = quilometragemVolta;
	}
	public Date getTempoTotal() {
		return tempoTotal;
	}
	public void setTempoTotal(Date tempoTotal) {
		this.tempoTotal = tempoTotal;
	}
	public Usuario getUsuario() {
		return usuario;
	}
 	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
