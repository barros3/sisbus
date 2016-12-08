<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>

<script>
		$("#horaEntradaString").setMask("29:59").keypress(function() {
		  var currentMask = $(this).data('mask').mask;
		  var newMask = $(this).val().match(/^2.*/) ? "23:59" : "29:59";
		  if (newMask != currentMask) {
		    $(this).setMask(newMask);
		  }
		});
</script>

<div class="form-group">
	<label for="codigoVeiculo">Código do Veículo<span style="color: red;">*</span></label>
	<form:input path='codigoVeiculo' type='text' class="form-control" placeholder="Ex: 123wEr3" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 20 caracteres"/>
	<form:errors path='codigoVeiculo' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="itinerario">Itinerário<span style="color: red;">*</span></label>
	<form:input path='itinerario' type='text' class="form-control" />
	<form:errors path='itinerario' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="horaEntradaString">Hora da entrada</label>
	<form:input path='horaEntradaString' id="horaEntrada" type='time' class="form-control" />
	<form:errors path='horaEntradaString' />
</div>
<div class="form-group">
	<label for="matriculaFuncionario">Matrícula do Funcionário<span style="color: red;">*</span></label>
	<form:input path='matriculaFuncionario' type='text' class="form-control" />
	<form:errors path='matriculaFuncionario' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="dataEscala">Data da Escala</label>
	<form:input path='dataEscala' id="dataEntrada" type='date' class="form-control" />
	<form:errors path='dataEscala' />
</div>