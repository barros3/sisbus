<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>

<script>

	$("#hora").setMask("29:59:59").keypress(function() {
	  var currentMask = $(this).data('mask').mask;
	  var newMask = $(this).val().match(/^2.*/) ? "23:59:59" : "29:59:59";
	  if (newMask != currentMask) {
	    $(this).setMask(newMask);
	  }
	});
	
	function validarBancoHoras(){
	    if (document.getElementById("bancoHora").checked === true) {
	        document.getElementById("limiteBancoHora").disabled = false
	        document.getElementById("excedente").disabled = false 
	    }else{
	    	document.getElementById("limiteBancoHora").disabled = true
	    	document.getElementById("excedente").disabled = true
	    }
	}
	
	function validarJornadaTrabalho(){
	    if (document.getElementById("jornadaTrabalho").value === "SERVICO") {
	        document.getElementById("quantidadeViagem").disabled = false 
	        document.getElementById("tempoMaxRepouso").disabled = false
	        document.getElementById("tipoRepouso").disabled = false
	        document.getElementById("repouso").disabled = false
	    }else{
	    	document.getElementById("quantidadeViagem").disabled = true
	    	document.getElementById("tempoMaxRepouso").disabled = true
	        document.getElementById("tipoRepouso").disabled = true;
	    	document.getElementById("tipoRepouso").disabled = true
	    	document.getElementById("repouso").disabled = true
	    }
	}
	
	function tempoRepouso(){
		var gozarRepouso = document.getElementById("repousoGozado").value;
		var repouso = document.getElementyById("repouso").value;
		
		$('#addRepousoGozado').click(function(){
		  gozarRepouso++;
		  repouso--;
		});
	}
</script>

<div class="form-group">
	<label for="jornadaTrabalho">Jornada de Trabalho<span style="color: red;">*</span></label>
	<form:select required="required" path="jornadaTrabalho" class="form-control" style='width: 30%;' id="jornadaTrabalho" onchange="validarJornadaTrabalho()">
		<form:option value="" label="-- Selecione --"/>
    	<form:options items="${value}" />
	</form:select>
	<form:errors path='jornadaTrabalho' />
</div>
<div class="form-group">
	<label for="cargaHorario">Carga horária<span style="color: red;">*</span></label>
	<form:input path='cargaHorario' type='number' class="form-control" placeholder="Ex: 9" required="required" min="6" max="10" step="1"/>
	<form:errors path='cargaHorario' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="bancoHora">Banco de horas</label>
	<form:checkbox path='bancoHora' id="bancoHora" class="form-control" onchange="validarBancoHoras()"/>
	<form:errors path='bancoHora' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="excedente">Excedente<span style="color: red;">*</span></label>
	<form:input path='excedente' type='time' disabled="true" class="form-control" />
	<form:errors path='excedente'  cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="limiteBancoHora">Limite de Banco de Horas<span style="color: red;">*</span></label>
	<form:input path='limiteBancoHora' type='number' disabled="true" class="form-control" placeholder="Ex: 12"/>
	<form:errors path='limiteBancoHora' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="quantidadeViagem">Quantidade Viagem<span style="color: red;">*</span></label>
	<form:input path='quantidadeViagem' id="quantidadeViagem" type='number' disabled="true" class="form-control" placeholder="Ex: 12"/>
	<form:errors path='quantidadeViagem' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="tipoRepouso">Tipo de Repouso<span style="color: red;">*</span></label>
	<form:select required="required" id="tipoRepouso" path="tipoRepouso" disabled="true" class="form-control" style='width: 30%;'>
		<form:option value="" label="-- Selecione --"/>
    	<form:options items="${value}"/>
	</form:select>
	<form:errors path='tipoRepouso' />
</div>
<div class="form-group">
	<label for="tempoMaxRepouso">Tempo Máximo de Repouso<span style="color: red;">*</span></label>
	<form:input path='tempoMaxRepouso' id="tempoMaxRepouso" type='time' disabled="true" class="form-control" />
	<form:errors path='tempoMaxRepouso' cssStyle="color: red;"/>
</div>