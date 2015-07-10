<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="registerFormChecker.js"></script>
<title>Registro de usuario:</title>
<link rel="stylesheet" href="./css/header.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/menuNav.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/dialogs.css" type="text/css" charset="utf-8">

</head>
<body>
	<br/><br/><br/> 
	  <fieldset>
            <legend>Registro de usuario:</legend>
            <form action="Register" method="post" onSubmit="return checkForm()">
                 <p/><label for="usr">Usuario:</label> <input type="text" name="username" id="usernameField" required/>
                 <p/><label for="clave">Clave:</label> <input type="password" id="pwdField" name="password" required/>
                 <p/><label for="email">E-mail:</label> <input type="email" name="eMail" id="mailField" required/>
                 <p/><label for="nombre">Nombre</label> <input type="text" id="nameField" name="firstName" required/>
                 <p/><label for="apellidos">Apellidos:</label> <input type="text" id="surnameField" name="surname" required/>                 
                 <p/><label for="sBtn">Sexo</label>
                 					<span id="sBtn"> 
                 					<!-- Para que funcionen los radiobutton deben tener el mismo name para estar agrupados
                 						hay que trabajar sobre el id o sobre el value -->
                 							<input type="radio" id="genderV" value="V" name="gender" />V
                 							<input type="radio" id="genderM" value="M" name="gender"/>M
                 					</span>
                 <p/><label for="idioma">Idioma:</label> 
                    <select id="languageField" name="language">
                    	<option value="es">Español</option>
                        <option value="de">Deutsch</option>
                        <option value="en">English</option>                        
                    </select>
                 <br/><br/><br/>
                 <span id="botones">
                    <input type="submit" name="subscribe" value="Enviar" id="envia" class="estiloBotones"/>
                    <input type="button" value="Cancelar" id="volver" class="estiloBotones" onclick="location.href='index.jsp'"/>
                 </span>
            </form>
        </fieldset>
	
</body>
</html>