<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <legend>Suscriptores que sigo</legend>
        <div>
	        <c:choose >
	            	<c:when test="${num_followers == 0}">
	            		<section>
							<span>No estás siguiendo a ningún usuario</span>
						</section>
	            	</c:when>
	            	<c:when test="${num_followers > 0}">
						<c:forEach var="followers_users" items="${followers}">
						<section>
							<span class="titulo">${followers_users.nombre} ${followers_users.apellidos}</span>
							<span class="tag">Username: ${followers_users.username}</span>
							<span class="usr">
								<form method="post" action="#">
									<input type="hidden" name="id_user" value="${followers_users.id}">
									<input type="submit" value="Dejar de seguir!">
								</form>
						</section>
					</c:forEach>
				</c:when>
	        </c:choose>
	    </div>
    </fieldset>
</body>
</html>