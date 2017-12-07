<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login | BusMax</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<link rel="shortcut icon" type="image/x-icon" href="resources/bus_logo.png" />
<style>

div.main{
  
height:calc(100vh);
width:100%;
}


* {
  box-sizing: border-box;
    margin:0px auto;

  
}

body {
   
    color: #606468;
  font: 'Open Sans', sans-serif;
  margin: 0;
}


.container {
  left: 50%;
  position: fixed;
  top: 50%;
  transform: translate(-50%, -50%);
}

.middle {
  display: flex;
  width: 600px;
}
</style>
</head>
<body background="resources/login_background.jpg">


            <div class="main">
    
    
    <div class="container">
<center>
<h1 align="center" style="color:white">Bienvenido a BusMax</h1>
<h2 align="center" style="color:white">Inicia sesión para conocer más acerca de empresas de buses en Lima.</h2><br></br>

<div class="middle">

      <div style="border-right:1px solid #fff;padding: 0px 22px;width: 59%;">

                        <form method='post'>
                       
<!--                              <div class="input-group"> -->
<!--        <span class="input-group-addon"><i class="fa fa-user"></i></span> -->

<!--         <input -->
<!--                                     type="text" class="form-control"   -->
<!--                                     placeholder="usuario" name="username" required="true"> -->
                                 
                       
<!--                                     </div> -->
<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="username"   placeholder="Ingresa tu usuario" required="true"/>
								</div>
                                    <br>
                <div class="input-group">
       <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                      <input
                                    type="password" name="password" class="form-control" 
                                    placeholder="Ingresa tu contraseña" required="true">	
                                    </div>
                            <br></br>
                            <button style="width: 100%; font-size:1.1em;" type="submit" class="btn btn-large btn btn-success btn-lg btn-block">Login</button><br>
                          <font style="font-size: 15px;" color="white">Nuevo usuario:</font> <a style="font-size: 15px;color:lightgreen" href="<%=request.getContextPath()%>/register">Registrarse</a>
                                    
                        </form>
                        <font color="red">${message}</font>
					 </div> <!-- end login -->
 <img src="resources/bus_logo.png" style="width: 150px; height: 150px"></img> 
 
      </div>
</center>
    </div>

</div>

        </body>
</html>