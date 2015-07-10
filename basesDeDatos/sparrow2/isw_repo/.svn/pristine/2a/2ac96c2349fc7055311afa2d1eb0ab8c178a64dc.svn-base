<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/header.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/menuNav.css" type="text/css" charset="utf-8">
<link rel="stylesheet" href="./css/dialogs.css" type="text/css" charset="utf-8">

</head>
<body>
<%@ include file="header.html" %>
	<%@ include file="navBar.html" %>
	<br/><br/><br/> 
<fieldset>
<!-- Aqui he hecho corta y pega del main porque mas o menos es lo mismo,
hay que cambiar los nombres de variable supongo ahora mismo es fallo total por eso
creo. -->
        <legend>Chips encontrados para el tag TAG</legend>
        <div id="divlistaChips">
            <ul class="listachips">
              <c:forEach var="rp" items="${response}">
				<c:choose>
					<c:when test="${rp.id == -1}">
						<section>
							<span class="usr">No hay temas creados</span>
						</section>
					</c:when>
					<c:when test="${rp.id == -2}">
						<section>
							<span class="usr">No se puede establecer conexión con la base de datos</span>
						</section>
					</c:when>
					<c:when test="${rp.id > -1}">
					<!-- 
							Hola chicos. Aqui entran los comentarios. Segun el diseño
							tambien entran busquedas de gente.
							Segun el estilo es una cosa u otra. 
							De momento pongo el estilo de chips.
							Debajo os pongo el formato para cuando la respuesta
							sea una lista de gente.
							
							Supongo que topics es un chip Bean.
					--> 
					 <li>
                  	  <section>
                  	     <span class="titulo">${topics.text}</span><br>
                   	     <span class="tag">${topics.tag}</span>
                   	     <span class="usr">${topics.user}</span>
                   	     <!-- CAGADA!!! Tenemos que dar un nombre de usuario, no un int
                   	     yo añadiria el nombre de usuario directamente al bean -->
                  	  </section>
              		</li>
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