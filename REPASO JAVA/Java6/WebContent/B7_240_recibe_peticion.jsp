<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
	//LEYENDO DATOS DEL FORMULARIO. CON EL OBJ REQUEST Y EL MÉTODO, PEDIMOS POR PARÁMETRO LO SELECCIONADO.
	String ciudad_favorita = request.getParameter("ciudad_favorita");
	
	//CREAMOS LA COOKIE
	//EL CONSTRUCTOR DE LA COOKIE PIDE (NOMBRE DE COOKIE, VALOR DE COOKIE)
	Cookie laCookie = new Cookie("agencia_viajes.ciudad_favorita",ciudad_favorita);
	
	//VIDA DE LA COOKIE : 1 AÑO EN SEGUNDOS
	laCookie.setMaxAge(365*24*60*60);
	
	//ENVIAR AL USUARIO
	response.addCookie(laCookie);
	
%>

Gracias por enviar tus preferencias

<!-- CREAMOS UN ENLACE QUE NOS LLEVE A LA PÁGINA YA PERSONALIZADA -->

<a href="B8_240_agencia_viajes.jsp">Ir a la agencia de viajes</a>

</body>
</html>