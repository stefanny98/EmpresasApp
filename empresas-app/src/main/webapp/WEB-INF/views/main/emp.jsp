<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Empresas</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"></link>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</head>
<body background="../resources/login_background.jpg">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">TuEmpresa</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/main/home">Página Principal <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item  active">
        <a class="nav-link" href="#">Empresas</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/main/rutas">Rutas</a>
      </li>
      <li class="nav-item">
        <a class="nav-link " href="<%=request.getContextPath()%>/main/prd">Paraderos</a>
      </li>
    </ul>
  </div>
  </nav>
  <div class="jumbotron jumbotron-fluid" style="background: url('../resources/bg_empresas.jpg') no-repeat center right;  background-color: #ededed;">
 
  
  <div class="container">
    <h1 class="display-3" style="color:white;font-style: italic;">Empresas</h1>
    <p class="lead" style="color:white;font-style: italic;">Aquí podrá visualizar todas las empresas asociadas a TuEmpresa.</p>
  </div>
</div>
	<c:forEach var="emp" items="${empresas}">
			<div class="row justify-content-center">
			  <div class="card w-50">
			   <div class="card bg-light">
					<div class="card-block">
						<div class="card-body">
				      <h4 class="card-title">${emp.nombre}</h4>
				      <p class="card-text">${emp.descripcion}</p>
				      <a href="#" class="btn btn-primary">Detalle</a>
				       </div>
			  	   </div>
			   </div>
			  </div>
			</div>
			<br>
	</c:forEach>
					

			<font color="red">${message}</font>

</body>
</html>