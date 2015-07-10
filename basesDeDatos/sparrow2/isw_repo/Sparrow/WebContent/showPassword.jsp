<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ShowPassword</title>
<link rel="stylesheet" href="./css/dialogs.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/header.css" type="text/css" charset="utf-8">
</head>
<body>

<body>
	<%@ include file="header.html" %>
	<br/><br/><br/> 
	<fieldset>
		
	    <legend>User: ${username}  </legend>
	    <br/><br/>
	    <form action="index.jsp" method="post">
	    
			 <label for="clave">Nueva clave:</label> <span id="clave"> ${password}</span>
	         <br/><br/><br/>
	         <input type="submit" value="Continuar" id="volver" class="estiloBotones"/>                    
	    </form>
    </fieldset> 
</body>
</html> 