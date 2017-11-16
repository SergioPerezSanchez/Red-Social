<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<script src="http://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="   crossorigin="anonymous"></script>
<script type="text/javascript" src="js/index.js"></script>
    <title>Red Social - Bienvenido</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<body >
	<%@ page import="modelo.Persona" %>
	<%
		HttpSession sesion = request.getSession();
		Persona p= (Persona)sesion.getAttribute("persona");
		if(p==null){
			response.sendRedirect("home");
		}
	%>
    <div id="navBar">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="init" id="liLogo" class="navbar-brand" >Intravita</a>
                </div>
                <ul class="nav navbar-nav">
                
                    <li id="liPublicacion" class="active"><a id="aPublicacion" >Publicaciones</a></li>
        
                    <li id="liAmistad" type="submit" value="Amigos" name="amigos"><a id="aAmistad" >Amigos</a></li>
                    <li id="liMP"><a id="aMP" >Gente</a></li>
                    <li id="liTodasPublicaciones"><a id="aTodasPublicaciones" >Todas Publicaciones</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li id="liPerfil"><a id="aPerfil" ><span class="glyphicon glyphicon-user"></span> Perfil</a></li>
                    <li id="liLogout"><a id="aLogout" href="http://localhost:8080/redSocial/"><span href="http://localhost:8080/redSocial/" class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </ul>
            </div>
        </nav>

    </div>
    <!--  PANEL BOTONES INVISIBLES ;D -->
    <div id="divBotonesInvisibles" style="display:none">
    	<form action="amigos" method="get">
            <button  id="holaAmigos" style="display:none; padding-bottom:10px; float: right;margin: auto;" class="btn btn-warning" type="submit" value="Amigos" name="amigos" >Volver</button>
        </form>
        
        <form action="gente" method="get">
            <button  id="holaGente" style="display:none; padding-bottom:10px; float: right;margin: auto;" class="btn btn-warning" type="submit" value="Gente" name="Gente" >Volver</button>
        </form>
    	<form action="menu" method="get">
            <button  id="holaMenu" style="display:none; padding-bottom:10px; float: right;margin: auto;" class="btn btn-warning" type="submit" value="Menu" name="menu" >Volver</button>
        </form>
        <form action="home.jsp" method="get">
            <button  id="holaLogo" style="display:none; padding-bottom:10px; float: right;margin: auto;" class="btn btn-warning" type="submit" value="Home" name="home" >Volver</button>
        </form>
        <form action="perfil" method="get">
            <button  id="holaPerfil" style="display:none; padding-bottom:10px; float: right;margin: auto;" class="btn btn-warning" type="submit" value="Perfil" name="perfil" >Volver</button>
        </form>
    	<form action="todasPublicaciones" method="get">
            <button  id="holatodasPublicaciones" style="display:none; padding-bottom:10px; float: right;margin: auto;" class="btn btn-warning" type="submit" value="TodasPublicaciones" name="todasPublicaciones" >Volver</button>
        </form>
    	<form action="menu" method="get">
            <button  id="holaMenu2" style="display:none; padding-bottom:10px; float: right;margin: auto;" class="btn btn-warning" type="submit" value="Menu" name="menu" >Volver</button>
        </form>
    </div>
    <style>
	.subencabezado {  /*nombre del estilo o botón*/
		border: 2px solid grey;  /*borde: estilo y color*/
		margin-top: 10px;
		font: normal normal 18px quicksand;  /*fuente*/
		color: black;  /*color de la fuente*/
		letter-spacing: 2px; /*separación entre las letras*/
		text-align: center; /*alineación del texto*/
		text-transform: uppercase; /*texto se transforma en mayúsculas*/
		padding: 6px;  /*tamaño del fondo*/
		border-radius: 30px 0px 30px 0px; /*ángulos de las 4 esquinas del borde/fondo*/
	}
	
	.mensaje{
		background: #ffffff ;
		border: 2px solid grey;
		font: normal normal 12px quicksand;  /*fuente*/
		color:#cccccc;  /*color de la fuente*/
		letter-spacing: 2px; /*separación entre las letras*/
		text-align: center; /*alineación del texto*/
		text-transform: uppercase; /*texto se tpersonaransforma en mayúsculas*/
		padding: 6px;  /*tamaño del fondo*/
		border-radius: 30px; /*forma la borde del fondo*/
	}
    </style>
    <!--  FIN PANEL BOTONES INVISIBLES ;D -->
    <div id="divPublicaciones" style="height: 100%;width:100%; margin-top:-20px; position:absolute;" class="col-lg-12 col-md-12 col-xs-12">
        <div class="subencabezado" style="width:100%" ">Publicaciones</div>
        <div id="publicacion" class="row-lg-3 row-md-3 row-xs-3">
  			<form action="publicarMensaje" method="post"> <input id="obtenerUsuario" style="display:none">
  			<input style="display:none" id="nombreUser" name="nombreUser" value="${persona.getNombre()}" disabled><input name="message" id="textareaPublicacion" style="margin-top: 20px; padding-bottom: 30px; width:75%">
  			<div style="float: right; margin-top: 15px" class="col-md-3 col-lg-3 col-xs-3"><button class="btn btn-lg btn-primary btn-block btn-success" id="btnPublicar" type="submit">Publicar</button></form>
  			<button id="btnAdjuntarFoto" class="btn btn-lg btn-primary btn-block btn-success" type="submit">Adjuntar Foto</button></div>
        </div>
        <hr style="border: 1px dotted #278e79; width:100%">
        <div id="panel" style="height: 80%; margin-top:15px;class="rog-lg-9 row-md-9 row-xs-9">
			<c:forEach var="listValue" items="${listPublicacionesPersona}">
				<div id="publicacion" class="mensaje" style="margin-top:10px;height:100px; width:100%" >
					<div id="mensaje" style="text-align: left" class="col-md-10 col-lg-10 col-xs-10"> ${listValue.getMensaje()}</div>
					<div id="perfil" style="font: 15px" class="col-lg-2 col-md-2 col-xs-2"><p>${listValue.getUsername()}}</p></div>
				</div>
			</c:forEach>
        </div>
        
    </div>
    <div id="divAmigos" style="background-image:url(https://3puntozeromktblog.files.wordpress.com/2015/03/estamos-trabajando-contenidos-web2.jpg);display: none; height: 590px; margin-top:-20px; position:absolute;border-style: solid;" class="col-lg-12 col-md-12 col-xs-12">
	

    </div>
    <div id="divMensajes" style="background-image:url(https://3puntozeromktblog.files.wordpress.com/2015/03/estamos-trabajando-contenidos-web2.jpg);display: none; height: 590px; margin-top:-20px; position:absolute;border-style: solid;" class="col-lg-12 col-md-12 col-xs-12">

    </div>
    <div id="divPerfil" style="display: none; height: 590px; margin-top:-20px; position:absolute;border-style: solid;" class="col-lg-12 col-md-12 col-xs-12">
    <style>
.card-container.card {
    max-width: 350px;
    padding: 40px 40px;
}

.btn {
    font-weight: 700;
    height: 36px;
    -moz-user-select: none;
    -webkit-user-select: none;
    user-select: none;
    cursor: default;
}

/*
 * Card component
 */
.card {
    background-color: #F7F7F7;
    /* just in case there no content*/
    padding: 20px 25px 30px;
    margin: 0 auto 25px;
    margin-top: 50px;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}

/*
 * Form styles
 */
.profile-name-card {
    font-size: 16px;
    font-weight: bold;
    text-align: center;
    margin: 10px 0 0;
    min-height: 1em;
}

.reauth-email {
    display: block;
    color: #404040;
    line-height: 2;
    margin-bottom: 10px;
    font-size: 14px;
    text-align: center;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin #inputEmail,
.form-signin #inputPassword {
    direction: ltr;
    height: 44px;
    font-size: 16px;
}

.form-signin input[type=email],
.form-signin input[type=password],
.form-signin input[type=text],
.form-signin button {
    width: 100%;
    display: block;
    margin-bottom: 10px;
    z-index: 1;
    position: relative;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin .form-control:focus {
    border-color: rgb(104, 145, 162);
    outline: 0;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
}

.btn.btn-signin {
    /*background-color: #4d90fe; */
    background-color: rgb(104, 145, 162);
    /* background-color: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));*/
    padding: 0px;
    font-weight: 700;
    font-size: 14px;
    height: 36px;
    -moz-border-radius: 3px;
    -webkit-border-radius: 3px;
    border-radius: 3px;
    border: none;
    -o-transition: all 0.218s;
    -moz-transition: all 0.218s;
    -webkit-transition: all 0.218s;
    transition: all 0.218s;
}

.btn.btn-signin:hover,
.btn.btn-signin:active,
.btn.btn-signin:focus {
    background-color: rgb(12, 97, 33);
}

.forgot-password {
    color: rgb(104, 145, 162);
}

.forgot-password:hover,
.forgot-password:active,
.forgot-password:focus{
    color: rgb(12, 97, 33);
}



</style>


    <div  style="position:absolute; width:1366px; height: 580px; background-image:url(https://k60.kn3.net/taringa/3/6/E/E/A/9/luisdavid1256/F49.jpg);background-position: center center;
    background-repeat: no-repeat; background-size: cover;">

    <div class="container">
        <h1 style="color:white;">Mi Perfil</h1>
           
 <div class="card card-container">
            
            <p style="align-content: center; margin:auto; display:table; font-size: 20px; color:grey;">Perfil</p>
         
                <span id="reauth-email" class="reauth-email"></span>
               	<p style=" font-size: 20px; color:grey;">Nombre:</p><p><c:out value="${persona}"/>${persona.getNombre()}</p>
               	<p style=" font-size: 20px; color:grey;">Apellidos:</p><p><c:out value="${persona}"/>${persona.getApellidos()}</p>
               	<p style=" font-size: 20px; color:grey;">Dirección:</p><p><c:out value="${persona}"/>${persona.getDireccion()}</p>
               	<p style=" font-size: 20px; color:grey;">Teléfono:</p><p><c:out value="${persona}"/>${persona.getTelefono()}</p>
               	<p style=" font-size: 20px; color:grey;">Email:</p><p><c:out value="${persona}"/>${persona.getEmail()}</p>
                <div id="remember" class="checkbox">
                  
                </div>
                <button id="btnCancelarMP" class="btn btn-lg btn-primary btn-block btn-signin" value="Menu" type="submit">Cancelar</button>
                <button id="btnModificarPerfil" class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Modificar Perfil</button>
 
            <div>
          
            
        
        	
        	</div>
        </div><!-- /card-container -->
    </div>
        </div>
    </div><!--  FINNNNNNNNNNNNNNNNNNN -->
    <div id="divModificarPerfil" style="display: none; height: 590px; margin-top:-20px; position:absolute;border-style: solid;" class="col-lg-12 col-md-12 col-xs-12">
    <style>
.card-container.card {
    max-width: 350px;
    padding: 40px 40px;
}

.btn {
    font-weight: 700;
    height: 36px;
    -moz-user-select: none;
    -webkit-user-select: none;
    user-select: none;
    cursor: default;
}

/*
 * Card component
 */
.card {
    background-color: #F7F7F7;
    /* just in case there no content*/
    padding: 20px 25px 30px;
    margin: 0 auto 25px;
    margin-top: 50px;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.profile-img-card {
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}

/*
 * Form styles
 */
.profile-name-card {
    font-size: 16px;
    font-weight: bold;
    text-align: center;
    margin: 10px 0 0;
    min-height: 1em;
}

.reauth-email {
    display: block;
    color: #404040;
    line-height: 2;
    margin-bottom: 10px;
    font-size: 14px;
    text-align: center;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin #inputEmail,
.form-signin #inputPassword {
    direction: ltr;
    height: 44px;
    font-size: 16px;
}

.form-signin input[type=email],
.form-signin input[type=password],
.form-signin input[type=text],
.form-signin button {
    width: 100%;
    display: block;
    margin-bottom: 10px;
    z-index: 1;
    position: relative;
    -moz-box-sizing: border-box;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
}

.form-signin .form-control:focus {
    border-color: rgb(104, 145, 162);
    outline: 0;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgb(104, 145, 162);
}

.btn.btn-signin {
    /*background-color: #4d90fe; */
    background-color: rgb(104, 145, 162);
    /* background-color: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));*/
    padding: 0px;
    font-weight: 700;
    font-size: 14px;
    height: 36px;
    -moz-border-radius: 3px;
    -webkit-border-radius: 3px;
    border-radius: 3px;
    border: none;
    -o-transition: all 0.218s;
    -moz-transition: all 0.218s;
    -webkit-transition: all 0.218s;
    transition: all 0.218s;
}

.btn.btn-signin:hover,
.btn.btn-signin:active,
.btn.btn-signin:focus {
    background-color: rgb(12, 97, 33);
}

.forgot-password {
    color: rgb(104, 145, 162);
}

.forgot-password:hover,
.forgot-password:active,
.forgot-password:focus{
    color: rgb(12, 97, 33);
}
</style>

    <div  style="position:absolute; width:100%; height: 100%; background-image:url(https://k60.kn3.net/taringa/3/6/E/E/A/9/luisdavid1256/F49.jpg);background-position: center center;
    background-repeat: no-repeat; background-size: cover;">

    <div class="container">
        <h1 style="color:white;">Modifica tu Perfil</h1>


        <!--  Aqui aÃ±adir un form -->
        
        
 <div class="card card-container">
            
            <p style="align-content: center; margin:auto; display:table; font-size: 20px; color:grey;">Modifica Tu Perfil</p>
            <form action="modificarUsuario" method="post"  class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                Email:<input class="form-control" name="aEmail" placeholder="${persona.getEmail() }" disabled> </input>
                Usuario:<input class="form-control" name="aUser" placeholder="${persona.getUsername() }"  disabled > </input>
                Nombre<input type="text" name="inputNombre" class="form-control" placeholder="${persona.getNombre()}" required> 
                Apellidos<input type="text" name="inputApellidos" class="form-control" placeholder="${persona.getApellidos()}" required> 
                Password<input type="password" name="inputPassword" class="form-control" placeholder="*******" required> 
                Direccion<input type="text" name="inputDireccion" class="form-control" placeholder="${persona.getDireccion()}" required>
                Telefono<input type="text" name="inputTelefono" class="form-control" placeholder="${persona.getTelefono()}" required >  

                <div id="remember" class="checkbox">
                    
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Modificar</button>
            </form><!-- /form -->
            <div>
          
         
        
        	
        	</div>
        </div><!-- /card-container -->
    </div>
        </div>
    
    </div><!-- MODIFICARPERFIL -->

    

    <script type="text/javascript">
    
    $('#btnPublicar').click(function(){
    	if($('#textareaPublicacion').val() == ""){
    		alert('Por favor, escribe algo para tu publicación!');
    	}/*else{
    		
    	var texto=$('#textareaPublicacion').val();
    	$('#panel').append('<div id="publicacion" class="mensaje" style="margin-top:10px;height:100px; width:100%" ><div id="mensaje" style="text-align: left" class="col-md-10 col-lg-10 col-xs-10">'+texto+'</div><div id="perfil" style="font: 15px" class="col-lg-2 col-md-2 col-xs-2"><p><c:out value="${persona}"/>${persona.getNombre()}</p></div></div>');
    	//$('#textareaPublicacion').val("");
    	$('#obtenerUsuario').val($('#nombreUser').val());
    	}*/
    	});

    $('#btnAdjuntarFoto').click(function(){
    	alert('Funcionalidad No Disponible');
    });
    $('#liPublicacion').click(function(){
		$('#holaMenu').click();
    });
    $('#liLogo').click(function(){
		$('#holaLogo').click();
    });

    $('#aPublicacion').click(function(){
    	$('#holaMenu').click();
    });

    $('#liAmistad').click(function(){
    	$('#holaAmigos').click();
    });

    $('#aAmistad').click(function(){
    	$('#holaAmigos').click();
    });

    $('#liMP').click(function(){
    	$('#holaGente').click();
    });

    $('#aMP').click(function(){
    	$('#holaGente').click();
    });
    $('#liPerfil').click(function(){
    	$('#holaPerfil').click();
    });
    $('#aPerfil').click(function(){
    	$('#holaPerfil').click();
    });
    $('#liLogout').click(function(){
    	$('#holaMenu2').click();
    });
    $('#liTodasPublicaciones').click(function(){
    	$('#holatodasPublicaciones').click();
    });
	
    $('#aTodasPublicaciones').click(function(){
    	$('#holatodasPublicaciones').click();
    });
    $('#aLogout').click(function(){
    	$('#holaMenu2').click();
    });
</script>
</body>
</html>

