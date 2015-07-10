<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="userbean" scope="session" class="es.uv.isw.sparrow.bean.UserBeanImpl"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenido a Sparrow!</title>
<link href="css/index.css" rel="stylesheet">
</head>
<body>

<h1>Sparrow</h1>

<div id="contenedor"> 
	<div id="image-contenedor">
		<div id="image"></div>
	</div>
   <form action="mainPage" method="post">
      Username: <input type="text" name="username" value=<jsp:getProperty name="userbean" property="username"/>>
      <br>
      Password: <input type="password" name="password">
      <br>
      <input type="submit" value="Log In"/>
      <div>
       	<a href="registerForm.jsp">Usuario nuevo (Registrarse)</a><br/>
       	<a href="forgetPasswordForm.jsp">He olvidado la clave</a>
      </div>          
   </form>
</div>
	
</body>
</html>