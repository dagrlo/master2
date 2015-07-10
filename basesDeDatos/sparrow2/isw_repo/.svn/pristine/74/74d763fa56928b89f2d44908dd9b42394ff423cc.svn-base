<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chips por Tag</title>
<link rel="stylesheet" href="./css/header.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/menuNav.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/main.css" type="text/css" charset="utf-8">

</head>
<body>
<%@ include file="header.html" %>
	<%@ include file="navBar.html" %>
	<br/><br/><br/> 
<fieldset>
	<legend>Chips encontrados para el tag "${tag}"</legend>
        <div id="divlistaChips">
            <ul class="listachips">
            <c:forEach var="topics" items="${chipsbytag}">
				<c:choose>
					<c:when test="${topics.id > -1}">
					 <li>
                  	  <section>
                  	  <form id="replyform" action="ReplyTool" method="get">
                  	     <span class="titulo">${topics.text}</span><br>
                   	     <span class="tag">${topics.tag}</span>
                   	     <c:set var="indice">${topics.id}</c:set> 
                   	     <span class="usr">${user_topics[indice]}</span>
                   	     <input name="chipid" type="hidden" value="${topics.id}"/>
							<input id="responder" type="submit" value="Responder"/>
					  </form>
              		
                  	  </section>
              		</li>         		
					</c:when>
				</c:choose>
			</c:forEach>
		 </ul>
	    </div>
      </fieldset>

</body>
</html>