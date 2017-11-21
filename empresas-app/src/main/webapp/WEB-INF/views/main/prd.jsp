<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Paraderos</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"></link>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700,300' rel='stylesheet' type='text/css'>
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="../resources/css/animate.css">

	<!-- Bootstrap  -->
	<link rel="stylesheet" href="../resources/css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="../resources/css/superfish.css">

	<link rel="stylesheet" href="../resources/css/style.css">
		
	<script src="../resources/js/jquery.min.js"></script>
	
	<script src="../resources/js/jquery.waypoints.min.js"></script>
	
	<script src="../resources/js/main.js"></script>

	<script src="../resources/js/modernizr-2.6.2.min.js"></script>
</head>
<body background="../resources/login_background.jpg">
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
							<li>
								<a href="<%=request.getContextPath()%>/main/home">P&aacute;gina principal</a>
							</li>
							<li >
								<a href="<%=request.getContextPath()%>/main/emp">Empresas</a>
							</li>
							<li >
								<a href="<%=request.getContextPath()%>/main/rutas">Rutas</a>
							</li >
							<li class="active">
							<a href="<%=request.getContextPath()%>/main/prd">Paraderos</a></li>
						</ul>
					</nav>
					</div>
				</div>
			</header>
			
		</div>
		

		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover text-center" style="background-image: url(../resources/bg_paradero.jpg);">
				<div class="desc animate-box">
					<h2>Paraderos</h2>
					<span>Busca los paraderos de tu bus favorito.</span>
				</div>
			</div>

		</div>
		<br>
<form:form method="post" action="/gestion/main/prd">
	<div class="row">
<div class="col-sm-4"></div>
 <div class="col-sm-2">

<form:select path="nombre" style="height:40px" class="form-control">
<form:options items="${nombres}" />
</form:select>
   </div>
    <div class="col-sm-2">  
    <input type="submit" value="Buscar" class="btn btn-success" />
	</div>
	
	 </div>
</form:form>
<br>
	<c:forEach var="prd" items="${paraderos}">
		<div class="card-group">
		<div class="col-sm-2"></div>
		 <div class="col-sm-4">
		  <div class="card ">
		    <div class="card-body" style="background-color: #248ecc">
		      <p class="card-text" style="color:white">${prd.empresa}</p>
		   
		  </div>
		</div>
		</div>
		 <div class="col-sm-4">
		<div class="card border-dark mb-3">
		  <div class="card-body"  style="background-color:#ffffff">
		 
		    <p class="card-text" style="color:black; padding-left:100px"> <img src="../resources/bus.jpg"></img> ${prd.nombre} </p>
		   </div>
		 </div>
		</div>
		 </div>
	</c:forEach>
					<br>
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
</body>
</html>