<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, puro.java.servlet1.*"  %>   
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%
	//OBTENEMOS LOS PRODUCTOS DESDE EL CONTROLADOR SERVLET "CONTROLADORPRODUCTOS"
	List<Productos>losProductos = (List<Productos>)request.getAttribute("LISTAPRODUCTOS");
%>

<body>

	<%=losProductos %>

</body>
</html>