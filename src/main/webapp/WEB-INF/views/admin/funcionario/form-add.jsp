<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<link rel="stylesheet" href="<c:url value='/assets/css/bootstrap.mim.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>
<template:admin>
<div>
<!-- BREADCRUMB -->
    <div class="row">
        <div class="col s12">
            <nav class="nav-breadcrumb">
                <div class="nav-wrapper">
                    <div class="col s12">
                    	<a href="<c:url value='/index'/>" class="breadcrumb">Acesso rápido</a> 
                        <a href="#!" class="breadcrumb">Funcionários</a> 
                        <a href="#!" class="breadcrumb">Novo funcionário</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
<!-- <div class="panel panel-primary" style="max-width: 60%; margin: 0 auto" >
	<div class="panel-heading">
		<h1 class="panel-title">Cadastro de Funcionários</h1>
	</div> 
		<div class="panel-body">-->
		
		
      <form:form role="form" commandName="funcionario" servletRelativeAction="/admin/funcionario" method="POST" >
      	<%@include file="form-inputs.jsp" %>
            	
        <!-- <button type="submit" class="waves-effect waves-light btn btn-large">Cadastrar</button> -->
        
      </form:form>	
      
      
      
      
<!--     </div>
  </div> -->
  </div>
</template:admin>
