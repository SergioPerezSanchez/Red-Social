<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Red Social</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body style="background-image:url(https://k60.kn3.net/taringa/3/6/E/E/A/9/luisdavid1256/F49.jpg);background-position: center center;
	background-repeat: no-repeat; background-size: cover;">
	<nav class="navbar navbar-inverse">
  		<div class="container-fluid">
    	<div class="navbar-header">
      		<a class="navbar-brand" href="#">RedSocial</a>
    	</div>
    	<ul class="nav navbar-nav">
      		<li class="active"><a href="index.jsp">Inicio</a></li>
      		<li><a href="register.jsp">Regístrate</a></li>
    	</ul>
  		</div>
	</nav>
	<div class="container">
		<h1 style="color:white;">Bienvenido a Red Social</h1>
		<p style="color:white;">Inicia sesión para entrar o si aún no tienes cuenta <a href="register.jsp"style="cursor: pointer;">¡Registrate!</a></p>
		<!--  Aqui añadir un form -->
		<div class="row">
		   <div class="col-md-12">
		      <input name="usuario" type="text" placeholder="Usuario" required/>
		   </div>
		</div>
		<div class="row">
		   <div class="col-md-12">
		      <input name="password" type="password" placeholder="Contraseña" required/>
		   </div>
		</div>
		<div class="row" style="margin-top:5px;">
		   <div class="col-md-12">
		      <button class="btn btn-primary">Entrar</button>
		   </div>
		</div>
	</div>
</body>
</html>