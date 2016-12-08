<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>

<div class="form-group">
	<label for="login">Login<span style="color: red;">*</span></label>
	<form:input path='login' type='text' class="form-control" placeholder="Exemplo!123" required="required" pattern=".{0,20}" title="Esse campo não pode ultrapassar mais de 20 caracteres"/>
	<form:errors path='login' />
</div>
<div class="form-group">
	<label for="email">E-mail<span style="color: red;">*</span></label>
	<form:input path='email' type='text' class="form-control" placeholder='Ex: exemplo@gmail.com' pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title="exemplo@gmail.com" required="required" />
	<form:errors path='email' />
</div>