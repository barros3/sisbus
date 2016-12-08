<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
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
                        <a href="#!" class="breadcrumb">Usuários</a> 
                        <a href="#!" class="breadcrumb">Gerenciar usuários</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
<div class="panel panel-primary" style='width: 100%; margin-left: auto ; margin-right: auto ; margin-top:0; margin-bottom:0;'>
	<div class="panel-heading">
		<h1 class="panel-title">Usuários Cadastrados</h1>
	</div>
		<div class="panel-body">
          <table class="table">
          		  <thead>
	                  <tr>
	                  	<td><strong>Login</strong></td>
	                  	<td><strong>E-mail</strong></td>
	                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items='${paginatedList.currentList}' var='object'>         		
	                  <tr>
		            	<td>${object.login}</td>
		            	<td>${object.email}</td>
	                    <td>
		                    <a href="<c:url value='/admin_master/usuario/remove'/>/${object.id}" class="btn btn-danger"  onclick="return deletar()"><span class="glyphicon glyphicon-remove"></span></a>
		                    <a href="<c:url value='/admin_master/usuario'/>/${object.id}" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>
	                    </td>
					  </tr>
                  </c:forEach>
                  </tbody>
          </table>
		  <template:paginationComponent paginatedList="${paginatedList}" page="${param.page}" action="/admin_master/usuario" />
          <a href="<c:url value='/admin_master/usuario/form'/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Novo</a>
        </div>
    </div>
  </div>
</jsp:body>
</template:admin>
