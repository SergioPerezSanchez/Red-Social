<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Red Social</title>
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
<body >
	
	<script language="JavaScript" type="text/javascript">
		if("${aviso}"!=""){
			alert("${aviso}");
		}
	</script>
	
    <div  style="position:absolute; width:100%; height: 100%; background-image:url(https://k60.kn3.net/taringa/3/6/E/E/A/9/luisdavid1256/F49.jpg);background-position: center center;
    background-repeat: no-repeat; background-size: cover;">

    <div class="container">
        <h1 style="color:white;">Bienvenido a Intravita</h1>
        <p style="font-size: 20px; color:white;">Inicia sesión para entrar o si aún no tienes cuenta...regístrate!</p>
      	<form action="register" method="get">
            	<button class="btn btn-success" style="font-size: 20px; color:white;" type="submit" value="Registrarse" name = "register">Regístrate</button>
        </form>
        <!--  Aqui aÃ±adir un form -->
        
        
 <div class="card card-container">
            
            <p style="align-content: center; margin:auto; display:table; font-size: 20px; color:grey;">Login</p>
            <form action="loginUsuario" method="post"  class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" name="inputEmail" class="form-control" placeholder="Username" required autofocus>
                <input type="password" name="inputPassword" class="form-control" placeholder="Password" required>
                <div id="remember" class="checkbox">
                    
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Sign in</button>
            </form><!-- /form -->
            <div>
          
             <form action="forgotPassword" method="get">
            	<button style="align-content: center;margin: auto;display: table;" class="btn btn-warning" type="submit" value="forgotPassword" name = "forgotPassword">¿Olvidó la Contraseña?</button>
        	</form>
        
        	
        	</div>
        </div><!-- /card-container -->
    </div>
        </div>
</body>
</html>