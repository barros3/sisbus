package com.br.pb.sisbus.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.br.pb.sisbus.enuns.Estados;


@Entity
@Table(name="tb_endereco")
public class Endereco {

	@Id
	@Column(name="idendereco")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 80, nullable = false , name="rua")
	private String rua;
	
	@Column(length = 80, nullable = false , name="bairro")
	private String bairro;
	
	@Column(length = 80, nullable = false , name="complemento")
	private String complemento;
	
	@Column(length = 80, nullable = false , name="cidade")
	private String cidade;
	
	@Column(length = 2, nullable = false , name="estado")
	@Enumerated(EnumType.STRING)
	private Estados estado;

	@Column(length = 8, nullable = false, unique = true,  name="CEP")
	private String cep;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Funcionario.class, mappedBy = "endereco")
	private List<Funcionario> funcionario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}	
	public Estados getEstado() {
		return estado;
	}
	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public List<Funcionario> getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
}
