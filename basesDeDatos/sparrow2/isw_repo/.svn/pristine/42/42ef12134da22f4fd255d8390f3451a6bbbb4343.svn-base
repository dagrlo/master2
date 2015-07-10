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
        <legend>Suscriptores que sigo y no me siguen</legend>
    	<div id="divlistaUsuariosEncontrados">
    		<ul class="listachips">
            <c:choose >
            	<c:when test="${num_followed_not_following == 0}">
            		<section>
						<span>Todos tus favoritos te estan siguiendo.</span>
					</section>
            	</c:when>
            	<c:when test="${num_followed_not_following > 0}">
					<c:forEach var="followed_users" items="${followed_not_following}">
						<section>
							<span class="titulo">${followed_users.nombre} ${followed_users.apellidos}</span>
							<span class="tag">Username: ${followed_users.username}</span>
							<span class="usr">
								<form method="post" action="Unfollow">
									<input name="unfollowed" type="hidden" value="${followed_users.id}">
									<input type="Submit" value="No lo sigas!">
								</form>
						</section>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
	</fieldset>
	
</body>
</html>