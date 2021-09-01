<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, puro.java.servlet1.*"  %>   
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
	.cabecera{
		border-bottom:solid #F00 1px;
	}
</style>

</head>

<%
	//OBTENEMOS LOS PRODUCTOS DESDE EL CONTROLADOR SERVLET "CONTROLADORPRODUCTOS"
	List<Productos>losProductos = (List<Productos>)request.getAttribute("LISTAPRODUCTOS");
%>

<body>

	<table>
		<tr>
			<td class="cabecera">CÓDIGOARTÍCULO</td>
			<td class="cabecera">SECCIÓN</td>
			<td class="cabecera">NOMBREARTÍCULO</td>
			<td class="cabecera">PRECIO</td>
			<td class="cabecera">FECHA</td>
			<td class="cabecera">IMPORTADO</td>
			<td class="cabecera">PAÍSDEORIGEN</td>
		</tr>
		<%for(Productos p : losProductos){%>
			<tr>
				<td><%=p.getcArt() %></td>
				<td><%=p.getSeccion() %></td>
				<td><%=p.getnArt() %></td>
				<td><%=p.getPrecio() %></td>
				<td><%=p.getFecha() %></td>
				<td><%=p.getImportado() %></td>
				<td><%=p.getpOrig() %></td>
			</tr>
		<% }%>
	</table>

</body>
</html>