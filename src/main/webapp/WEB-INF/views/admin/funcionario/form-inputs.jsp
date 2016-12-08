<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>

<script>
	function validarFuncao() {
		if (document.getElementById("funcao").value === "MOTORISTA") {
			document.getElementById("cnh").disabled = false
			document.getElementById("validadeCNH").disabled = false
			document.getElementById("outrosDocumentos").disabled = false
			document.getElementById("tipoOutrosDocumentos").disabled = false;
		} else {
			document.getElementById("cnh").disabled = true
			document.getElementById("validadeCNH").disabled = true
			document.getElementById("outrosDocumentos").disabled = true
			document.getElementById("tipoOutrosDocumentos").disabled = true;
		}
	}

	function validarExame() {
		if (document.getElementById("exameDeSaude").value === "SIM") {
			document.getElementById("dataValidadeExame").disabled = false;
		} else {
			document.getElementById("dataValidadeExame").disabled = true;
		}
	}
	
	function validarCasal(){
		if(document.getElementById("tipoEstadoCivil").value == "UNIAO_ESTAVEL" || document.getElementById("tipoEstadoCivil").value == "CASADO"){
			documento.getElementById("nomeConjugue").disabled = false;
		} else {
			document.getElementById("nomeConjugue").disabled = true;
		}
	}

	function limpa_formulário_cep() {
		//Limpa valores do formulário de cep.
		document.getElementById('rua').value = ("");
		document.getElementById('bairro').value = ("");
		document.getElementById('cidade').value = ("");
		document.getElementById('uf').value = ("");
	}

	function meu_callback(conteudo) {
		if (!("erro" in conteudo)) {
			//Atualiza os campos com os valores.
			document.getElementById('rua').value = (conteudo.logradouro);
			document.getElementById('bairro').value = (conteudo.bairro);
			document.getElementById('cidade').value = (conteudo.localidade);
			document.getElementById('uf').value = (conteudo.uf);
		} //end if.
		else {
			//CEP não Encontrado.
			limpa_formulário_cep();
			alert("CEP não encontrado.");
		}
	}

	function pesquisacep(valor) {

		//Nova variável "cep" somente com dígitos.
		var cep = valor.replace(/\D/g, '');

		//Verifica se campo cep possui valor informado.
		if (cep != "") {

			//Expressão regular para validar o CEP.
			var validacep = /^[0-9]{8}$/;

			//Valida o formato do CEP.
			if (validacep.test(cep)) {

				//Preenche os campos com "..." enquanto consulta webservice.
				document.getElementById('rua').value = "...";
				document.getElementById('bairro').value = "...";
				document.getElementById('cidade').value = "...";
				document.getElementById('uf').value = "...";

				//Cria um elemento javascript.
				var script = document.createElement('script');

				//Sincroniza com o callback.
				script.src = '//viacep.com.br/ws/' + cep
						+ '/json/?callback=meu_callback';

				//Insere script no documento e carrega o conteúdo.
				document.body.appendChild(script);

			} //end if.
			else {
				//cep é inválido.
				limpa_formulário_cep();
				alert("Formato de CEP inválido.");
			}
		} //end if.
		else {
			//cep sem valor, limpa formulário.
			limpa_formulário_cep();
		}
	};
</script>

<div class="row" style="margin-top: -20px">
    <div class="col s12 m12 l8">
        <div class="card grey lighten-5">
            <div class="card-content ">
                <span class="card-title">Cadastro de funcionário</span>
                <div class="align-rows form-usual">
                <div class="title-divisor">
                    <h6>Dados Pessoais</h6>
                </div>
                
                    <div class="row">
                        <div class="input-field col s12">
							<label for="nome">Nome<span style="color: red;"> *</span></label>
							<form:input path='nome' type='text' class="form-control" placeholder="Seu nome" required="required" pattern="([A-Za-z]).{0,60}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 60 caracteres"/>
							<form:errors path='nome' />
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
							<label for="matricula">Matricula<span style="color: red;"> *</span></label>
							<form:input path='matricula' type='number' min="1" step="1" class="form-control" placeholder="Ex: 201601001" required="required" />
							<form:errors path='matricula' />
                        </div>
                    <div class="row">
                        <div class="input-field col s6">
							<label for="cpf">CPF<span style="color: red;">*</span></label>
							<form:input path='cpf' type='text' class="form-control" placeholder="Ex: 111.111.111-11" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" title="Ex: 111.111.111-11" required="required" />
							<form:errors path='cpf' style="color: red;"/>
                        </div>
                    </div>
                    <div class="row">   
                        <div class="input-field col s6">
							<label for="rg">RG<span style="color: red;">*</span></label>
							<form:input path='rg' type='number' min="1" step="1" class="form-control" placeholder="Ex: 1234567" pattern=".{0,11}" title="Esse campo não pode ultrapassar mais de 11 dígitos" required="required" />
							<form:errors path='rg' />
                        </div>
                        <div class="input-field col s6">
							<label for="orgaoExpedicao">Orgão Expedição<span style="color: red;">*</span></label>
							<form:input path='orgaoExpedicao' type='text' class="form-control" placeholder="Ex: SSP/PB" title="Ex: SSP/PB" required="required" />
							<form:errors path='orgaoExpedicao' style="color: red;"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col s6">
							<label for="ufRg">Estado<span style="color: red;">*</span></label>
							<form:select required="required" path="ufRg" class="form-control" id="ufRg" style='width: 100%;'>
								<form:option value="" label="--"/>
						    	<form:options items="${value}" />
							</form:select>
							<form:errors path='ufNascimento' />
                        </div>
                        <div class="form-group col s6">
							<label for="dataEmissaoRg">Data Emissão</label>
							<form:input path='dataEmissaoRg' type="date" id="dataEmissaoRg" class="form-control" />
							<form:errors path='dataEmissaoRg' />
                        </div>
                    </div>
                     <div class="row">
                        <div class="form-group col s12">
							<label for="tipoSanguineo">Tipo Sanguineo</label>
							<form:select path="tipoSanguineo" class="form-control" style='width: 30%;'>
								<form:option value="" label="-- Selecione --"/>
						    	<form:options items="${value}" />
							</form:select>
							<form:errors path='tipoSanguineo' />
                        </div>
                    </div>                   
                    <div class="row">
                        <div class="input-field col s12">
							<label for="nomePai">Nome do Pai</label>
							<form:input path='nomePai' type='text' class="form-control" placeholder="Nome do pai" pattern="([A-Za-z]).{0,60}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 60 caracteres"/>
							<form:errors path='nomePai' />
                        </div>
                    </div>     
                    <div class="row">
                        <div class="input-field col s12">
							<label for="nomeMae">Nome da Mãe</label>
							<form:input path='nomeMae' type='text' class="form-control" placeholder="Nome da mãe" pattern="([A-Za-z]).{0,60}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 60 caracteres"/>
							<form:errors path='nomeMae' />
                        </div>
                    </div>                     
                    <div class="row">
                        <div class="form-group col s6">
							<label for="exameDeSaude">Exame de saúde<span style="color: red;">*</span></label>
							<form:select required="required" path="exameDeSaude" class="form-control" id="exameDeSaude" onChange="validarExame()" >
								<form:option value="" label="-- Selecione --"/>
						    	<form:options items="${value}" />
							</form:select>
							<form:errors path='exameDeSaude' />
                    	</div>
                        <div class="form-group col s6">
							<label for="dataValidadeExame">Validade do Exame</label>
							<form:input path='dataValidadeExame' disabled="true" type="date" id="dataValidadeExame" class="form-control" />
							<form:errors path='dataValidadeExame' />
                        </div>
                    </div> 
                     <div class="row">
                        <div class="form-group col s6">
							<label for="outrosDocumentos">Outros Documentos</label>
							<form:input path='outrosDocumentos' disabled="true" id="outrosDocumentos" type='text' class="form-control" pattern="([A-Za-z]).{0,20}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 20 caracteres"/>
							<form:errors path='outrosDocumentos' />
                        </div>
                        <div class="form-group col s6">
							<label for="tipoOutrosDocumentos">Tipo de Outros Documentos</label>
							<form:input path='tipoOutrosDocumentos' disabled="true" id="tipoOutrosDocumentos" type='text' class="form-control" pattern="([A-Za-z]).{0,10}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 10 caracteres"/>
							<form:errors path='tipoOutrosDocumentos' />
                        </div>
                    </div>   
                 	<div class="title-divisor">
	                    <h6>Dados Profissionais</h6>
	               	  </div>	
                    <div class="row">
                        <div class="input-field col s6">
							<label for="cargo">Cargo<span style="color: red;">*</span></label>
							<form:input path='cargo' type='text' class="form-control" placeholder="Ex: Cargo" title="Ex: Cargo" required="required" />
							<form:errors path='cargo' style="color: red;"/>
                        </div>
                        <div class="input-field col s6">
							<label for="ctps">CTPS<span style="color: red;">*</span></label>
							<form:input path='ctps' type='number' min="1" step="1" class="form-control" placeholder="Ex: 1234567" pattern=".{0,30}" title="Esse campo não pode ultrapassar mais de 30 dígitos" required="required" />
							<form:errors path='ctps' />
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
							<label for="serie">Série<span style="color: red;">*</span></label>
							<form:input path='serie' type='number' min="1" step="1" class="form-control" placeholder="Ex: 1234567" title="Ex: 1234567" required="required" />
							<form:errors path='serie' style="color: red;"/>
                        </div>
						<div class="form-group col s4">
							<label for="dataEmissaoCtps">Data de Emissão<span style="color: red;">*</span></label>
							<form:input path='dataEmissaoCtps' id="dataEmissaoCtps" type='date' class="form-control" />
							<form:errors path='dataEmissaoCtps' />
                        </div>
                        <div class="form-group col s2">
							<label for="ufCtps">UF<span style="color: red;">*</span></label>
							<form:select required="required" path="ufCtps" class="form-control" id="ufCtps" style='width: 100%;'>
								<form:option value="" label="-- Selecione --"/>
						    	<form:options items="${value}" />
						   	</form:select>
							<form:errors path='ufCtps' />
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
							<label for="numPis">Número do PIS<span style="color: red;">*</span></label>
							<form:input path='numPis' type='number' min="1" step="1" class="form-control" placeholder="Ex: 1234567" title="Ex: 1234567" required="required" />
							<form:errors path='numPis' style="color: red;"/>
                        </div>
                        <div class="input-field col s6">
							<label for="agencia">Agência<span style="color: red;">*</span></label>
							<form:input path='agencia' type='number' min="1" step="1" class="form-control" placeholder="Ex: 1234567" title="Esse campo não aceita Letras ou Caracteres..." required="required" />
							<form:errors path='agencia' />
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
							<label for="conta">Conta<span style="color: red;">*</span></label>
							<form:input path='conta' type='number' min="1" step="1" class="form-control" placeholder="Ex: 1234567" title="Ex: 1" required="required" />
							<form:errors path='conta' style="color: red;"/>
                        </div>
                        <div class="input-field col s6">
							<label for="digito">Dígito<span style="color: red;">*</span></label>
							<form:input path='digito' type='number' min="1" step="1" class="form-control" placeholder="Ex: 1" title="Esse campo não aceita Letras ou Caracteres..." required="required" />
							<form:errors path='digito' />
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
							<label for="cargaHorariaSemanal">Carga Horária Semanal<span style="color: red;">*</span></label>
							<form:input path='cargaHorariaSemanal' type='number' min="1" step="1" class="form-control" placeholder="Ex: 48" title="Ex: 48" required="required" />
							<form:errors path='cargaHorariaSemanal' style="color: red;"/>
                        </div>
                        <div class="form-group col s6">
							<label for="tipoEstadoCivil">Estado Civil<span style="color: red;">*</span></label>
							<form:select required="required" path="tipoEstadoCivil" class="form-control" id="tipoEstadoCivil" style='width: 100%;' onchange="validarCasal()">
								<form:option value="" label="-- Selecione --"/>
						    	<form:options items="${value}" />
						   	</form:select>
							<form:errors path='tipoEstadoCivil' />
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col s6">
							<label for="nomeConjugue">Nome do Cônjugue</label>
							<form:input path='nomeConjugue' disabled="true" id="nomeConjugue" type='text' class="form-control" pattern="([A-Za-z]).{0,30}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 30 caracteres"/>
							<form:errors path='nomeConjugue' />
                        </div>
                       <div class="form-group col s6">
							<label for="dataNascimento">Data Nascimento</label>
							<form:input path='dataNascimento' type="date" id="dataNascimento" class="form-control" />
							<form:errors path='dataNascimento' />
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
							<label for="naturalidade">Naturalidade</label>
							<form:input path='naturalidade' type='text' class="form-control" placeholder="Ex: Paraibano(a)" title="Ex: Paraibano(a)" required="required"/>
							<form:errors path='naturalidade' style="color: red;"/>
                        </div>
                        <div class="form-group col s6">
							<label for="ufNascimento">Estado</label>
							<form:select required="required" path="ufNascimento" class="form-control" id="ufNascimento" style='width: 100%;'>
								<form:option value="" label="--"/>
						    	<form:options items="${value}" />
							</form:select>
							<form:errors path='ufNascimento' />
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
							<label for="racaCor">Raça/Cor<span style="color: red;">*</span></label>
							<form:input path='racaCor' type='text' class="form-control" placeholder="Ex: Preto/Pardo" title="Ex: Preto/Pardo" required="required" />
							<form:errors path='racaCor' style="color: red;"/>
                        </div>
                        <div class="input-field col s6">
							<label for="reservista">Reservista</span></label>
							<form:input path='reservista' type='number' min="1" step="1" class="form-control" placeholder="Ex: 1234567" title="Ex: 1234567"/>
							<form:errors path='reservista' style="color: red;"/>
                        </div>
                    </div>  
                    <div class="row">
                        <div class="input-field col s6">
							<label for="serieReservista">Serie Reservista</label>
							<form:input path='serieReservista' type='text' class="form-control" placeholder="Ex: N/I" title="Ex: N/I"/>
							<form:errors path='serieReservista' style="color: red;"/>
                        </div>
                        <div class="input-field col s6">
							<label for="fatorRh">Fator RH<span style="color: red;">*</span></label>
							<form:input path='fatorRh' type='text' class="form-control" placeholder="Ex: '+' ou '-'" title="Ex: '+' ou '-'" required="required" />
							<form:errors path='fatorRh' style="color: red;"/>
                        </div>
                    </div> 
                    <div class="row">
                        <div class="input-field col s4">
							<label for="tituloEleitoral">Título Eleitoral<span style="color: red;">*</span></label>
							<form:input path='tituloEleitoral' type='number' min="1" step="1" class="form-control" placeholder="Ex: 1234 1234 1234 12" title="Ex: 1234 1234 1234 12" required="required" />
							<form:errors path='tituloEleitoral' style="color: red;"/>
                        </div>
                        <div class="input-field col s4">
							<label for="zona">Zona<span style="color: red;">*</span></label>
							<form:input path='zona' type='number' min="1" step="1" class="form-control" placeholder="Ex: 012" title="Ex: 012" required="required" />
							<form:errors path='zona' style="color: red;"/>
                        </div>
                        <div class="input-field col s4">
							<label for="secao">Seção<span style="color: red;">*</span></label>
							<form:input path='secao' type='number' min="1" step="1" class="form-control" placeholder="Ex: 0084" title="Ex: 0084" required="required" />
							<form:errors path='secao' style="color: red;"/>
                        </div>
                    </div>
                    <div class="row">  
                    	<div class="input-field col s4">
							<label for="telefone">Telefone<span style="color: red;">*</span></label>
							<form:input path='telefone' type='text' class="form-control" placeholder="Ex: (xx) 9000 - 00000" title="Ex: (xx) 9000 - 00000" required="required" />
							<form:errors path='telefone' style="color: red;"/>
                        </div>
                        <div class="input-field col s4">
							<label for="grauEscolaridade">Grau de Escolaridade<span style="color: red;">*</span></label>
							<form:input path='grauEscolaridade' type='text' class="form-control" placeholder="Ex: 2º Completo" title="Ex: 2º Completo" required="required" />
							<form:errors path='grauEscolaridade' style="color: red;"/>
                        </div>
                        <div class="input-field col s4">
							<label for="nascionalidade">Nascionalidade<span style="color: red;">*</span></label>
							<form:input path='nascionalidade' type='text' class="form-control" placeholder="Ex: Brasileiro" title="Ex: Brasilleiro" required="required" />
							<form:errors path='nascionalidade' style="color: red;"/>
                        </div>
                    </div>
                    <div class="row">
                     	<div class="form-group col s4">
							<label for="tipoCategoriaCnh">Categoria da Habilitação<span style="color: red;">*</span></label>
							<form:select path="tipoCategoriaCnh" class="form-control" id="tipoCategoriaCnh" style='width: 100%;'>
								<form:option value="" label="-- Selecione --"/>
						    	<form:options items="${value}" />
						   	</form:select>
							<form:errors path='tipoCategoriaCnh' />
                        </div>
                         <div class="input-field col s4">
							<form:checkbox path='deficienteFisico' class="form-control" required="required" label="Deficiente Físico ?"/>
							<form:errors path='deficienteFisico' style="color: red;"/>
                        </div>
                         <div class="input-field col s4">
							<form:checkbox path='dependentes' class="form-control" required="required" label="Dependentes ?" />
							<form:errors path='dependentes' style="color: red;"/>
                        </div>
                    </div>    
                    <div class="row">
                     	<div class="form-group col s4">
							<label for="funcao">Função<span style="color: red;">*</span></label>
							<form:select required="required" path="funcao" class="form-control" id="funcao" onChange="validarFuncao()" style='width: 100%;'>
								<form:option value="" label="-- Selecione --"/>
						    	<form:options items="${value}" />
						   	</form:select>
							<form:errors path='funcao' />
                        </div>
                        <div class="form-group col s4">
							<label for="cnh">CNH</label>
							<form:input path='cnh' disabled="true" id="cnh" type='number' min="1" step="1" class="form-control" placeholder="Ex: 1234567" pattern=".{9,11}" title="Esse campo deve conter no mínimo 9 e no máximo 11 números" />
							<form:errors path='cnh' />
                        </div>
                        <div class="form-group col s4">
							<label for="validadeCNH">Validade da CHN</label>
							<form:input path='validadeCNH' disabled="true" id="validadeCNH" type='date' class="form-control" />
							<form:errors path='validadeCNH' />
                        </div>
                    </div>                
                  <div class="title-divisor">
                    <h6>Endereço</h6>
               	  </div>
                    <div class="row">
                      <div class="input-field col s6">
							<label for="cep">CEP<span style="color: red;">*</span></label>
							<form:input path='endereco.cep' type='text' class="form-control" id="cep" size="10"
											maxlength="8" pattern="\d{8}" onblur="pesquisacep(this.value);" placeholder='58079530' required="required"  
												title="Esse campo não pode conter texto ou caracteres especiais, nem ultrapassar mais de 8 dígitos"/>
							<form:errors path='endereco.cep' />
                        </div>
                        <div class="form-group col s6">
							<label for="estado">Estado<span style="color: red;">*</span></label>
							<form:select required="required" path="endereco.estado" class="form-control" id="uf" style='width: 20%;'>
								<form:option value="" label="--"/>
						    	<form:options items="${value}" />
							</form:select>
							<form:errors path='endereco.estado' />
                        </div>
                    </div>     
                   <div class="row">
                        <div class="input-field col s12">
							<label for="rua">Rua<span style="color: red;">*</span></label>
							<form:input path='endereco.rua' type='text' class="form-control" id="rua" required="required" pattern="([A-Za-z]).{0,80}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 80 caracteres"/>
							<form:errors path='endereco.rua' />
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
							<label for="bairro">Bairro<span style="color: red;">*</span></label>
							<form:input path='endereco.bairro' type='text' class="form-control" id="bairro" required="required" pattern="([A-Za-z]).{0,80}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 80 caracteres"/>
							<form:errors path='endereco.bairro' />
                        </div>
                        <div class="input-field col s6">
							<label for="cidade">Cidade<span style="color: red;">*</span></label>
							<form:input path='endereco.cidade' type='text' class="form-control" id="cidade" required="required" pattern="([A-Za-z]).{0,80}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 80 caracteres"/>
							<form:errors path='endereco.cidade' />
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
							<label for="complemento">Complemento<span style="color: red;">*</span></label>
							<form:input path='endereco.complemento' type='text' class="form-control" id="complemento" pattern="([A-Za-z]).{0,80}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 80 caracteres"/>
							<form:errors path='endereco.complemento' />
                        </div>
                    </div>
                </div>
            </div>
            <div class="card-action">
                <button type="submit" href="#" class="btn btn-success  green darken-1 btn-large">Cadastrar</button>
                <a href="#" class="btn btn-default btn-large  blue-grey darken-1">Cancelar</a>
            </div>
        </div>
    </div>
</div>