<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 style="text-align:center">Agencia de viajes</h1>

<%
	//VALOR POR DEFECTO
	String ciudad_favorita="Madrid";

	//LEE LA COOKIE DE LA PETICIÓN DEL NAVEGADOR
	//ALMACENAMOS EN EL ARRAY LAS COOKIES QUE PUEDAN HABER EN EL ORDENADOR DEL USUARIO
	Cookie[]lasCookies = request.getCookies();
	
	//BUSCAR LAS PREFERENCIAS. (LA CIUDAD FAVORITA)
	if(lasCookies != null){
		for(Cookie cookie_temporal : lasCookies){
			//BUSCA COINCIDENCIA DE COOKIE
			if("agencia_viajes.ciudad_favorita".equals(cookie_temporal.getName())){
				//NOS DEVUELVE EL VALOR
				ciudad_favorita = cookie_temporal.getValue();
				//PARA SALIR EL BUCLE
				break;
			}
		}
	}
%>

<h3> Vuelos a <%= ciudad_favorita %> </h3>

<p> Esto es un texto de ejemplo </p>
<p> Esto es un texto de ejemplo </p>
<p> Esto es un texto de ejemplo </p>
<p> Esto es un texto de ejemplo </p>

<h3> Hoteles en <%= ciudad_favorita %> </h3>

<p> Esto es un texto de ejemplo </p>
<p> Esto es un texto de ejemplo </p>
<p> Esto es un texto de ejemplo </p>
<p> Esto es un texto de ejemplo </p>

<h3> Restaurantes en <%= ciudad_favorita %> </h3>

<p> Esto es un texto de ejemplo </p>
<p> Esto es un texto de ejemplo </p>
<p> Esto es un texto de ejemplo </p>
<p> Esto es un texto de ejemplo </p>

</body>
</html>