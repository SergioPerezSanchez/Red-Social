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
			response.sendRedirect("home.jsp");
		}
	%>
    <div id="navBar">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="init" class="navbar-brand" >Intravita</a>
                </div>
                <ul class="nav navbar-nav">
                    <li id="liPublicacion" ><a id="aPublicacion" >Publicaciones</a></li>
                    <li id="liAmistad" class="active"><a id="aAmistad" >Amigos</a></li>
                    <li id="liMP"><a id="aMP" >Gente</a></li>
                    <c:if test = "${persona.isEsAdmin() == true}">
                    <li id="liTodasPublicaciones"><a id="aTodasPublicaciones" >Todas Publicaciones</a></li>
                    <li id="liPanel" ><a id="aPanel"> Panel</a></li>
                    <li id="liRegistroUser"><a id="aRegistroUser" >Registra Usuario</a></li>
                    </c:if>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li id="liPerfil"><a id="aPerfil" ><span class="glyphicon glyphicon-user"></span> Perfil</a></li>
                    <li id="liLogout"><a id="aLogout" href="exit"><span href="exit" class="glyphicon glyphicon-log-in"></span> Logout</a></li>
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
        <form action="perfil" method="get">
            <button  id="holaPerfil" style="display:none; padding-bottom:10px; float: right;margin: auto;" class="btn btn-warning" type="submit" value="Perfil" name="perfil" >Volver</button>
        </form>
    	<form action="todasPublicaciones" method="get">
            <button  id="holatodasPublicaciones" style="display:none; padding-bottom:10px; float: right;margin: auto;" class="btn btn-warning" type="submit" value="TodasPublicaciones" name="todasPublicaciones" >Volver</button>
        </form>
    	<form action="menu" method="get">
            <button  id="holaMenu2" style="display:none; padding-bottom:10px; float: right;margin: auto;" class="btn btn-warning" type="submit" value="Menu" name="menu" >Volver</button>
        </form>
        <form action="panel" method="get">
            <button  id="holaPanel" style="display:none; padding-bottom:10px; float: right;margin: auto;" class="btn btn-warning" type="submit" value="Panel" name="panel" >Volver</button>
        </form>
        <form action="registerUsuario" method="get">
            <button  id="holaRegisterUsuario" style="display:none; padding-bottom:10px; float: right;margin: auto;" class="btn btn-warning" type="submit" value="RegisterUsuario" name="registerusuario" >Volver</button>
        </form>
    </div>
    <!--  FIN PANEL BOTONES INVISIBLES ;D -->
    <style>
	.subencabezado {  /*nombre del estilo o botón*/
		border: 2px solid grey;  /*borde: estilo y color*/
		margin-top: 3px;
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
		color:black;  /*color de la fuente*/
		letter-spacing: 2px; /*separación entre las letras*/
		text-align: center; /*alineación del texto*/
		text-transform: uppercase; /*texto se tpersonaransforma en mayúsculas*/
		padding: 30px;  /*tamaño del fondo*/
		border-radius: 30px; /*forma la borde del fondo*/
	}
	</style>

    <div id="divAmigos" style="height: 100%;width:100%; margin-top:-20px; position:absolute" class="col-lg-12 col-md-12 col-xs-12">
	<!-- Panel Amigos -->
	<div class="subencabezado" style="width:100%">Amigos</div>
	<div id="panelAmigos" style="width:100%;height:45%">
			<c:forEach var="listValue" items="${listAmigos}">
			<div id="usuario-${listValue.getUsername()}" style="text-align: left" class="col-md-6 col-lg-6 col-xs-6"> ${listValue.getNombre()} ${listValue.getApellidos()}</div>				
						<form class="col-md-2 col-lg-2 col-xs-2" style="margin-right: 40px;" action="eliminarAmigo" method="post">
							<input name="eliminar" value="${listValue.getUsername()}" style="display:none">
							<button id="eliminar-${listValue.getUsername()}" class="btn btn-danger" name="eliminar-'${listValue.getUsername()}">Eliminar</button>
						</form>
			</c:forEach>
	</div>
	<!--  Panel Peticiones -->
	<div class="subencabezado" style="width:100%">Peticiones de Amistad</div>
	<div id="panelPeticionesAmistad" style="width:100%;height:45%">
	<c:forEach var="listValue" items="${listPeticiones}">
			<div id="usuario-${listValue.getUsername()}" style="text-align: left" class="col-md-6 col-lg-6 col-xs-6"> ${listValue.getNombre()} ${listValue.getApellidos()}</div>				
						<form class="col-md-2 col-lg-2 col-xs-2" style="margin-right: 40px;" action="aceptarPeticion" method="post">
							<input name="aceptar" value="${listValue.getUsername()}" style="display:none">
							<button id="aceptar-${listValue.getUsername()}" class="btn btn-success" name="aceptar-'${listValue.getUsername()}">Aceptar</button>
						</form>
						<form class="col-md-2 col-lg-2 col-xs-2" style="margin-right: 40px;" action="rechazarPeticion" method="post">
							<input name="rechazar" value="${listValue.getUsername()}" style="display:none">
							<button id="rechazar-${listValue.getUsername()}" class="btn btn-danger" name="rechazar-'${listValue.getUsername()}">Rechazar</button>
						</form>
						
	</c:forEach>
	</div>
    </div>
    <script type="text/javascript">
    
    $('#btnPublicar').click(function(){
    	var texto=$('#textareaPublicacion').val();
    	$('#panel').append('<div id="publicacion" style="margin-top:10px; margin-left:10px; height:100px; width:90%;border-style:solid" ><div id="mensaje" class="col-md-6 col-lg-6 col-xs-6">'+texto+'</div><div id="perfil" class="col-lg-3 col-md-3 col-xs-3"><p><c:out value="${persona}"/>${persona.getNombre()}</p></div></div>');
    });

    $('#btnAdjuntarFoto').click(function(){
    	alert('Funcionalidad No Disponible');
    });
    $('#liPublicacion').click(function(){
		$('#holaMenu').click();
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
    $('#liPanel').click(function(){
    	$('#holaPanel').click();
    });
    $('#aPanel').click(function(){
    	$('#holaPanel').click();
    });
    $('#liRegistroUser').click(function(){
    	$('#holaRegisterUsuario').click();
    });
    $('#aRegistroUser').click(function(){
    	$('#holaRegisterUsuario').click();
    });
</script>
</body>
</html>

