package com.br.pb.sisbus.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author root
 *
 */

@Entity
@Table(name = "tb_role")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
//	@JoinColumn(name="role_idrole", nullable = false)
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Set<Usuario> usuario;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public String setName(String name) {
		return this.name = name;
	}

	@Override
	public String getAuthority() {
		return name;
	}
		
	public Role(String name){
		this.name = name;
	}
	
	public Role(){
	}

}