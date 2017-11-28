<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
	<title>Perfil</title>
	<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"></link>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700,300' rel='stylesheet' type='text/css'>
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="../../resources/css/animate.css">
	
	<link rel="stylesheet" href="../../resources/css/bootstrap.css">

	<link rel="stylesheet" href="../../resources/css/superfish.css">

	<link rel="stylesheet" href="../../resources/css/style.css">
		
	<script src="../../resources/js/jquery.min.js"></script>
	
	<script src="../../resources/js/jquery.waypoints.min.js"></script>
	
	<script src="../../resources/js/main.js"></script>
	
	<script src="../../resources/js/modernizr-2.6.2.min.js"></script>

	

	</head>
	<body>
		<div id="fh5co-wrapper">
		<div id="fh5co-page">
		<div id="fh5co-header">
			<!-- end:top -->
			<header id="fh5co-header-section">
				<div class="container">
					<div class="nav-header">
						<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
						<h1 id="fh5co-logo"><a href="<%=request.getContextPath()%>/main/home">BUSMax</a></h1>
						<!-- START #fh5co-menu-wrap -->
					<nav id="fh5co-menu-wrap" role="navigation">
						<ul class="sf-menu" id="fh5co-primary-menu">
							<li><a href="<%=request.getContextPath()%>/main/home">P&aacute;gina principal</a></li>
							<li><a href="<%=request.getContextPath()%>/main/emp">Empresas</a></li>
							<li><a href="<%=request.getContextPath()%>/main/rutas">Rutas</a></li>
							<li><a href="<%=request.getContextPath()%>/main/prd">Paraderos</a></li>
							<li class="active"><a href="<%=request.getContextPath()%>/main/perfil"><i class="fa fa-user" aria-hidden="true"></i></a></li>
							<li><a href="<%=request.getContextPath()%>/login"><i class="fa fa-sign-out" aria-hidden="true"></i></a></li>
						</ul>
					</nav>
					</div>
				</div>
			</header>
			
		</div>
		
		
		<div class="fh5co-hero">
		
			<div class="fh5co-overlay" style="height:300px"></div>
			<div class="fh5co-cover text-center" style="height:300px;background-image: url(../../resources/bg_user.jpg) ;">
				<div class="desc animate-box">
					<h2>Perfil de Usuario</h2>
				</div>
			</div>

		</div>
			<h3 align="center">Bienvenid@ !</h3>	
				<!-- Formulario / editar usuario -->
		<div class="container-fluid" >
		<div class="row-fluid">
			<div class="col-md-6">
				<h4 class="text-center">Editar Perfil</h4>
				<hr>
				<form:form method="post" servletRelativeAction="/main/perfil" modelAttribute="usuario">
					<form:hidden path="id" />
					
					<div class="form-group">
						<label for="username">Username: </label>
						<form:input path="username" class="form-control"/>
							
					</div>
					<div class="form-group">
						<label for="fullname">Nombre Completo: </label>
						<form:input path="fullname" class="form-control" />
					</div>
					
					<div class="form-group">
						<label for="email">Email: </label>
						<form:input path="email" class="form-control" />
					</div>
			
					<div class="form-group">
						<input type="submit" value="guardar" class="btn btn-success" />
					</div>
				</form:form>
				
				<font color="red">${message}</font>
			</div>
		</div>
	</div>		
		<footer>
			<div id="footer">
				<div class="container">
					<div class="row">
						<div class="col-md-6">
							<p>Copyright 2017. All Rights Reserved. 
						</div>
						<div class="col-md-6">
							<ul class="footer-menu">
								<li><a href="<%=request.getContextPath()%>/main/home">P&aacute;gina principal</a></li>
								<li><a href="<%=request.getContextPath()%>/main/emp">Empresas</a></li>
								<li><a href="<%=request.getContextPath()%>/main/rutas">Rutas</a></li>
								<li><a href="<%=request.getContextPath()%>/main/prd">Paraderos</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</footer>
	

	</div>
	

	</div>

	</body>
</html>

