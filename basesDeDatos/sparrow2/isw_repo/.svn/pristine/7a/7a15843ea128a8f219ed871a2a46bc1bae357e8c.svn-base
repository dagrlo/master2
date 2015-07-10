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
    <!-- Mirad el header html. Pone. "Conectado como: nombreUsuario" Hay que poner algo de java -->
	<%@ include file="header.html" %>
	<%@ include file="navBar.html" %>
	
	<br/><br/><br/> 
	 <fieldset>
        <legend>Últimos chips</legend>
        <div id="divlistaChips">
            <ul class="listachips">
			
			<%int indice = 0;
			  String nombre_formulario = "";%>
			<c:forEach var="topics" items="${topics_null}">
				<c:choose>
					<c:when test="${topics.id == -1}">
						<section>
							<span>No hay temas creados</span>
						</section>
					</c:when>
					<c:when test="${topics.id == -2}">
						<section>
							<span>No se puede establecer conexión con la base de datos</span>
						</section>
					</c:when>
					<c:when test="${topics.id > -1}">
					<!-- 
							Hola chicos. Aqui entran los comentarios. Segun el diseño
							tambien entran busquedas de gente.
							Segun el estilo es una cosa u otra. 
							De momento pongo el estilo de chips.
							Debajo os pongo el formato para cuando la respuesta
							sea una lista de gente.
							
							Supongo que topics es un chip Bean.
					--> 
					<%indice++;
					  nombre_formulario = "formulario" + Integer.toString(indice);%>
					<form action="bytag" method="post" name="<%= nombre_formulario%>">
						<li onclick="javascript:document.<%= nombre_formulario%>.submit();" onmouseover="" style="cursor: pointer;">
	                  	  <section>
	                  	     <span class="titulo">${topics.text}</span><br>
	                   	     <span class="tag">${topics.tag}</span>
	                   	     <!-- Modificacion para poder mostrar el nombre de usuario, en vez del ID -->
	                   	     <c:set var="indice">${topics.user}</c:set> 
	                   	     <span class="usr">${user_topics[indice]}</span>
	                   	     <input name="tag" type="hidden" value="${topics.tag}"/>
	                  	  </section>
	              		</li>
              		</form>
              		<!-- 
              		
              			Esto es el formato para poner nombres de usuario con sus botones follow y unfollow
              			
              			 <section>
                     		   <span class="nombre">Nombre de usuario</span>
                      				  <div class="masmenosdiv"> 
                      				      <a href="#"><img src="./imgs/btnmas.png" class="masmenos"/></a>
                       				     <a href="#"><img src="./imgs/btnmenos.png" class="masmenos"/></a>
                       					 </div>
                  		  </section>
                    
              		 -->
              		
					
						
					</c:when>
				</c:choose>
			</c:forEach>
			
			   </ul>
        </div>
      </fieldset>
	
</body>
</html>