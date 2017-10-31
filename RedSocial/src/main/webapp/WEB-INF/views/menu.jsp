<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div id="navBar">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" >Intravita</a>
                </div>
                <ul class="nav navbar-nav">
                    <li id="liPublicacion" class="active"><a id="aPublicacion" >Publicaciones</a></li>
                    <li id="liAmistad"><a id="aAmistad" >Amigos</a></li>
                    <li id="liMP"><a id="aMP" >Mensajes Privados</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li id="liPerfil"><a id="aPerfil" ><span class="glyphicon glyphicon-user"></span> Perfil</a></li>
                    <li id="liLogout"><a id="aLogout" ><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                </ul>
            </div>
        </nav>

    </div>
    <div id="divPublicaciones" style="height: 590px; margin-top:-20px; position:absolute;border-style: solid;" class="col-lg-12 col-md-12 col-xs-12">
        <div id="publicacion" class="row-lg-3 row-md-3 row-xs-3">

  <textarea name="message" style="padding-bottom: 30px; width:75%"></textarea>
  <div style="float: right"class="col-md-3 col-lg-3 col-xs-3"><button class="btn btn-lg btn-primary btn-block btn-success" type="submit">Publicar</button>
  <button class="btn btn-lg btn-primary btn-block btn-success" type="submit">Adjuntar Foto</button></div>
        </div>

    </div>
    <div id="divAmigos" style="display: none; height: 590px; margin-top:-20px; position:absolute;border-style: solid;" class="col-lg-12 col-md-12 col-xs-12">
        AMIGUITOS

    </div>
    <div id="divMensajes" style="display: none; height: 590px; margin-top:-20px; position:absolute;border-style: solid;" class="col-lg-12 col-md-12 col-xs-12">

        PRUEBAMENSAJES
    </div>
</body>
</html>

