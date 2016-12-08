package com.br.pb.sisbus.models;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.br.pb.sisbus.converters.ConverterLocalTimeAttribute;

@Entity
@Table(name = "tb_escala")
public class Escala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 20, nullable = false)
	private String codigoVeiculo;

	@Column(length = 25, nullable = false)
	private String itinerario;
	
	@Column(nullable = false)
	@Convert(converter = ConverterLocalTimeAttribute.class)
	private LocalTime horaEntrada;

	@Column(nullable = true)
	private Integer matriculaFuncionario;

	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataEscala;
	
	@Column(nullable = true)
	private Boolean horaExtra;
	
	@Column(nullable = true)
	private Integer limiteHoraExtra;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_escala_has_usuario", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "idUsuario")) 
	private Set<Usuario> listUsuario;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "tb_escala_has_funcionario", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name="idFuncionario"))
	private Set<Funcionario> listFuncionario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodigoVeiculo() {
		return codigoVeiculo;
	}
	public void setCodigoVeiculo(String codigoVeiculo) {
		this.codigoVeiculo = codigoVeiculo;
	}
	public String getItinerario() {
		return itinerario;
	}
	public void setItinerario(String itinerario) {
		this.itinerario = itinerario;
	}
	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public Integer getMatriculaFuncionario() {
		return matriculaFuncionario;
	}
	public void setMatriculaFuncionario(Integer matriculaFuncionario) {
		this.matriculaFuncionario = matriculaFuncionario;
	}
	public Date getDataEscala() {
		return dataEscala;
	}
	public void setDataEscala(Date dataEscala) {
		this.dataEscala = dataEscala;
	}
	public Boolean getHoraExtra() {
		return horaExtra;
	}
	public void setHoraExtra(Boolean horaExtra) {
		this.horaExtra = horaExtra;
	}
	public Integer getLimiteHoraExtra() {
		return limiteHoraExtra;
	}
	public void setLimiteHoraExtra(Integer limiteHoraExtra) {
		this.limiteHoraExtra = limiteHoraExtra;
	}
	public Set<Usuario> getListUsuario() {
		return listUsuario;
	}
	public void setListUsuario(Set<Usuario> listUsuario) {
		this.listUsuario = listUsuario;
	}
	public Set<Funcionario> getListFuncionario() {
		return listFuncionario;
	}
	public void setListFuncionario(Set<Funcionario> listFuncionario) {
		this.listFuncionario = listFuncionario;
	}
	public Escala(){}
}