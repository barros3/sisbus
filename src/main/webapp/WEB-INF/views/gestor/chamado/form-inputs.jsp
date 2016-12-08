<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>

<div class="form-group">
	<label for="avaria">Avaria<span style="color: red;">*</span></label>
	<form:select required="required" path="avaria" class="form-control" style='width: 35%;' id="avaria" onChange="validarFuncao()">
		<form:option value="" label="-- Selecione --"/>
    	<form:options items="${value}" />
   	</form:select>
	<form:errors path='avaria' />
</div>
<div class="form-group">
	<label for="responsavel">Responsável<span style="color: red;">*</span></label>
	<form:input path='responsavel' type='text' class="form-control" maxlength="50" required="required" pattern="([A-Za-z]).{0,50}" title="Esse campo não pode conter números ou caracteres especiais"/>
	<form:errors path='responsavel' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="codigoVeiculo">Código do Veículo<span style="color: red;">*</span></label>
	<form:input path='codigoVeiculo' type='text' class="form-control" maxlength="15" placeholder="Ex: 4400" required="required" pattern=".{4,15}" title="Campo deve conter no mínimo 4 caracteres" />
	<form:errors path='codigoVeiculo' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="localizacao">Localização<span style="color: red;">*</span></label>
	<form:input path='localizacao' type='text' class="form-control" required="required" />
	<form:errors path='localizacao' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="referencia">Referência<span style="color: red;">*</span></label>
	<form:textarea row="10" cols="100" path='referencia' type='text' class="form-control" required="required" />
	<form:errors path='referencia' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="observacao">Observação<span style="color: red;">*</span></label>
	<form:textarea row="10" cols="100" path='observacao' type='text' class="form-control" required="required" />
	<form:errors path='observacao' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="prioridade">Prioridade<span style="color: red;">*</span></label>
	<form:select required="required" path="prioridade" class="form-control" style='width: 35%;' id="prioridade" >
		<form:option value="" label="-- Selecione --"/>
    	<form:options items="${value}" />
   	</form:select>
	<form:errors path='prioridade' />
</div>