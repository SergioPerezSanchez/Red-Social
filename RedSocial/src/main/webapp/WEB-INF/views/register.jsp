<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="modelo.DAOPersona" %>
    <%@page import="modelo.Persona" %>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="   crossorigin="anonymous"></script>
<script type="text/javascript" src="js/index.js"></script>
	<title>Red Social - Registro</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
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
<body>
	
	<script language="JavaScript" type="text/javascript">
		if("${mensaje}"!=""){
			alert("${mensaje}");
		}
	</script>
	
	<div id="contenedor" style="position:absolute; width:100%; height: 130%;background-image:url(http://img13.deviantart.net/121b/i/2009/179/7/7/_pure_gaia_wp06_by_g2k2007.jpg);background-position: center center;
	background-repeat: no-repeat; background-size: cover;">
	

	<div class="container">
		<h1 style="color:white">Regístrate en Intravita</h1>
		<p style="font-size: 20px;color:white">Introduce tus datos personales a continuación</p>
<div class="card card-container">
 <p style="align-content: center; margin:auto; display:table; font-size: 20px; color:grey;">Registro</p>
            <!-- <img class="profile-img-card" src="//lh3.googleusercontent.com/-6V8xOA6M7BA/AAAAAAAAAAI/AAAAAAAAAAA/rzlHcD0KYwo/photo.jpg?sz=120" alt="" /> -->
            <form action="crearUsuario" method="post" class="form-signin" name="form1" >
	                <span id="reauth-email" class="reauth-email"></span>
	                <input type="text" name="inputNombreRegistro" class="form-control" placeholder="Nombre" required>
	                <input type="text" name="inputApellidosRegistro" class="form-control" placeholder="Apellidos" required>
	                <input type="text" name="inputUsernameRegistro" class="form-control" placeholder="Username" required>
	                <input type="email" name="inputEmailRegistro" class="form-control" placeholder="Email address" required>
	                <input type="password" id="inputPasswordRegistro" name="inputPasswordRegistro" class="form-control" placeholder="Password" required>
	                La contraseña debe tener un tamaño mínimo de 8 caracteres y debe de contener al menos un dígito, una letra mayúscula y una letra minúscula.
	                <input type="password" id="inputRePasswordRegistro" name="inputRePasswordRegistro" class="form-control" placeholder="Repita Password" required>
	                <input type="text" name="inputDireccionRegistro" class="form-control" placeholder="Direccion" required>
	                <input type="text" name="inputTelefonoRegistro" class="form-control" placeholder="Telefono" required>
	                FOTO DE PERFIL
	                <input type="file" name="inputFotoRegistro" accept="image/*" required>
	                <div id="remember" class="checkbox">	                
	                </div>
                <button id="btnSignup" class="btn btn-lg btn-primary btn-block btn-signin" type="submit" onclick="validarFormularios()">Sign up</button>
            </form>
            <div id="remember" class="checkbox">	                
            </div>
            <form action="home.jsp" method="get">
            	<button style="padding-bottom:10px; float: right;margin: auto;display: table;" class="btn btn-warning" type="submit" value="Home" name="home" >Volver</button>
        	</form>
        </div><!-- /card-container -->
	</div>
	</div>
	<script language="JavaScript" type="text/javascript">
		document.form1.inputNombreRegistro.value="${nombre}";
		document.form1.inputApellidosRegistro.value="${apellidos}";
		document.form1.inputUsernameRegistro.value="${usuario}";
		document.form1.inputEmailRegistro.value="${email}";
		document.form1.inputPasswordRegistro.value="${password}";
		document.form1.inputRePasswordRegistro.value="${repassword}";
		document.form1.inputDireccionRegistro.value="${direccion}";
		document.form1.inputTelefonoRegistro.value="${telefono}";
		document.form1.inputFotoRegistro.value="${foto}";
	</script>
</body>
</html>
