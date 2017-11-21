<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
	<title>Bus ${empresa.nombre}</title>
	<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"></link>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<script src="http://maps.google.com/maps/api/js?key=AIzaSyBZF63j7z6AkTlh2jybSKGKX3SyblJiRTA&libraries=places" type="text/javascript"></script>
<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700,300' rel='stylesheet' type='text/css'>

	<!-- Animate.css -->
	<link rel="stylesheet" href="../../resources/css/animate.css">

	<!-- Bootstrap  -->
	<link rel="stylesheet" href="../../resources/css/bootstrap.css">
	<!-- Superfish -->
	<link rel="stylesheet" href="../../resources/css/superfish.css">

	<link rel="stylesheet" href="../../resources/css/style.css">
		
	<script src="../../resources/js/jquery.min.js"></script>
	
	<script src="../../resources/js/jquery.waypoints.min.js"></script>
	
	<script src="../../resources/js/main.js"></script>

	<script src="../../resources/js/modernizr-2.6.2.min.js"></script>
	

	</head>
	<body>
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
							<li  class="active">
								<a href="<%=request.getContextPath()%>/main/emp">Empresas</a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/main/rutas">Rutas</a>
							</li>
							<li><a href="<%=request.getContextPath()%>/main/prd">Paraderos</a></li>
						</ul>
					</nav>
					</div>
				</div>
			</header>
			
		</div>
		

		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover text-center" style="background-image: url(../../resources/img/bg_bus.jpg) ;">
				<div class="desc animate-box">
					<h2 style="font-weight:bold; padding-top:20px">${empresa.nombre}</h2>
				</div>
			</div>

		</div>
		<br>
		<div class="container">
					<div class="fh5co-project-inner row">
						<div class="col-md-3 animate-box">
							<h3 class="heading-section">Descripci&oacute;n</h3>
							<p>	${empresa.descripcion }</p>
							<div class="card bg-light" style="padding:10px">
							<div class="fh5co-grid animate-box" style="background-image: url(../../resources/img/${empresa.imagen});">
							
							</div>
							</div>
						</div>
						<div class="fh5co-text col-md-6 animate-box">
							 <div class="card bg-light" style="padding:20px">
							 <div class="animate-box">
								<div id="map" align="center" style="width:500px; height:400px; position:relative"></div>
								</div>
							 </div>
						</div>
						<div class="col-md-3 animate-box">
							<div class="card bg-light" style="padding:20px">
						
							  <ul class="list-group">
							   <li class="list-group-item active">Lista de paraderos</li>
							<br>
							<c:forEach var="prd" items="${paraderos}">
							         <li class="list-group-item" style="font-weight:bold">${prd.nombre}</li>
							        </c:forEach>
							</ul>
							</div>
							
						</div>
				</div>
</div>
</body>
<script type="text/javascript">

   
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 10,
      center: new google.maps.LatLng(-11.900638, -77.039856),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;
	var longitud = ${longitudes};
	var latitud = ${latitudes};
	var lista = ${listas};
	
    for (i = 0; i < longitud.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(longitud[i], latitud[i]),
        map: map
      });

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(lista[i]);
          infowindow.open(map, marker);
        }
      })(marker, i));
    }
  </script>
</html>