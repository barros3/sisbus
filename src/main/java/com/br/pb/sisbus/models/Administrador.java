package com.br.pb.sisbus.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_administrador")
public class Administrador {

	@Id
	@Column(name="idAdministrador")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true , name="matricula")
	private Integer matricula;
	
	@Column(length = 60, nullable = false , name="nome")
	private String nome;
	
	@Column(length = 14, nullable = false, unique = true , name="CPF")
	private String cpf;
	
	@JoinColumn(name = "usuario_idusuario")
	@OneToOne(cascade = CascadeType.ALL, optional = true, orphanRemoval = true, fetch = FetchType.EAGER)
	private Usuario usuario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getMatricula() {
		return matricula;
	}
	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}