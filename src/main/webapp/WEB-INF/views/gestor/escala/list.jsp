<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<template:admin>
	<jsp:attribute name="extraStyles">
<link rel="stylesheet" href="<c:url value='/assets/css/pagination/jqpagination.css'/>" />
</jsp:attribute>
	<jsp:attribute name="extraScripts">
<script src="<c:url value='/assets/js/jquery.jqpagination.js'/>"></script>
</jsp:attribute>
	<jsp:body>
	
<link rel="stylesheet" href="<c:url value='/assets/css/sweetalert2.css'/>" />
<script src="<c:url value='/assets/js/sweetalert2.js'/>"></script>
<script src="<c:url value='/assets/js/sweetalert2.min.js'/>"></script>
	<script>

			function deletar(){
				  swal(
				    'Excluído!',
				    'Excluído com sucesso',
				    'success'
				  )
			}
	</script>
  <div>
        <div class="row">
        <div class="col s12">
            <nav class="nav-breadcrumb">
                <div class="nav-wrapper">
                    <div class="col s12">
                    	<a href="<c:url value='/index'/>" class="breadcrumb">Acesso rápido</a> 
                        <a href="#!" class="breadcrumb">Escalas</a> 
                        <a href="#!" class="breadcrumb">Gerenciar escalas</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
  <div class="panel panel-primary" style='width: 60%; margin-left: auto ; margin-right: auto ; margin-top:0; margin-bottom:0;'>
	<div class="panel-heading">
		<h1 class="panel-title">Escalas</h1>
	</div>
	<div class="form col-md-12 table-responsive">
	<h1 style="font-style: italic;"> Realizar Pesquisa</h1>
		<c:if test="${errorAoListar != null}">
			<div class="alert alert-danger">
			    ${errorAoListar}
			</div>
		</c:if>
		<form:form class="navbar-form navbar-left" comandName="escala" role="search" servletRelativeAction="/gestor/escala/search" method="GET">
			<div class="form-group">
			    <input type="text" class="form-control" name="searchItinerario" placeholder="Itinerário"/>
			</div>
			<div class="form-group">
			    <input type="text" class="form-control" name="searchData" placeholder="Data"/>
			</div>
			<div class="form-group">
			    <input type="text" class="form-control" name="searchMatricula" placeholder="Matricula"/>
			</div>
			<button type="submit" class="btn btn-default">Buscar</button>
		</form:form>
	</div>
		<div class="panel-body">
          <table class="table">
          		  <thead>
	                  <tr>
	                  	<td><strong>Código do Veículo</strong></td>
	                  	<td><strong>Itinerário</strong></td>
	                  	<td><strong>Hora da Entrada</strong></td>
	                  	<td><strong>Matrícula do Funcionário</strong></td>
	                  	<td><strong>Data da Escala</strong></td>
	                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items='${paginatedList.currentList}' var='object'>         		
	                  <tr>
	                  	<td>${object.codigoVeiculo}</td>
	                  	<td>${object.itinerario}</td>
	                  	<td>${object.horaEntrada} Horas</td>
	                  	<td>${object.matriculaFuncionario}</td>
	                  	<td>${object.dataEscala}</td>
	                  	
	                  <td>
	                    <a href="<c:url value='/gestor/escala/remove'/>/${object.id}" class="btn btn-danger"  onclick="return deletar()"><span class="glyphicon glyphicon-remove"></span></a>
	                    <a href="<c:url value='/gestor/escala'/>/${object.id}" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>
	                    </td>
					  </tr>
                  </c:forEach>
                  </tbody>
          </table>
		  <template:paginationComponent paginatedList="${paginatedList}" page="${param.page}" action="/escala" />
          <a href="<c:url value='/gestor/escala/form'/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Novo</a>
        </div>
    </div>
  </div>
</jsp:body>
</template:admin>
