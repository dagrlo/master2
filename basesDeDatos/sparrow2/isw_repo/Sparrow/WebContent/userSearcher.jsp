<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buscar usuarios</title>
<link rel="stylesheet" href="./css/dialogs.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/header.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/menuNav.css" type="text/css" charset="utf-8">
</head>
<body>
<%@ include file="header.html" %>
	<%@ include file="navBar.html" %>
	<br/><br/><br/> 
	
	 <fieldset>
            <legend>Buscar usuarios</legend>
            <form action="UserSearcher" method="post">
                <p/><label for="usr">Introduzca letra/s de los apellidos:</label> <input type="text" id="usr" name="usersearch" required/>
                <br/><br/>
                <span id="botones">
                    <input type="submit" value="Enviar" id="envia" class="estiloBotones"/>
                    <input type="button" value="Cancelar" id="cancela" class="estiloBotones" onclick="location.href='mainPage'"/>
                 </span>
            </form>
        </fieldset>

</body>
</html>