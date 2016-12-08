package com.br.pb.sisbus.models;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import	org.springframework.security.core.GrantedAuthority;
import	org.springframework.security.core.userdetails.UserDetails;

/**
 * 
 * @author root
 *
 */

@Entity
@Table(name = "tb_usuario")
public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idUsuario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 20, nullable = false, unique = true)
	private String login;

	@Column(length = 64, nullable = false)
	private String senha;

	@Pattern(regexp = "[a-z_][a-z0-9._]+@.+\\.[a-z]")
	@Column(length = 80, nullable = false, unique = true)
	private String email;

	@JoinColumn(name="usuario_idusuario", nullable = false)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Role> roles;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Veiculo.class, mappedBy = "usuario")
	private List<Veiculo> listVeiculo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Rota.class, mappedBy = "usuario")
	private List<Rota> listRota;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "listUsuario")
	private Set<Escala> listEscala;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public List<Veiculo> getListVeiculo() {
		return listVeiculo;
	}
	public void setListVeiculo(List<Veiculo> listVeiculo) {
		this.listVeiculo = listVeiculo;
	}
	public List<Rota> getListRota() {
		return listRota;
	}
	public void setListRota(List<Rota> listRota) {
		this.listRota = listRota;
	}
	//	ESSES METODOS PODEM SER UTEIS PARA CONTROLAR: RENOVACAO DE SENHA, BLOQUEIO POR INATIVIDADE
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) roles;
	}
	@Override
	public String getPassword() {
		return senha;
	}
	@Override
	public String getUsername() {
		return login;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	public Set<Escala> getListEscala() {
		return listEscala;
	}
	public void setListEscala(Set<Escala> listEscala) {
		this.listEscala = listEscala;
	}
	public Usuario(){}
	
	public Usuario(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<GrantedAuthority> authorities, Long id) {
		this.login = username;	this.senha = password; this.id = id; 	
	}
	
}