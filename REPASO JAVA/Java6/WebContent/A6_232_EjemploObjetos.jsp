<html>
<!-- request: OBJETO PARA OBTENER INFORMACI�N DEL USUARIO 
"User-Agent": OBTENEMOS LOS DATOS DEL NAVEGADOR
-->
<body>

<h2>
OBJETOS PREDEFINIDOS JSP
</h2>

Petici�n datos del navegador: <%= request.getHeader("User-Agent") %>

<br><br/>

Petici�n de idioma utilizado: <%=request.getLocale() %>

</body>

</html>