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
							<form:input path='matricula' type='number' min="1" step="1" class="form-control" placeholder="Ex: 401" required="required" />
							<form:errors path='matricula' />
                        </div>
                    <div class="row">
                        <div class="input-field col s6">
							<label for="cpf">CPF<span style="color: red;">*</span></label>
							<form:input path='cpf' type='text' class="form-control" placeholder="Ex: 111.111.111-11" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" title="Ex: 111.111.111-11" required="required" />
							<form:errors path='cpf' style="color: red;"/>
                        </div>
                        <div class="input-field col s6">
							<label for="rg">RG<span style="color: red;">*</span></label>
							<form:input path='rg' type='number' class="form-control" placeholder="Ex: 1234567" pattern=".{0,11}" title="Esse campo não pode ultrapassar mais de 11 dígitos" required="required" />
							<form:errors path='rg' />
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
                     	<div class="form-group col s12">
							<label for="funcao">Função<span style="color: red;">*</span></label>
							<form:select required="required" path="funcao" class="form-control" id="funcao" onChange="validarFuncao()" style='width: 30%;'>
								<form:option value="" label="-- Selecione --"/>
						    	<form:options items="${value}" />
						   	</form:select>
							<form:errors path='funcao' />
                        </div>
                    </div>  
                    <div class="row">
                        <div class="form-group col s6">
							<label for="cnh">CNH</label>
							<form:input path='cnh' disabled="true" id="cnh" type='number' min="1" step="1" class="form-control" placeholder="Ex: 1234567" pattern=".{9,11}" title="Esse campo deve conter no mínimo 9 e no máximo 11 números" />
							<form:errors path='cnh' />
                        </div>
                        <div class="form-group col s6">
							<label for="validadeCNH">Validade da CHN</label>
							<form:input path='validadeCNH' disabled="true" id="validadeCNH" type='date' class="form-control" />
							<form:errors path='validadeCNH' />
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
							<form:input path='endereco.bairro' type='text' class="form-control" id="bairro" required="required" pattern="([A-Za-z]).{0,40}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 15 caracteres"/>
							<form:errors path='endereco.bairro' />
                        </div>
                        <div class="input-field col s6">
							<label for="cidade">Cidade<span style="color: red;">*</span></label>
							<form:input path='endereco.cidade' type='text' class="form-control" id="cidade" required="required" pattern="([A-Za-z]).{0,40}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 25 caracteres"/>
							<form:errors path='endereco.cidade' />
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