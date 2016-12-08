<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>
<template:admin>

 	<script>
		swal(
			  'Salvo',
			  'Cadastrado com sucesso!',
			  'success'
			)
	</script>
	
	<meta http-equiv="Refresh" content="1;url=/estagio/admin/funcionario"/>
 
</template:admin>
