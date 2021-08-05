<html>
<!-- request: OBJETO PARA OBTENER INFORMACIÓN DEL USUARIO 
"User-Agent": OBTENEMOS LOS DATOS DEL NAVEGADOR
-->
<body>

<h2>
OBJETOS PREDEFINIDOS JSP
</h2>

Petición datos del navegador: <%= request.getHeader("User-Agent") %>

<br><br/>

Petición de idioma utilizado: <%=request.getLocale() %>

</body>

</html>