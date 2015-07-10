<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gestión de usuario</title>
<link rel="stylesheet" href="./css/header.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/menuNav.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/dialogs.css" type="text/css" charset="utf-8">
</head>
<body>
<%@ include file="header.html" %>
	<%@ include file="navBar.html" %>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<fieldset>
<legend>Configuración del usuario</legend>
<form action="UserManagement" method="post">
	Cuenta: ${user.username} <br/>
	Password: <input name="password" type="password" value="${user.password}"/><br/>
	Correo: ${user.eMail}<br/>
	nombre: <input name="name" type="text" value="${user.nombre}"/><br/>
	apellido: <input name="name2" type="text" value="${user.apellidos}"/><br/>
	sexo: <input name="sex" type="text" value="${user.sexo}"/><br/>
	idioma: <input name="language" type="text" value="${user.idioma}"/><br/>
	
	<input name="change_user" value="Aplicar Cambios" type="submit"/>
	${message}
</form>
</fieldset>
</body>
</html>