<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- El núcleo de JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <!-- Añadimos también las funciones (para lo de length()) -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Usuarios encontrados</title>
<link rel="stylesheet" href="./css/header.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/menuNav.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/main.css" type="text/css" charset="utf-8">

</head>
<body>
	<%@ include file="header.html" %>
	<%@ include file="navBar.html" %>
	<br/><br/><br/> 
	<br>
	<fieldset>
		<legend>Usuarios encontrados</legend>
		<div id="divlistaUsuariosEncontrados">
			<ul class="listachips">
				<!-- Usamos el Bean especial que hemos creado para este caso de uso -->
				<jsp:useBean id="ust" class="es.uv.isw.sparrow.registereduser.usersearch.UserSearcherTool" scope="request"/>

				<!-- Recorremos según el nº de usuarios coincidentes -->				
				<c:forEach var="i" begin="0" end="${fn:length(ust.userNames) - 1}">
					<section>
						<span>
							<!-- Mostramos los usuarios encontrados -->
					   		${ust.userNames[i]}: ${ust.nombres[i]} ${ust.apellidos[i]}
						</span>
			   		</section>
			   		<form method="post" action="Follow">
						<input name="followed" type="hidden" value="${ust.ids[i]}"> 
						<input type="Submit" value="Seguir">
					</form>
					
					<form method="post" action="Unfollow">
						<input name="unfollowed" type="hidden" value="${ust.ids[i]}">
						<input type="Submit" value="Dejar de seguir">
					</form>
					
					<br>
			   		
			   		<!--  
			   		<div class="masmenosdiv">
						<a href="follow"><img src="./imgs/btnmas.png" class="masmenos" name="follow" onclick="location.href='follow'"/></a>
						<a href="#"><img src="./imgs/btnmenos.png" class="masmenos" name="unfollow" onclick="location.href='unfollow'"/></a>
					</div>
					-->
					
				</c:forEach>
			</ul>
		</div>
	</fieldset>
	
</body>
</html>