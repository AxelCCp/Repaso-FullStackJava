<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP con jsp tags</title>
<style type="text/css">
	.cabecera{
		font-size:1.2em;
		font-weight:bold;
		color:#FFFFFF;
		background-color: #08088A; 
	}
	
	.filas{
		text-aling:center;
		background-color: #90CAF9 ;
	}
	
	table{
		float:left;
	}
	
	#contenedorBoton{
		margin-left:1000px;
	}
	
</style>
</head>

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
			<td class="cabecera">ACCIÓN</td>
		</tr>
		
		<c:forEach var="p" items="${LISTAPRODUCTOS}">
		
		<!-- LINK DE ACTUALIZAR PARA CADA PRODUCTO CON SU CAMPO CLAVE  -->
		<c:url var="linkTemp" value="ControladorProductos">
			<!-- LE DAMOS value= INSTRUCCION PARA USARLO EN EL CONTROLADOR -->
			<c:param name="instruccion" value="cargar"></c:param>
			<!-- CARGAMOS EL CÓDIGO DEL ARTÍCULO EN EL LINK -->
			<c:param name="CArticulo" value="${p.cArt }"></c:param>
		</c:url>
		
		<!-- LINK PARA ELIMINAR REGISTROS CON SUCAMPO CLAVE -->
		<c:url var="linkTempEliminar" value="ControladorProductos">
			<c:param name="instruccion" value="eliminar"></c:param>
			<c:param name="CArticulo" value="${p.cArt }"></c:param>
		</c:url>
		
			<tr>
				<td class="filas">${p.cArt }</td>
				<td class="filas">${p.seccion }</td>
				<td class="filas">${p.nArt }</td>
				<td class="filas">${p.precio }</td>
				<td class="filas">${p.fecha }</td>
				<td class="filas">${p.importado }</td>
				<td class="filas">${p.pOrig }</td>
				<td class="filas"><a href="${linkTemp}">Actualizar</a>&nbsp;&nbsp;<a href="${linkTempEliminar}">Eliminar</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<div id="contenedorBoton">
		<input type="button" value="Insertar registro" onclick="window.location.href='InsertaProducto.jsp'"/>
	</div>
	
</body>
</html>