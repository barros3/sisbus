<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/template" prefix="template" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                        <a href="#!" class="breadcrumb">Chamados</a> 
                        <a href="#!" class="breadcrumb">Chamados realizados</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
  <div class="panel panel-primary" style='width: 100%; margin-left: auto ; margin-right: auto ; margin-top:0; margin-bottom:0;'>
	<div class="panel-heading">
		<h1 class="panel-title">Chamados Realizados</h1>
	</div>
		<div class="panel-body">
			<div class="form col-md-6 table-responsive">
				<form class="navbar-form navbar-left" servletRelativeAction="/gestor/chamado/search" method="GET">
					<div class="form-group">
					    <input type="text" class="form-control" name="status" id="status" placeholder="Pesquisar..."/>
					    <input type="submit" class="btn btn-success  green darken-1 btn-small" value="Buscar">
					</div>
				</form>
			</div>
          <table class="table">
          		  <thead>
	                  <tr>
	                  	<td><b>Código</b></td>
	                  	<td><b>Responsável</b></td>
	                  	<td><b>Data</b></td>
	                  	<td><b>Hora</b></td>
	                  	<td><b>Prioridade</b></td>
	                  	<td><b>Status</b></td>
	                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items='${paginatedList.currentList}' var='object'>         		
	                  <tr>
	                  	<td>${object.id}</td>
	                  	<td>${object.responsavel}</td>
	                  	<td><fmt:formatDate value="${object.dataChamado}" pattern="dd/MM/yyyy"/></td>
	                  	<td>${object.horaChamado}</td>
	                  	<td>
		                  	<c:if test="${object.prioridade == 'URGENTE'}"><b style="color: red; font-style: bold;">${object.prioridade}</b></c:if>
		                  	<c:if test="${object.prioridade == 'NORMAL'}">${object.prioridade}</c:if>
	                  	</td>
	                  	<td>
		                  	<c:if test="${object.status == 'ABERTO'}"><span class="label label-success">${object.status}</span></c:if>
		                  	<c:if test="${object.status == 'FECHADO'}"><span class="label label-danger">${object.status}</span></c:if>
	                  	</td>
	                  <td>
	                  <c:if test="${object.status == 'ABERTO'}">
	                  	<a href="<c:url value='/gestor/chamado'/>/${object.id}" class="btn btn-default btn-small  red darken-4"><span class="glyphicon glyphicon-pencil"> Fechar</span></a>
	                  </c:if>
	                    <a href="<c:url value='/gestor/chamado/remove'/>/${object.id}" class="btn btn-default btn-small  red accent-4"  onclick="return deletar()"><span class="glyphicon glyphicon-remove"></span></a>
	                   	<a href="<c:url value='/gestor/chamado/visualizar'/>/${object.id}" class="btn btn-default btn-small  blue darken-1"><span class="glyphicon glyphicon-eye-open"></span></a>
	                   	</td>
					  </tr>
                  </c:forEach>
                  </tbody>
          </table>
		  <template:paginationComponent paginatedList="${paginatedList}" page="${param.page}" action="/gestor/chamado" />
        </div>
    </div>
  </div>
</jsp:body>
</template:admin>
