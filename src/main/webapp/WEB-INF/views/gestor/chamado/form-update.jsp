<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js" ></script>
<!-- bootstrap -->
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.min.css'/>">
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap-theme.min.css'/>">
<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
<template:admin>
     <form:form role="form" cssClass="well" commandName="chamado" servletRelativeAction="/gestor/chamado/${chamado.id}" method="POST" >
    	<%@include file="form-inputs-update.jsp" %>
      </form:form>	
</template:admin>
