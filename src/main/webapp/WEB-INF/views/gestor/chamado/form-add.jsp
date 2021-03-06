<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<template:admin>
	<div class="row">
        <div class="col s12">
            <nav class="nav-breadcrumb">
                <div class="nav-wrapper">
                    <div class="col s12">
                    	<a href="<c:url value='/index'/>" class="breadcrumb">Acesso r�pido</a> 
                        <a href="#!" class="breadcrumb">Chamados</a> 
                        <a href="#!" class="breadcrumb">Novo chamado</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
<div>
<div class="panel panel-primary" style='width: 60%; margin-left: auto ; margin-right: auto ; margin-top:0; margin-bottom:0;'>
	<div class="panel-heading">
		<h1 class="panel-title">Cadastro de Chamado</h1>
	</div>
		<div class="panel-body">
      <form:form role="form" cssClass="well" commandName="chamado" servletRelativeAction="/gestor/chamado" method="POST"  >
      	<%@include file="form-inputs.jsp" %>
      	
        <button type="submit" class="btn btn-info">Cadastrar</button>

      </form:form>	
    </div>
  </div>
  </div>
</template:admin>
