<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>vista1</title>
</head>
<body>
	
	<c:forEach var="tempProductos" items="${listaProductos}">
	
		${tempProductos}<br>
		 
	</c:forEach>

</body>
</html>