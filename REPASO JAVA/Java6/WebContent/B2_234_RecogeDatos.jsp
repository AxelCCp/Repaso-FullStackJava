<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 
<!--CON ESTA INSTRUCCIÓN  PODEMOS ELIMINAR TODAS LAS java.sql. ..."--> 
<!--<%@page import="java.sql.*" %> -->
<%
	// RECOGEMOS CON EL OBJ REQUEST,  TODA  LA INFORMACIÓN QUE VIENE EN EL FORMULARIO 
	String nombre = request.getParameter("nombre");
	String apellido = request.getParameter("apellido");
	String usuario = request.getParameter("usuario");
	String contra = request.getParameter("contra");
	String pais = request.getParameter("pais");
	String tecno = request.getParameter("tecnologias");
	
	//EN JSP TENEMOS QUE INDICARLE QUE CARGUE EL DRIVER
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	try{
	
	//CREAMOS LA CONEXIÓN CON LA BASE DE DATOS:                           
	java.sql.Connection miConexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectos_jsp","root","");
	
	//CREAMOS STATEMENT 
	java.sql.Statement miStatement = miConexion.createStatement();
	
	//INSTRUCCIÓN SQL QUE LLEVA LOS  DATOS DESDE ESTE ARCHIVO JSP A LA BASE DE DATOS. LOS VALORES SE ALMACENAN EN VALUES(.....)
	String instruccionSql="INSERT INTO USUARIOS(Nombre, Apellido, Usuario, Contraseña, Pais, Tecnologia) VALUES ('"+nombre+"','"+apellido+"','"+usuario+"','"+contra+"','"+pais+"','"+tecno+"')";
	
	//
	miStatement.executeUpdate(instruccionSql);
	//
	out.println("Registrado con éxito");
	
	}catch(Exception e){
		out.println("Ha habido un error");
	}
%>

</body>
</html>