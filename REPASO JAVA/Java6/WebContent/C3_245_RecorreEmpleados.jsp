<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!-- IMPORTAMOS LAS TAGS LIBRARIES --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- IMPORTAMOS PAQUETES QUE VAMOS A USAR -->
<%@ page import="java.util.*, java.sql.*, JSPtags.A0_243_Empleado" %>

<!-- CONSTRUIMOS LOS SCRIPTLETS -->
<% 
	ArrayList<A0_243_Empleado>datos = new ArrayList<>();
		
	//ESPECIFICAMOS RUTA DEL DRIVER PARA QUE LO ENCUENTRE
	Class.forName("com.mysql.cj.jdbc.Driver");
	try{
		
		Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectos_jsp","root","");
		
		Statement miStatement = miConexion.createStatement();
		
		String instruccionSql = "SELECT * FROM EMPLEADOS";
		
		ResultSet rs = miStatement.executeQuery(instruccionSql);
		
		//LA TABLA EMPLEADOS TIENE 4 COLUMAS Y SE LAS PASAMOS POR PARÁMETRO
		while(rs.next()){
			datos.add(new A0_243_Empleado(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDouble(4)));
		}
		
		rs.close();
		miConexion.close();
	}catch(Exception e){
		out.println("Ha habido un error");
	}
	
	pageContext.setAttribute("losEmpleados", datos);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.cabecera{
		font-weight:bold;
	}
</style>
</head>
<body>

<!-- USAMOS C:CHOOSE -->

<table border="1">
	<tr class="cabecera"><td>Nombre</td><td>Apellido</td><td>Puesto</td><td>Salario</td></tr>
		<c:forEach var="EmpTemp" items="${losEmpleados}" >
			<tr>
				<td>${EmpTemp.nombre}</td><td>${EmpTemp.apellido}</td><td>${EmpTemp.puesto}</td>
					<td>
						<c:choose>
							<c:when test="${EmpTemp.salario<80000}">${EmpTemp.salario + 6000}</c:when>
							<c:otherwise>${EmpTemp.salario}</c:otherwise>
						</c:choose>
					</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>