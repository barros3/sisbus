<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/template" prefix="template"%>
<template:admin>
	<div class="row">
		<div class="col s12">
			<nav class="nav-breadcrumb">
				<div class="nav-wrapper">
					<div class="col s12">
						<a href="#!" class="breadcrumb">Acesso rápido</a>
					</div>
				</div>
			</nav>
		</div>
		<div class="col s12">

			<%@include file="cards/card-veiculos.jsp"%>
			<%@include file="cards/card-rotas.jsp"%>
			<%@include file="cards/card-funcionarios.jsp"%>
			<%@include file="cards/card-chamados.jsp"%>
			<%@include file="cards/card-quadro-horarios.jsp"%>
			<%@include file="cards/card-escalas.jsp"%>

		</div>
	</div>

</template:admin>