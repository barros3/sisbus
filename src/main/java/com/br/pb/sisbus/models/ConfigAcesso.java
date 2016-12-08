package com.br.pb.sisbus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_config_acesso")
public class ConfigAcesso {

	@Id
	@Column(name="idConfigAcesso")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="controle_usuario")
	private Boolean controleUsuario;
	
	@Column(name = "controle_funcionario")
	private Boolean controleFuncionario;
	
	@Column(name = "acompanhamento_chamado")
	private Boolean acompanhamentoChamado;
	
	@Column(name = "controle_manutencao")
	private Boolean controleManutencao;
	
	@Column(name = "lista_usuario")
	private Boolean listaUsuario;
	
	@Column(name = "buscar_funcionario")
	private Boolean buscarFuncionario;
	
	@Column(name = "buscar_chamado")
	private Boolean buscarChamado;
	
	@Column(name = "configurar_acesso")
	private Boolean configurarAcesso;
	
	@Column(name = "configurar_escala")
	private Boolean configurarEscala;
	
	@Column(name = "gerenciar_escala")
	private Boolean gerenciarEscala;

	@Column(name = "acesso_total")
	private Boolean acessoTotal;

	@Column(name = "controle_veiculo")
	private Boolean controleVeiculo;
	
	@Column(name = "localizar_veiculo")
	private Boolean localizarVeiculo;
	
	@Column(name = "quadro_horario")
	private Boolean quadroHorario;
	
	@Column(name = "escalar_funcionario")
	private Boolean escalarFuncionario;

	@Column(name = "acesso_relatorios")
	private Boolean acessoRelatorios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getControleUsuario() {
		return controleUsuario;
	}

	public void setControleUsuario(Boolean controleUsuario) {
		this.controleUsuario = controleUsuario;
	}

	public Boolean getControleFuncionario() {
		return controleFuncionario;
	}

	public void setControleFuncionario(Boolean controleFuncionario) {
		this.controleFuncionario = controleFuncionario;
	}

	public Boolean getAcompanhamentoChamado() {
		return acompanhamentoChamado;
	}

	public void setAcompanhamentoChamado(Boolean acompanhamentoChamado) {
		this.acompanhamentoChamado = acompanhamentoChamado;
	}

	public Boolean getControleManutencao() {
		return controleManutencao;
	}

	public void setControleManutencao(Boolean controleManutencao) {
		this.controleManutencao = controleManutencao;
	}

	public Boolean getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(Boolean listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public Boolean getBuscarFuncionario() {
		return buscarFuncionario;
	}

	public void setBuscarFuncionario(Boolean buscarFuncionario) {
		this.buscarFuncionario = buscarFuncionario;
	}

	public Boolean getBuscarChamado() {
		return buscarChamado;
	}

	public void setBuscarChamado(Boolean buscarChamado) {
		this.buscarChamado = buscarChamado;
	}

	public Boolean getConfigurarAcesso() {
		return configurarAcesso;
	}

	public void setConfigurarAcesso(Boolean configurarAcesso) {
		this.configurarAcesso = configurarAcesso;
	}

	public Boolean getConfigurarEscala() {
		return configurarEscala;
	}

	public void setConfigurarEscala(Boolean configurarEscala) {
		this.configurarEscala = configurarEscala;
	}

	public Boolean getGerenciarEscala() {
		return gerenciarEscala;
	}

	public void setGerenciarEscala(Boolean gerenciarEscala) {
		this.gerenciarEscala = gerenciarEscala;
	}

	public Boolean getAcessoTotal() {
		return acessoTotal;
	}

	public void setAcessoTotal(Boolean acessoTotal) {
		this.acessoTotal = acessoTotal;
	}

	public Boolean getControleVeiculo() {
		return controleVeiculo;
	}

	public void setControleVeiculo(Boolean controleVeiculo) {
		this.controleVeiculo = controleVeiculo;
	}

	public Boolean getLocalizarVeiculo() {
		return localizarVeiculo;
	}

	public void setLocalizarVeiculo(Boolean localizarVeiculo) {
		this.localizarVeiculo = localizarVeiculo;
	}

	public Boolean getQuadroHorario() {
		return quadroHorario;
	}

	public void setQuadroHorario(Boolean quadroHorario) {
		this.quadroHorario = quadroHorario;
	}

	public Boolean getEscalarFuncionario() {
		return escalarFuncionario;
	}

	public void setEscalarFuncionario(Boolean escalarFuncionario) {
		this.escalarFuncionario = escalarFuncionario;
	}

	public Boolean getAcessoRelatorios() {
		return acessoRelatorios;
	}

	public void setAcessoRelatorios(Boolean acessoRelatorios) {
		this.acessoRelatorios = acessoRelatorios;
	}

}