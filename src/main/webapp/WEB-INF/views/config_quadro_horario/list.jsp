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
				    'Exclu�do!',
				    'Exclu�do com sucesso',
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
                    	<a href="<c:url value='/index'/>" class="breadcrumb">Acesso r�pido</a> 
                        <a href="#!" class="breadcrumb">Configura��o de quadro de hor�rio</a> 
                        <a href="#!" class="breadcrumb">Gerenciar quadro de hor�rio</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
  <div class="panel panel-primary" style='width: 100%; margin-left: auto ; margin-right: auto ; margin-top:0; margin-bottom:0;'>
	<div class="panel-heading">
		<h1 class="panel-title">Configura��o de Quadro de Horario</h1>
	</div>
	<div class="panel-body">
         <table class="table">
         		  <thead>
                  <tr>
                  	<td><strong>Tipo de Intervalo</strong></td>
                  	<td><strong>Tipo Carga Hor�ria</strong></td>
                  	<td><strong>Tempo de Intervalo</strong></td>
                  	<td><strong>Intervalo</strong></td>
                  	<td><strong>Tempo para Intervalo</strong></td>
                  	<td><strong>Carga Hor�ria</strong></td>
                  </tr>
                 </thead>
                 <tbody>
                 <c:forEach items='${paginatedList.currentList}' var='object'>         		
                  <tr>
                  	<td>${object.tipoIntervalo}</td>
                  	<td>${object.tipoCargaHoraria.item}</td>
                  	<td>${object.tempoIntervalo} Horas</td>
                  	<td>${object.intervalo}</td>
                  	<td>${object.tempoParaIntervalo} Horas</td>
                  	<td>${object.cargaHoraria} Horas</td>
                  <td>
                    <a href="<c:url value='/config_quadro_horario/remove'/>/${object.id}" class="btn btn-danger"  onclick="return deletar()"><span class="glyphicon glyphicon-remove"></span></a>
                    <a href="<c:url value='/config_quadro_horario'/>/${object.id}" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
				  </tr>
                 </c:forEach>
                 </tbody>
         </table>
	  <template:paginationComponent paginatedList="${paginatedList}" page="${param.page}" action="/config_quadro_horario" />
         <a href="<c:url value='/config_quadro_horario/form'/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign"></span> Novo</a>
       </div>
    </div>
  </div>
</jsp:body>
</template:admin>