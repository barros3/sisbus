<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>

<div class="form-group">
	<label for="tipoIntervalo">Tipo de Intervalo<span style="color: red;">*</span></label>
	<form:select required="required" id="tipoIntervalo" path="tipoIntervalo" disabled="true" class="form-control" style='width: 30%;'>
		<form:option value="" label="-- Selecione --"/>
    	<form:options items="${value}"/>
	</form:select>
	<form:errors path='tipoIntervalo' />
</div>
<div class="form-group">
	<label for="tipoCargaHoraria">Tipo de Carga Horária<span style="color: red;">*</span></label>
	<form:select required="required" path="tipoCargaHoraria" class="form-control" style='width: 30%;'>
		<form:option value="" label="-- Selecione --"/>
    	<form:options items="${value}" />
	</form:select>
	<form:errors path='tipoCargaHoraria' />
</div>
<div class="form-group">
	<label for="tempoIntervalo">Tempo de Intervalo<span style="color: red;">*</span></label>
	<form:input path='tempoIntervalo' type='time' disabled="true" class="form-control" />
	<form:errors path='tempoIntervalo' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="cargaHorario">Carga horária<span style="color: red;">*</span></label>
	<form:input path='cargaHorario' type='number' class="form-control" placeholder="Ex: 9" required="required" min="6" max="10" step="1"/>
	<form:errors path='cargaHorario' cssStyle="color: red;"/>
</div>
<div class="form-group">
	<label for="intervaloCompleto">Intervalo<span style="color: red;">*</span></label>
	<form:input path='intervaloCompleto' type='text' class="form-control" placeholder="Exemplo: 14:00-16:00" required="required" />
	<form:errors path='intervaloCompleto' />
</div>
<div class="form-group">
	<label for="tempoParaIntervalo">Tempo para o Intervalo<span style="color: red;">*</span></label>
	<form:input path='tempoParaIntervalo' type='time' disabled="true" class="form-control" />
	<form:errors path='tempoParaIntervalo' cssStyle="color: red;"/>
</div>