<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@page import="java.sql.*" %>
<%
	// RECOGEMOS CON EL OBJ REQUEST,  TODA  LA INFORMACIÓN QUE VIENE EN EL FORMULARIO 
	String usuario = request.getParameter("usuario");
	String contra = request.getParameter("contra");
	
	//EN JSP TENEMOS QUE INDICARLE QUE CARGUE EL DRIVER
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	try{
	
	//CREAMOS LA CONEXIÓN CON LA BASE DE DATOS:                           
	Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectos_jsp","root","");
	
	//CREAMOS CONSULTA PREPARADA
	PreparedStatement cPreparada = miConexion.prepareStatement("SELECT * FROM USUARIOS WHERE USUARIO=? AND CONTRASEÑA=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
	
	//INDICAMOS LOS VALORES QUE SE DEBEN ALMACENAR EN EL 1ER Y 2DO PARÁMETRO
	cPreparada.setString(1, usuario);
	cPreparada.setString(2, contra);
	
	//EJECUTAR CONSULTA Y ALMACENARLA EN EL RESULTSET
	ResultSet miResultSet = cPreparada.executeQuery();
	
	//ABSOLUTE(): DEVUELVE UN BOOLEAN. DEVUELVE TRUE SI HAY INFO Y FALSE SI NO HAY INFORMACIÓN.
	//CON 1 LE INDICAMOS QUE SE VAYA AL 1ER REGISTRO.
	if(miResultSet.absolute(1)) out.println("Usuario Autorizado");
	else out.println("No hay usuarios con esos datos");
	
	}catch(Exception e){
		out.println("Ha habido un error");
		e.printStackTrace();
	}
%>

</body>
</html>