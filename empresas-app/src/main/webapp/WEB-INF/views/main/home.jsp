<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> <!--<![endif]-->
	<head>
	<title>Pagina principal</title>
	<meta charset="utf-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"></link>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link href='https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,700,300' rel='stylesheet' type='text/css'>
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="../resources/css/animate.css">
	
	<link rel="stylesheet" href="../resources/css/bootstrap.css">

	<link rel="stylesheet" href="../resources/css/superfish.css">

	<link rel="stylesheet" href="../resources/css/style.css">
		
	<script src="../resources/js/jquery.min.js"></script>
	
	<script src="../resources/js/jquery.waypoints.min.js"></script>
	
	<script src="../resources/js/main.js"></script>

	<script src="../resources/js/modernizr-2.6.2.min.js"></script>
	

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
							<li class="active">
								<a href="<%=request.getContextPath()%>/main/home">P&aacute;gina principal</a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/main/emp">Empresas</a>
							</li>
							<li>
								<a href="<%=request.getContextPath()%>/main/rutas">Rutas</a>
							</li>
							<li><a href="<%=request.getContextPath()%>/main/prd">Paraderos</a></li>
							<li><a href="#"><i class="fa fa-sign-out" aria-hidden="true"></i></a></li>
						</ul>
					</nav>
					</div>
				</div>
			</header>
			
		</div>
		

		<div class="fh5co-hero">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover text-center" style="background-image: url(../resources/bg_home.jpg) ;">
				<div class="desc animate-box">
					<h2>Bienvenido a busmax</h2>
					<span>Encuentra rutas y paraderos de diferentes buses de Lima</span>
				</div>
			</div>

		</div>
		<!-- end:header-top -->
		<div id="fh5co-work-section">
			<div class="container">
				<div class="row">
					<div class="col-md-3 animate-box">
						<h3 class="heading-section">Informaci&oacute;n</h3>
						<p>BusMax te ofrece informaci&oacute;n de los buses m&aacute;s importantes de Lima. Dale un vistazo!</p>
					</div>
					<div class="col-md-9">
						<div class="row">
							<div class="col-md-4 col-sm-4">
								<div class="fh5co-grid animate-box" style="margin-bottom:20px;background-image: url(../resources/img/img_rapido.jpg);">
									<a class="image-popup text-center" href="#">
										<div class="prod-title">
											<h3>El Rapido S.A.</h3>
										</div>
									</a>
								</div>
							</div>
							<div class="col-md-8 col-sm-8">
								<div class="fh5co-grid animate-box" style="background-image: url(../resources/img/img_etsafrasa.jpg);">
									<a class="image-popup text-center" href="#">
										<div class="prod-title">
											<h3>Etsafrasa</h3>
										</div>
									</a>
								</div>
							</div>
							
							<div class="col-md-8 col-sm-8">
								<div class="fh5co-grid animate-box" style="background-image: url(../resources/img/img_santacruz.jpg);">
									<a class="image-popup text-center" href="#">
										<div class="prod-title">
											<h3>Santa Cruz S.A.</h3>
										</div>
									</a>
								</div>
							</div>
							<div class="col-md-4 col-sm-4">
								<div class="fh5co-grid animate-box" style="background-image: url(../resources/img/img_etuchisa.jpg);">
									<a class="image-popup text-center" href="#">
										<div class="prod-title">
											<h3>Etuchisa</h3>
										</div>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- fh5co-work-section -->
		<div id="fh5co-services-section" class="border-bottom">
			<div class="container">
				<div class="row">
					<div class="col-md-3 animate-box">
						<h3 class="heading-section">Servicios</h3>
						<p>&iquest;Qu&eacute; ofrecemos?</p>
					</div>
					<div class="col-md-9 col-sm-12">
						<div class="row">
							<div class="col-md-4 col-sm-4">
								<div class="services animate-box">
									<span><i class="fa fa-list-alt" aria-hidden="true"></i></span>
									<h3>Informaci&oacute;n actualizada</h3>
									<p>Ofrecemos informaci&oacute;n actualizada de rutas y paraderos de buses en Lima. </p>
								</div>
							</div>
							<div class="col-md-4 col-sm-4">
								<div class="services animate-box">
									<span><i class="fa fa-mobile-phone"></i></span>
									<h3>Aplicaci&oacute;n m&oacute;vil</h3>
									<p>Desc&aacute;rgate la aplicaci&oacute;n en m&oacute;vil <a href="#">aqu&iacute;.</a></p>
								</div>
							</div> 
							<div class="col-md-4 col-sm-4">
								<div class="services animate-box">
									<span><i class="fa fa-map-marker"></i></span>
									<h3>Google Maps</h3>
									<p>Encuentra f&aacute;cilmente la ubicaci&oacute;n de paraderos en los mapas integrados.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
		<div id="fh5co-blog-section">
			<div class="container">
				<div class="row">
					<div class="col-lg-3 col-sm-12 animate-box">
						<h3 class="heading-section">Nuevos Buses</h3>
						<p>Mira las nuevas empresas que se integraron a BusMax.</p>
					</div>
					<div class="col-lg-9 col-sm-12">
						<div class="row">
							<div class="col-lg-4 col-md-4">
								<div class="fh5co-blog animate-box" style="background-image: url(../resources/bg_empresas.jpg);">
									<a class="image-popup" href="#">
										<div class="prod-title">
											<span>San Luis S.A.</span>
											</div>
									</a> 
								</div>
							</div>
							<div class="col-lg-4 col-md-4">
								<div class="fh5co-blog animate-box" style="background-image: url(../resources/bg_empresas.jpg);">
									<a class="image-popup" href="#">
										<div class="prod-title">
											<span>America S.A.</span>
											</div>
									</a> 
								</div>
							</div>
							<div class="col-lg-4 col-md-4">
								<div class="fh5co-blog animate-box" style="background-image: url(../resources/bg_empresas.jpg);">
									<a class="image-popup" href="#">
										<div class="prod-title">
											<span>Etulsa</span>
											</div>
									</a>
								</div>
							</div>
						</div>
					</div>
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

