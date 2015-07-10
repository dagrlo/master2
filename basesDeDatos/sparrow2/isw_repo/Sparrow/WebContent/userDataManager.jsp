<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/dialogs.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/header.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/menuNav.css" type="text/css" charset="utf-8">
</head>
<body>
<%@ include file="header.html" %>
	<%@ include file="navBar.html" %>
	<br/><br/><br/> 
	<fieldset>
             <legend>Editando cuenta:<span id="tituloCuenta"> NOMBREUSR </span></legend>
            <form action="send" method="get">                 
                 <p/><label for="clave">Clave:</label> <input type="password" id="clave" required/>
                 <p/><label for="email">E-mail:</label> <input type="email" id="email" required/>
                 <p/><label for="nombre">Nombre</label> <input type="text" id="nombre" required/>
                 <p/><label for="apellidos">Apellidos:</label> <input type="text" id="apellidos" required/>                
                  <p/><label for="sBtn">Sexo</label>
                 					<span id="sBtn"> 
                 					<!-- Para que funcionen los radiobutton deben tener el mismo name para estar agrupados
                 						hay que trabajar sobre el id o sobre el value -->
                 							<input type="radio" id="genderV" value="V" name="gender" />V
                 							<input type="radio" id="genderM" value="M" name="gender"/>M
                 					</span>
                 <p/><label for="idioma">Idioma:</label> 
                    <select id="idioma">
                        <option value="de">Deutsch</option>
                        <option value="en">English</option>
                        <option value="es">Español</option>
                    </select>
                 <br/><br/><br/>
                 <span id="botones">
                    <input type="submit" value="Enviar" id="envia" class="estiloBotones"/>
                    <input type="button" value="Cancelar" id="cancela" class="estiloBotones"/>
                 </span>
            </form>
        </fieldset>
</body>
</html>