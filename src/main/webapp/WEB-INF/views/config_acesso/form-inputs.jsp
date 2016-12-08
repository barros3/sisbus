<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.indigo-pink.min.css">
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>

<div class="row" style="margin-top: -20px">
    <div class="col s12 m12 l8">
        <div class="card grey lighten-5">
            <div class="card-content ">
                <span class="card-title">Configuração de Controle de Acesso</span>
                <div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="controleUsuario" id="controleUsuario" label="Controle Usuário"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="controleFuncionario" id="controleFuncionario" label="Controle Funcionário"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="acompanhamentoChamado" id="acompanhamentoChamado" label="Acompanhamento de Chamado"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="controleManutencao" id="controleManutencao" label="Controle de Manutenção"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="listaUsuario" id="listaUsuario" label="Listar Usuários"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="buscarFuncionario" id="buscarFuncionario" label="Buscar Funcionários"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="buscarChamado" id="buscarChamado" label="Buscar Chamado"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="configurarAcesso" id="configurarAcesso" label="Configurar Acesso"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="configurarEscala" id="configurarEscala" label="Configurar Escala"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="gerenciarEscala" id="gerenciarEscala" label="Gerenciar Escala"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="acessoTotal" id="acessoTotal" label="Acesso Total"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="controleVeiculo" id="controleVeiculo" label="Controle Veículo"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="localizarVeiculo" id="localizarVeiculo" label="Localizar Veículo"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="quadroHorario" id="quadroHorario" label="Quadro Horário"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="escalarFuncionario" id="escalarFuncionario" label="Escalar Funcionário"/>
					</div>
				</div>
				<div class="align-rows form-usual">
                    <div class="row">
						<form:checkbox path="acessoRelatorios" id="acessoRelatorios" label="Acesso à Relatórios"/>
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