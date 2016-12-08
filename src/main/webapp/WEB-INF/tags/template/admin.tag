<%@attribute name="extraScripts" fragment="true"%>
<%@attribute name="extraStyles" fragment="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SisBus</title>

<!-- bootstrap -->
<link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap.min.css'/>">
<%-- <link rel="stylesheet"
	href="<c:url value='/assets/css/bootstrap-theme.min.css'/>">  --%>

<!-- style -->
<%--  <link rel="stylesheet" href="<c:url value='/assets/css/index.css'/>"> --%>
<link rel="stylesheet" href="<c:url value='/assets/css/forms.css'/>">
<jsp:invoke fragment="extraStyles" />

<!-- NovoLayout -->

<!-- <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon"> -->
<!-- Material Design fonts -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<!-- Materialize -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/assets/newlayout/css/vendor/materialize/materialize.css'/>">
<!-- Personal CSS -->
<!-- Personal -->
<link rel="stylesheet"
	href="<c:url value='/assets/newlayout/css/custom.css'/>">
<link rel="stylesheet"
	href="<c:url value='/assets/newlayout/css/vendor/fonts.css'/>">

<!-- Modernizr -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>

<!-- jQuery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<!-- Materialize -->
<script
	src="<c:url value='/assets/newlayout/js/vendor/materialize/materialize.min.js'/>"></script>


</head>

<body>

	<!-- INICIO NAV (alterar pra include)-->

	<%-- <nav class="navbar navbar-default">
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
							
							<li><a href="<c:url value='/admin/funcionario/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Cadastrar</a></li>
							<li><a href="<c:url value='/admin/funcionario'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> Gerenciar Funcionarios</a></li>
									
							<li role="separator" class="divider"></li>
							
							<li><a href="<c:url value='/gestor/escala/form'/>"><span
									class="glyphicon glyphicon-plus-sign"></span> Cadastrar</a></li>
							<li><a href="<c:url value='/gestor/escala/'/>"><span
									class="glyphicon glyphicon-menu-hamburger"></span> Gerenciar Escala</a></li>				
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
	</nav> --%>

	<main class="page-fast-access full-height">
	
	<!-- MENU LATERAL -->
	<ul id="slide-out" class="side-nav fixed">
		<li class="navbar-fixed orange darken-1">
			<nav class="orange darken-1">
				<div class="nav-wrapper">
					<a href="#!" class="brand-logo center"><i class="icon-sisbus"></i></a>
					<ul class="right ">
						<!-- <li><a href="sass.html"><i class="material-icons left">input</i>SAIR</a></li> -->
					</ul>
				</div>
			</nav>
		</li>

		<ul class="collapsible sb-collapsible-menu" data-collapsible="accordion">

			<!-- ACESSO RÁPIDO -->
			<li><a href="<c:url value='/index'/>"
				class="collapsible-header active"> <i class="icon-fast"></i>Acesso rápido
			</a></li>
			
			<!-- DEPARTAMENTO PESSOAL -->
			<li>
				<div class="collapsible-header">
					<i class="icon-id-card-4"></i>Departamento pessoal
				</div>
				<div class="collapsible-body">
					<ul class="collapsible" data-collapsible="accordion">
						<li><a href="<c:url value='/admin_master/administrador/form'/>"
							class="collapsible-header">Novo Administrador</a></li>
							<li><a href="<c:url value='/admin_master/administrador'/>"
						class="collapsible-header">Gerenciar administradores</a></li>
						<li><a href="<c:url value='/admin/funcionario/form'/>"
							class="collapsible-header">Novo funcionário</a></li>
						<li><a href="<c:url value='/admin/funcionario'/>"
							class="collapsible-header">Gerenciar funcionários</a></li>
						<li><a href="<c:url value='/config_acesso/form'/>"
							class="collapsible-header">Configurar Acesso</a></li>
					</ul>
				</div>
			</li>
			
			<!-- PLANEJADOR DE FROTA -->
			<li>
				<div class="collapsible-header">
					<i class="icon-notepad-2"></i>Planejador de frota
				</div>
				<div class="collapsible-body">
					<ul class="collapsible" data-collapsible="accordion">
					
						<!-- USUÁRIOS -->
						<li>
							<div class="collapsible-header sub1">
								<i class="icon-user-4"></i>Usuário
							</div>
							<div class="collapsible-body">
							<ul class="collapsible" data-collapsible="accordion">
								<li><a href="<c:url value='/admin_master/usuario/form'/>"
									class="collapsible-header">Novo Usuario</a></li>
								<li><a href="<c:url value='/admin_master/usuario'/>"
							class="collapsible-header">Gerenciar usuários</a></li>
							</ul>
							</div>
						</li>
						
						<!-- ROTAS -->
						<li>
							<div class="collapsible-header sub1">
								<i class="icon-rota"></i>Rotas
							</div>
							<div class="collapsible-body">
							<ul class="collapsible" data-collapsible="accordion">
								<li><a href="<c:url value='/gestor/rota/form'/>"
									class="collapsible-header">Programar nova rota</a></li>
								<li><a href="<c:url value='/gestor/rota'/>"
									class="collapsible-header">Gerenciar rotas programadas</a></li>
							</ul>
							</div>
						</li>
				
						<!-- CHAMADOS -->
						<li>
							<div class="collapsible-header sub1">
								<i class="icon-smartphone-10"></i>Chamados
							</div>
							<div class="collapsible-body">
							<ul class="collapsible" data-collapsible="accordion">
								<li><a href="<c:url value='/gestor/chamado'/>"
									class="collapsible-header">Chamados realizados</a></li>
							</ul>
							</div>
						</li>
						
						<!-- ESCALAS -->
						<li>
						<div class="collapsible-header sub1">
							<i class="icon-calendar-1"></i>Escalas
						</div>
						<div class="collapsible-body">
							<ul class="collapsible" data-collapsible="accordion">
								<li><a href="<c:url value='/escala/form'/>"
									class="collapsible-header">Nova escala</a></li>
								<li><a href="<c:url value='/escala'/>"
									class="collapsible-header">Gerenciar escalas</a></li>
								<li><a href="<c:url value='/config_escala/form'/>"
									class="collapsible-header">Configuração de Escala</a></li>
								<li><a href="<c:url value='/config_escala'/>"
									class="collapsible-header">Gerenciar Configuração de Escala</a></li>
							</ul>
						</div>
						</li>
					</ul>
				</div>
			</li>
			
			<!-- VEÍCULOS -->
			<li>
				<div class="collapsible-header">
					<i class="icon-veiculo"></i>Veículos
				</div>
				<div class="collapsible-body">
					<ul class="collapsible" data-collapsible="accordion">
						<!-- <li><a href="<c:url value='/gestor/veiculo/form'/>"
							class="collapsible-header">Novo veículo</a></li>
						-->
						<li><a href="<c:url value='/gestor/veiculo'/>"
							class="collapsible-header">Gerenciar veículos</a></li>
					</ul>
				</div>
			</li>
	
			<!-- QUADRO DE HORÁRIOS	 -->
			<li>
				<div class="collapsible-header">
					<i class="icon-clock-1"></i>Quadro de horários
				</div>
				<div class="collapsible-body">
					<ul class="collapsible" data-collapsible="accordion">
						<!-- 						<li>
							<div class="collapsible-header">Novo chamado</div>
						</li> -->
						<li><a href="<c:url value='/config_quadro_horario'/>"
							class="collapsible-header">Gerenciar Quadro de Horário</a></li>
						<li><a href="<c:url value='/config_quadro_horario/form'/>"
							class="collapsible-header">Configuração de Quadro de Horário</a></li>
							<li><a href="<c:url value='/config_quadro_horario/gerado'/>"
							class="collapsible-header">Quadro de Horário Gerado</a></li>
					</ul>
				</div>
			</li>

		</ul>
	</ul>
	
	<!-- MENU TOPO -->
	<header>
		<div class="navbar-fixed">
			<nav class="main">
				<div class="nav-wrapper">
					<!-- <a href="#!" class="brand-logo">Logo</a> -->
					<a href="#" data-activates="slide-out" class="button-collapse"><i
						class="material-icons">menu</i></a>
					<div class="container-inline welcome-msg hide-on-small-only">
						<span>BEM VINDO, {{Nome do usuário}}.</span>
					</div>
					<ul class="right ">
						<li><a href="<c:url value='/login/logout'/>"
							class="sb-btn-sair"><i class="material-icons left">input</i>SAIR</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</header>

	<!-- CONTEUDO -->
	<div class="main-content">
		<div class="row">
			<div class="col s12">

				<!-- FINAL NAV -->
				<jsp:doBody />
			</div>
		</div>
	</div>

	</main>



	<script>
    	/* MENU MATERIAL */
        $('.collapsible').collapsible({
          accordion : false // A setting that changes the collapsible behavior to expandable instead of the default accordion style
        });
          $(".button-collapse").sideNav({
          menuWidth: 300 // Default is 240
        });
    
    </script>

	<script src="<c:url value='/assets/js/jquery-2.1.4.min.js'/>"></script>
	<jsp:invoke fragment="extraScripts" />

</body>
</html>