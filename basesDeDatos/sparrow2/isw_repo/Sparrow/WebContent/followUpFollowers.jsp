<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>This is Sparrow!!!</title>
<link rel="stylesheet" href="./css/header.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/menuNav.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/main.css" type="text/css" charset="utf-8">

</head>
<body>
	<%@ include file="header.html" %>
	<%@ include file="navBar.html" %>
	<br/><br/><br/> 
		 <fieldset>
        <legend>Suscriptores que no sigo</legend>
    	<div id="divlistaUsuariosEncontrados">
    		<ul class="listachips">
            <c:choose >
            	<c:when test="${numUnfollowedFollowers == 0}">
            		<section>
						<span>Estás siguiendo a todos tus seguidores.</span>
					</section>
            	</c:when>
            	<c:when test="${numUnfollowedFollowers > 0}">
					<c:forEach var="unfollowed_followers" items="${unfollowedFollowers}">
						<section>
							<span class="titulo">${unfollowed_followers.nombre} ${unfollowed_followers.apellidos}</span>
							<span class="tag">Username: ${unfollowed_followers.username}</span>
							<span class="usr">
								<form method="post" action="Follow">
									<input name="followed" type="hidden" value="${unfollowed_followers.id}"> 
									<input type="Submit" value="Siguelo!">
								</form>
							</span>
						</section>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
	</fieldset>
	
</body>
</html>