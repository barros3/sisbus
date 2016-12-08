<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>


<h2 style='color: #000000'>Endereço(2/2)</h2>
<div class="form-group">
	<label for="rua">Rua<span style="color: red;">*</span></label>
		<form:input path='rua' type='text' class="form-control" required="required"/>
		<form:errors path='rua' />
</div>
<div class="form-group">
	<label for="bairro">Bairro<span style="color: red;">*</span></label>
		<form:input path='bairro' type='text' class="form-control" required="required"/>
		<form:errors path='bairro' />
</div>
<div class="form-group">
	<label for="cidade">Cidade<span style="color: red;">*</span></label>
		<form:input path='cidade' type='text' class="form-control" required="required"/>
		<form:errors path='cidade' />
</div>
<div class="form-group">
	<label for="estado">Estado<span style="color: red;">*</span></label>
	<form:select required="required" path="estado" class="form-control" style='width: 20%;'>
		<form:option value="" label="--"/>
    	<form:options items="${value}" />
	</form:select>
	<form:errors path='estado' />
</div>
<div class="form-group">
	<label for="cep">CEP<span style="color: red;">*</span></label>
		<form:input path='cep' type='number' class="form-control" placeholder='58079530' required="required" pattern=".{0,8}" title="Esse campo não pode conter texto ou caracteres especiais, nem ultrapassar mais de 8 dígitos"/>
		<form:errors path='cep' />
</div>
