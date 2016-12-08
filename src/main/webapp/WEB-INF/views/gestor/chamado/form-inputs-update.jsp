<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>
<!-- bootstrap -->
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/>">
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap-theme.min.css'/>">
<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>

<script>
	$(function(){
	    $('#btn').click();
	});
</script>
<script type="text/javascript">
$(document).ready(function(){
    $(".show-modal").click(function(){
        $("#myModal").modal({
            backdrop: 'static',
            keyboard: false
        });
    });
});
</script>

<!-- MANTER VALORES -->
<form:input id="avaria" type='hidden' path="avaria" />
<form:input id="responsavel" path='responsavel' type="hidden" />
<form:input id="codigoVeiculo" path='codigoVeiculo' type="hidden" />
<form:input id="localizacao" path='localizacao' type="hidden" />
<form:input id="referencia" path="referencia" type="hidden"  />
<form:input id="observacao" path="observacao" type="hidden" />
<form:input id="prioridade" path="prioridade" type="hidden" />
<form:input id="dataChamado" path="dataChamado" type="hidden" />
<form:input id="horaChamado" path="horaChamado" type="hidden" />
<form:input id="data_fechamento" path="data_fechamento" type="hidden" />

<!-- MODAL -->
<input type="hidden" id="btn" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm" data-backdrop="static" data-keyboard="false" />
<div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
<div class="modal-dialog modal-sm" role="document">
<div class="modal-content" >
<div class="modal-title">
	<h5 >Fechamento de chamado</h5>
	<br/>
</div>

	<!-- FECHAR CHAMADO -->
	<div class="form-group">
		<label for="responsavel_fechamento" >Responsável<span style="color: red;">*</span></label>
		<form:input path='responsavel_fechamento' type='text' class="form-control" maxlength="50" required="required" pattern="([A-Za-z]).{0,50}" title="Esse campo não pode conter números ou caracteres especiais"/>
		<form:errors path='responsavel_fechamento' cssStyle="color: red;"/>
	</div>
	<div class="form-group">
		<label for="motivo_fechamento">Motivo<span style="color: red;">*</span></label>
		<form:textarea row="10" cols="100" path='motivo_fechamento' type='text' class="form-control" required="required" />
		<form:errors path='motivo_fechamento' cssStyle="color: red;"/>
	</div>
	<div class="form-group">
		<label for="status">Status<span style="color: red;">*</span></label>
		<form:select required="required" path="status" class="form-control" style='width: 55%;' id="status">
			<form:option value="" label="-- Selecione --"/>
	    	<form:options items="${value}" />
	   	</form:select>
		<form:errors path='status' />
	</div>
	
	<button type="submit" class="btn btn-primary"><span>Fechar chamado</span></button>
	<a href="<c:url value='/gestor/chamado'/>" class="btn btn-default" ><span>Voltar</span></a>
	
</div>
</div>
</div>

