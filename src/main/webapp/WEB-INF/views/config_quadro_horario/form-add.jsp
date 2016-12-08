<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>
<template:admin>
<div class="row">
        <div class="col s12">
            <nav class="nav-breadcrumb">
                <div class="nav-wrapper">
                    <div class="col s12">
                    	<a href="<c:url value='/index'/>" class="breadcrumb">Acesso rápido</a> 
                        <a href="#!" class="breadcrumb">Configuração de quadro de horário</a> 
                        <a href="#!" class="breadcrumb">Novo quadro de horário</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
<div>
<div class="panel panel-primary" style='width: 40%; margin-left: auto ; margin-right: auto ; margin-top:0; margin-bottom:0;'>
	<div class="panel-heading">
		<h1 class="panel-title">Configuração de Quadro de Horário</h1>
	</div>
		<div class="panel-body">
      <form:form role="form" cssClass="well" commandName="configquadrohorario" modelAttribute="configQuadroHorario" servletRelativeAction="/config_quadro_horario" method="POST" >
      	<%@include file="form-inputs.jsp" %>
      	
        <button type="submit" class="btn btn-info">Cadastrar</button>

      </form:form>	
    </div>
  </div>
  </div>
</template:admin>