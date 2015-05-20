<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='stylesheet' href='./sampleGuiaProxy/css/estilos.css' type='text/css'/>
</head>
<script src="./sampleGuiaProxy/js/utilsAjax.js"></script>

<body >
  <nav>
  	<ul class="menu">
  		<li><a href="#">Ficha identificativa</a>
  			<ul>
  				<li><a href="#" onclick="enviarPeticion(1)">Datos de asignatura</a></li>
  				<li><a href="#" onclick="enviarPeticion(2)">Titulaciones</a></li>
  				<li><a href="#" onclick="enviarPeticion(3)">Materias</a></li>
  				<li><a href="#" onclick="enviarPeticion(4)">Coordinacion</a></li>
  			</ul>  			
  		</li>
  		<li><a href="#" onclick="enviarPeticion(5)">Resumen de la asignatura</a></li>
  		<li><a href="#">Conocimientos previos</a>
  			<ul>
  				<li><a href="#" onclick="enviarPeticion(6)">Relacion con otras asignaturas</a></li>
  				<li><a href="#" onclick="enviarPeticion(7)">Otros requisitos</a></li>
  			</ul>
  		</li>
  		<li><a href="#" onclick="enviarPeticion(8)">Competencias</a></li>
  		<li><a href="#" onclick="enviarPeticion(9)">Resultados de aprendizaje</a></li>
  		<li><a href="#" onclick="enviarPeticion(10)">Descripcion de contenidos</a></li>
  		<li><a href="#">Volumen de trabajo</a>
  			<ul>
  				<li><a href="#" onclick="enviarPeticion(11)">Actividades presenciales</a></li>
  				<li><a href="#" onclick="enviarPeticion(12)">Actividades no presenciales</a></li>
  			</ul>
  		</li>
  		<li><a href="#" onclick="enviarPeticion(13)">Metodologia docente</a></li>
  		<li><a href="#" onclick="enviarPeticion(14)">Evaluacion</a></li>
  		<li><a href="#">Referencias</a>
  			<ul>
  				<li><a href="#" onclick="enviarPeticion(15)">Referencias basicas</a></li>
  				<li><a href="#" onclick="enviarPeticion(16)">Referencias complementarias</a></li>
  			</ul>
  		</li>
  		
  	</ul>

</nav>
	<div id="resultados">
	
	</div>

</body>
</html>