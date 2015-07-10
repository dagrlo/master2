<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Followers</title>
<link rel="stylesheet" href="./css/header.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/menuNav.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/main.css" type="text/css" charset="utf-8">
</head>
<body>
	<%@ include file="header.html" %>
	<%@ include file="navBar.html" %>
	<br/><br/><br/> 
	 <fieldset>
        <legend>Lista de seguidores</legend>
			<div id="divlistaChips">
            <ul class="listachips">
           
            
			<core:choose>
				<core:when test="${total ==0 }">
				
				    
					<li>
            				<section>
            					<span class="nombre">No tienes seguidores</span>
            				</section>
            			</li>
			
            		
            	
				</core:when>
				<core:otherwise >
					<core:forEach items="${following}" var="fList">
            		   <li>
            			 <section>
                	     	<span class="nombre">${fList.username}</span>
                        
               		   	  </section>
						</li>	
					</core:forEach>	
				 
				
            	</core:otherwise>	
		
				
				
			</core:choose>
		</ul>
				</div>	
			
		</fieldset>
		
</body>
</html>