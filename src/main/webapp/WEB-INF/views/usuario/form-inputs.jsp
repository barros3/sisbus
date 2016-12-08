<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>

<div class="form-group">
	<label for="name">Login<span style="color: red;">*</span></label>
	<form:input path='login' type='text' class="form-control" placeholder="Exemplo!123" required="required" pattern=".{0,60}" title="Esse campo não pode ultrapassar mais de 60 caracteres"/>
	<form:errors path='login' />
</div>

<div class="form-group">
	<label for="email">Email<span style="color: red;">*</span></label>
	<form:input path='email' type='email' class="form-control" placeholder='Ex: exemplo@gmail.com' pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="exemplo@gmail.com" required="required" />
	<form:errors path='email' />
</div>

<div class="form-group">
	<label for="senha">Senha<span style="color: red;">*</span></label>
	<form:input path='senha' type='password' class="form-control" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="A senha deve conter no mínimo 8 caracteres e deve conter pelo menos um número, uma letra maiúscula e uma minúscula" placeholder='Ex: Abc!123' required="required" />
	<form:errors path='senha' />
</div>

<div class="form-group">
	<label for="tipo">Tipo<span style="color: red;">*</span></label>
	<form:select required="required" path="tipo" class="form-control" style='width: 40%;'>
    	<form:option value="" label="-- Selecione --"/>
    	<form:options items="${value}" />
	</form:select>
</div>