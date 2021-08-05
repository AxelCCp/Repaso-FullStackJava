<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- IMPORTAMOS LAS LIBRERÍAS JSTL Y CON PREFIX="C" LE DECIMOS QUE VAMOS A USAR LA JSTL TAG "CORE" -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%
	//DECLARAMOS UN ARRAY PARA SIMULAR LOS RESULTADOS DE UNA CONSULTA A UNA BASE DE DATOS
	String[]alumnos = {"Pilaf","Puar","Ulon", "Giru"}; 
	pageContext.setAttribute("losAlumnos", alumnos);
%> 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%/*
	//CÓDIGO JSP  
		for(String tempAlumnos : alumnos){
			out.println(tempAlumnos + "<br>");
		}*/
	%>
	
	<!-- USAMOS JSTL TAG, LE PASAMOS "losAlumnos" DEL MÉTODO setAttribute() -->
	<c:forEach var="tempAlumnos" items="${losAlumnos}">
		${tempAlumnos}<br/>
	</c:forEach>

</body>
</html>