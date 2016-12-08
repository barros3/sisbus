package com.br.pb.sisbus.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.br.pb.sisbus.enuns.Estados;
import com.br.pb.sisbus.enuns.ExameDeSaude;
import com.br.pb.sisbus.enuns.Funcao;
import com.br.pb.sisbus.enuns.TipoCategoriaCNH;
import com.br.pb.sisbus.enuns.TipoEstadoCivil;
import com.br.pb.sisbus.enuns.TipoSanguineo;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

	@Id
	@Column(name="idFuncionario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true, name = "matricula")
	private Integer matricula;

	@Column(length = 60, nullable = false , name = "nome")
	private String nome;

	@Column(length = 14, nullable = false, unique = true , name = "CPF")
	private String cpf;

	@Column(length = 15, nullable = true, unique = true , name = "RG")
	private String rg;

	@Column(length = 20, nullable = true , name = "tiposanguineo")
	@Enumerated(EnumType.STRING)
	private TipoSanguineo tipoSanguineo;

	@Column(length = 60, nullable = true , name = "nomepai")
	private String nomePai;

	@Column(length = 60, nullable = true , name = "nomemae")
	private String nomeMae;

	@Column(length = 3, nullable = false , name = "examesaude")
	@Enumerated(EnumType.STRING)
	private ExameDeSaude exameDeSaude;

	@Column(nullable = true , name = "validadeExame")
	@Temporal(TemporalType.DATE)
	private Date dataValidadeExame;

	@Column(length = 20, nullable = false , name = "funcao")
	@Enumerated(EnumType.STRING)
	private Funcao funcao;
	
	@Column(nullable = true, unique = true ,name = "CNH")
	private Integer cnh;

	@Column(nullable = true, name = "validadeCNH")
	@Temporal(TemporalType.DATE)
	private Date validadeCNH;

	@Column(length = 20, nullable = true , name = "outrosDocs")
	private String outrosDocumentos;

	@Column(length = 10, nullable = true , name = "tipoDoc")
	private String tipoOutrosDocumentos;
	
	@Column(length = 30, nullable = false , name = "cargo")
	private String cargo;
	
	@Column(nullable = false , name = "CTPS")
	private Integer ctps;
	
	@Column(nullable = false , name = "serie")
	private Integer serie;
	
	@Column(nullable = false , name = "data_emissao_ctps")
	@Temporal(TemporalType.DATE)
	private Date dataEmissaoCtps;
	
	@Column(length = 2, nullable = false , name = "uf_ctps")
	@Enumerated(EnumType.STRING)
	private Estados ufCtps;
	
	@Column(nullable = false , name = "PIS")
	private Integer numPis;
	
	@Column(nullable = false , name = "agencia")
	private Integer agencia;
	
	@Column(nullable = false , name = "conta")
	private Integer conta;
	
	@Column(nullable = false , name = "digito")
	private Integer digito;
	
	@Column(nullable = false , name = "cargaHorariaSemanal")
	private Integer cargaHorariaSemanal;
	
	@Column(nullable = false , name = "estado_civil")
	@Enumerated(EnumType.STRING)
	private TipoEstadoCivil tipoEstadoCivil;
	
	@Column(length = 30, nullable = true , name = "nome_conjugue")
	private String nomeConjugue;
	
	@Column(nullable = true , name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(length = 25, nullable = true , name = "naturalidade")
	private String naturalidade;
	
	@Column(length = 2, nullable = true , name = "uf_nascimento")
	@Enumerated(EnumType.STRING)
	private Estados ufNascimento;
	
	@Column(length = 8, nullable = false , name = "raca_cor")
	private String racaCor;
	
	@Column(length = 2, nullable = false , name = "uf_rg")
	@Enumerated(EnumType.STRING)
	private Estados ufRg;
	
	@Column(length = 3, nullable = false , name = "orgao_expedicao")
	private String orgaoExpedicao;
	
	@Column(nullable = false, name = "data_emissao_rg")
	@Temporal(TemporalType.DATE)
	private Date dataEmissaoRg;
	
	@Column(nullable = true , name = "reservista")
	private Integer reservista;
	
	@Column(length = 1, nullable = true , name = "serie_reservista")
	private String serieReservista;
	
	@Column(length = 8, nullable = false , name = "fator_rh")
	private String fatorRh;
	
	@Column(nullable = false , name = "titulo_eleitoral")
	private Integer tituloEleitoral;
	
	@Column(nullable = false , name = "zona")
	private Integer zona;
	
	@Column(nullable = false , name = "secao")
	private Integer secao;
	
	@Column(length = 15, nullable = false , name = "telefone")
	private String telefone;
	
	@Column(length = 25, nullable = false , name = "grau_escolaridade")
	private String grauEscolaridade;
	
	@Column(length = 20, nullable = false , name = "nascionalidade")
	private String nascionalidade;
	
	@Column(length = 3, nullable = true , name = "tipo_categoria_CNH")
	@Enumerated(EnumType.STRING)
	private TipoCategoriaCNH tipoCategoriaCnh;
	
	@Column(nullable = true , name = "deficiente_fisico")
	private Boolean deficienteFisico;
	
	@Column(nullable = true , name = "dependentes")
	private Boolean dependentes;
	
	@JoinColumn(name = "endereco_idendereco", updatable = true)
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, optional = true, fetch = FetchType.EAGER)
	private Endereco endereco;

	@JoinColumn(name = "usuario_idusuario")
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, optional = true, orphanRemoval = false, fetch = FetchType.EAGER)
	private Usuario usuario;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "listFuncionario")
	private Set<Escala> listEscala;
	
	@Transient
	private Role role;
	
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
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public TipoSanguineo getTipoSanguineo() {
		return tipoSanguineo;
	}
	public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public ExameDeSaude getExameDeSaude() {
		return exameDeSaude;
	}
	public void setExameDeSaude(ExameDeSaude exameDeSaude) {
		this.exameDeSaude = exameDeSaude;
	}
	public Date getDataValidadeExame() {
		return dataValidadeExame;
	}
	public void setDataValidadeExame(Date dataValidadeExame) {
		this.dataValidadeExame = dataValidadeExame;
	}
	public Funcao getFuncao() {
		return funcao;
	}
	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Integer getCnh() {
		return cnh;
	}
	public void setCnh(Integer cnh) {
		this.cnh = cnh;
	}
	public Date getValidadeCNH() {
		return validadeCNH;
	}
	public void setValidadeCNH(Date validadeCNH) {
		this.validadeCNH = validadeCNH;
	}
	public String getOutrosDocumentos() {
		return outrosDocumentos;
	}
	public void setOutrosDocumentos(String outrosDocumentos) {
		this.outrosDocumentos = outrosDocumentos;
	}
	public String getTipoOutrosDocumentos() {
		return tipoOutrosDocumentos;
	}
	public void setTipoOutrosDocumentos(String tipoOutrosDocumentos) {
		this.tipoOutrosDocumentos = tipoOutrosDocumentos;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Set<Escala> getListEscala() {
		return listEscala;
	}
	public void setListEscala(Set<Escala> listEscala) {
		this.listEscala = listEscala;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Role getRole() {
		return role;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public Integer getCtps() {
		return ctps;
	}
	public void setCtps(Integer ctps) {
		this.ctps = ctps;
	}
	public Integer getSerie() {
		return serie;
	}
	public void setSerie(Integer serie) {
		this.serie = serie;
	}
	public Date getDataEmissaoCtps() {
		return dataEmissaoCtps;
	}
	public void setDataEmissaoCtps(Date dataEmissaoCtps) {
		this.dataEmissaoCtps = dataEmissaoCtps;
	}
	public Estados getUfCtps() {
		return ufCtps;
	}
	public void setUfCtps(Estados ufCtps) {
		this.ufCtps = ufCtps;
	}
	public Integer getNumPis() {
		return numPis;
	}
	public void setNumPis(Integer numPis) {
		this.numPis = numPis;
	}
	public Integer getAgencia() {
		return agencia;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	public Integer getConta() {
		return conta;
	}
	public void setConta(Integer conta) {
		this.conta = conta;
	}
	public Integer getDigito() {
		return digito;
	}
	public void setDigito(Integer digito) {
		this.digito = digito;
	}
	public Integer getCargaHorariaSemanal() {
		return cargaHorariaSemanal;
	}
	public void setCargaHorariaSemanal(Integer cargaHorariaSemanal) {
		this.cargaHorariaSemanal = cargaHorariaSemanal;
	}
	public TipoEstadoCivil getTipoEstadoCivil() {
		return tipoEstadoCivil;
	}
	public void setTipoEstadoCivil(TipoEstadoCivil tipoEstadoCivil) {
		this.tipoEstadoCivil = tipoEstadoCivil;
	}
	public String getNomeConjugue() {
		return nomeConjugue;
	}
	public void setNomeConjugue(String nomeConjugue) {
		this.nomeConjugue = nomeConjugue;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public Estados getUfNascimento() {
		return ufNascimento;
	}
	public void setUfNascimento(Estados ufNascimento) {
		this.ufNascimento = ufNascimento;
	}
	public String getRacaCor() {
		return racaCor;
	}
	public void setRacaCor(String racaCor) {
		this.racaCor = racaCor;
	}
	public Estados getUfRg() {
		return ufRg;
	}
	public void setUfRg(Estados ufRg) {
		this.ufRg = ufRg;
	}
	public String getOrgaoExpedicao() {
		return orgaoExpedicao;
	}
	public void setOrgaoExpedicao(String orgaoExpedicao) {
		this.orgaoExpedicao = orgaoExpedicao;
	}
	public Date getDataEmissaoRg() {
		return dataEmissaoRg;
	}
	public void setDataEmissaoRg(Date dataEmissaoRg) {
		this.dataEmissaoRg = dataEmissaoRg;
	}
	public Integer getReservista() {
		return reservista;
	}
	public void setReservista(Integer reservista) {
		this.reservista = reservista;
	}
	public String getSerieReservista() {
		return serieReservista;
	}
	public void setSerieReservista(String serieReservista) {
		this.serieReservista = serieReservista;
	}
	public String getFatorRh() {
		return fatorRh;
	}
	public void setFatorRh(String fatorRh) {
		this.fatorRh = fatorRh;
	}
	public Integer getTituloEleitoral() {
		return tituloEleitoral;
	}
	public void setTituloEleitoral(Integer tituloEleitoral) {
		this.tituloEleitoral = tituloEleitoral;
	}
	public Integer getZona() {
		return zona;
	}
	public void setZona(Integer zona) {
		this.zona = zona;
	}
	public Integer getSecao() {
		return secao;
	}
	public void setSecao(Integer secao) {
		this.secao = secao;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getGrauEscolaridade() {
		return grauEscolaridade;
	}
	public void setGrauEscolaridade(String grauEscolaridade) {
		this.grauEscolaridade = grauEscolaridade;
	}
	public String getNascionalidade() {
		return nascionalidade;
	}
	public void setNascionalidade(String nascionalidade) {
		this.nascionalidade = nascionalidade;
	}
	public TipoCategoriaCNH getTipoCategoriaCnh() {
		return tipoCategoriaCnh;
	}
	public void setTipoCategoriaCnh(TipoCategoriaCNH tipoCategoriaCnh) {
		this.tipoCategoriaCnh = tipoCategoriaCnh;
	}
	public Boolean getDeficienteFisico() {
		return deficienteFisico;
	}
	public void setDeficienteFisico(Boolean deficienteFisico) {
		this.deficienteFisico = deficienteFisico;
	}
	public Boolean getDependentes() {
		return dependentes;
	}
	public void setDependentes(Boolean dependentes) {
		this.dependentes = dependentes;
	}
	public Funcionario(){}
	
}
