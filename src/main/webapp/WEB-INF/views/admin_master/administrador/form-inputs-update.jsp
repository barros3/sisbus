<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>

<div class="form-group">
	<label for="nome">Nome<span style="color: red;">*</span></label>
	<form:input path='nome' type='text' class="form-control" placeholder="Seu nome" required="required" pattern="([A-Za-z]).{0,60}" title="Esse campo não pode conter números, caracteres especiais, nem ultrapassar mais de 60 caracteres"/>
	<form:errors path='nome' />
</div>
<div class="form-group">
	<label for="matricula">Matricula<span style="color: red;">*</span></label>
	<form:input path='matricula' type='number' class="form-control" min="0" step="1" placeholder="Ex: 401" required="required" />
	<form:errors path='matricula' />
</div>
<div class="form-group">
	<label for="cpf">CPF<span style="color: red;">*</span></label>
	<form:input path='cpf' type='text' class="form-control" placeholder="Ex: 111.111.111-11" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}" title="Ex: 111.111.111-11" required="required" />
	<form:errors path='cpf' />
</div>
<div class="form-group">
	<label for="email">E-mail<span style="color: red;">*</span></label>
	<form:input path='usuario.email' type='text' class="form-control" placeholder='Ex: exemplo@gmail.com' pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="exemplo@gmail.com" required="required" />
	<form:errors path='usuario.email' />
</div>