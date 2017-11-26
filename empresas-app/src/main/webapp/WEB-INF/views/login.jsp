<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login | BusMax</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></link>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"></link>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>


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
  font: 87.5%/1.5em 'Open Sans', sans-serif;
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
<h2 align="center" style="color:white">Bienvenido a BusMax</h2>
<h3 align="center" style="color:white">Inicia sesión para conocer más acerca de empresas de buses en Lima.</h3><br></br>

<div class="middle">

      <div style="border-right:1px solid #fff;padding: 0px 22px;width: 59%;">

                        <form method='post'>
                       
                             <div class="input-group">
       <span class="input-group-addon"><i class="fa fa-user"></i></span>

        <input
                                    type="text" class="form-control"  
                                    placeholder="usuario" name="username" required="true">
                                 
                       
                                    </div>
                                    <br></br>
                <div class="input-group">
       <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                                      <input
                                    type="password" name="password" class="form-control" 
                                    placeholder="password" required="true">	
                                    </div>
                            <br></br>
                            <button style="width: 100%; font-size:1.1em;" type="submit" class="btn btn-large btn btn-success btn-lg btn-block">Login</button>
                          
                                    
                        </form>
                        
					 </div> <!-- end login -->
 <img src="resources/bus_logo.png" style="width: 150px; height: 150px"></img>
      </div>
</center>
    </div>

</div>

        </body>
</html>