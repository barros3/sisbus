<%@attribute name="extraScripts" fragment="true"%>
<%@attribute name="extraStyles" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SisBus</title>

<!-- bootstrap -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap-theme.min.css'/>">

<!-- style -->
<link rel="stylesheet" href="<c:url value='/assets/css/index.css'/>">
<link rel="stylesheet" href="<c:url value='/assets/css/forms.css'/>">
<jsp:invoke fragment="extraStyles" />
</head>

<body>

	<!-- INICIO NAV (alterar pra include)-->

	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">

				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#menu" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/estagio/index">SisBus</a>
			</div>

			<div class="collapse navbar-collapse" id="menu">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Administrador<span class="caret"></span></a>
						<ul class="dropdown-menu">
							
							<li>
								<a href="<c:url value='/admin_master/administrador/form'/>"><span
								class="glyphicon glyphicon-plus-sign"></span> Cadastrar Novo Administrador</a>
							</li>
							
							<!--  
								<li role="separator" class="divider"></li>
			
								<li><a href="<c:url value='/usuario/form'/>"><span
										class="glyphicon glyphicon-plus-sign"></span> Cadastrar Usuario</a></li>
								<li><a href="<c:url value='/usuario'/>"> <span
										class="glyphicon glyphicon-menu-hamburger"></span> Listar Usuario
								</a></li>
							-->

							
							<li role="separator" class="divider"></li>
							
							<li><a href="<c:url value='/login/logout'/>"><span
									class=" glyphicon glyphicon-log-in"></span> Sair</a></li>
						</ul></li>
						
					
						<!-- NAV DE GERENCIAMENTO DE FUNCIONÁRIOS -->
						
						<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Gestão de Funcionario<span class="caret"></span></a>
						<ul class="dropdown-menu">

							<li><a href="<c:url value='/admin/funcionario/form'/>">
									<span class="glyphicon glyphicon-plus-sign"></span> Cadastrar
							</a></li>
							<li><a href="<c:url value='/admin/funcionario'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> Gerenciar
									Funcionarios</a></li>

							<li role="separator" class="divider"></li>

							<li><a href="<c:url value='/gestor/escala/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Cadastrar</a></li>
							<li><a href="<c:url value='/gestor/escala/'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> Gerenciar
									Escala</a></li>
						</ul></li>
						
						
						<!-- NAV DE GERENCIAMENTO DE VEÍCULOS -->		
									
						<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Gestão de Veículos<span class="caret"></span></a>
							<ul class="dropdown-menu">
						
								<li><a href="<c:url value='/gestor/veiculo/form'/>"><span
								class="glyphicon glyphicon-plus-sign"></span> Cadastrar</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="<c:url value='/gestor/veiculo'/>"><span
								class="glyphicon glyphicon-menu-hamburger"></span> Gerenciar Veículos</a></li>
					
						</ul></li>
						
						
						<!-- NAV DE GERENCIAMENTO DE ROTAS  -->		
									
						<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Gestão de Rotas<span class="caret"></span></a>
							<ul class="dropdown-menu">
						
								<li><a href="<c:url value='/gestor/rota/form'/>"><span
								class="glyphicon glyphicon-plus-sign"></span> Cadastrar</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="<c:url value='/gestor/rota'/>"><span
								class="glyphicon glyphicon-menu-hamburger"></span> Gerenciar Rotas</a></li>
					
						</ul></li>
						
					
						<!-- NAV DE GERENCIAMENTO DE CHAMADOS -->	
					
						<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Gestão de Chamados<span class="caret"></span></a>
							<ul class="dropdown-menu">
						
							<li><a href="<c:url value='/gestor/chamado'/>"><span
							class="glyphicon glyphicon-menu-hamburger"></span> Gerenciar Chamados</a></li>
					
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- FINAL NAV -->
	<jsp:doBody />

	<script src="<c:url value='/assets/js/jquery-2.1.4.min.js'/>"></script>
	<script src="<c:url value='/assets/js/bootstrap.min.js'/>"></script>
	<jsp:invoke fragment="extraScripts" />

</body>
</html>