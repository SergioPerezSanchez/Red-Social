<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Red Social - Registro</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body>
	<nav class="navbar navbar-inverse">
  		<div class="container-fluid">
    	<div class="navbar-header">
      		<a class="navbar-brand" href="#">RedSocial</a>
    	</div>
    	<ul class="nav navbar-nav">
      		<li><a href="index.jsp">Inicio</a></li>
      		<li  class="active"><a href="register.jsp">Regístrate</a></li>
    	</ul>
  		</div>
	</nav>
	<div class="container">
		<h1>Regístrate en Red Social</h1>
		<p>Introduce tus datos personales a continuación</p>
		<!--  Aqui añadir un form -->
		<div class="row">
		   <div class="col-xs-12">
		      <input name="nombre" type="text" placeholder="Nombre" required/>
		   </div>
		</div>
		<div class="row">
		   <div class="col-xs-12">
		      <input name="usuario" type="text" placeholder="e-mail" required/>
		   </div>
		</div>
		<div class="row">
		   <div class="col-xs-12">
		      <input name="password" type="password" placeholder="Contraseña" required/>
		   </div>
		</div>
		<div style="margin-top:5px;">
			<p>Sube una imagen de perfil para que todos te conozcan
			<button style="margin-left:5px;" class="btn btn-primary">Subir imagen</button></p>
		</div>
		<div class="row" style="margin-top:30px;">
		   <div class="col-xs-12">
		      <button class="btn btn-success">Registrar</button>
		   </div>
		</div>
	</div>
	<footer>
		<p style="margin-top:50px">Si tienes cuenta en Red Social, <a href="index.jsp">inicia sesión</a></p>
	</footer>
</body>
</html>