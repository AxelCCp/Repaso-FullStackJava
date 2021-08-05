<%@ page import="java.util.*" %>
<html>

<body>
<form name="Formulario_Compra" action="B5_237_ListaCompra.jsp">
 
  <p>Art�culos a comprar:</p>
  <p>
    <label>
      <input type="checkbox" name="articulos" value="agua " >
      Agua </label>
    <br>
    <label>
      <input type="checkbox" name="articulos" value="leche" >
      Leche </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="pan" >
      Pan </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="mazanas" >
      Manzanas </label>
    <br>
     <label>
      <input type="checkbox" name="articulos" value="carne" >
      Carne </label>
      <br>
       <label>
      <input type="checkbox" name="articulos" value="pescado" >
      Pescado </label>
  </p>
  <p>
    <input type="submit" name="button" id="button" value="Enviar">
    <br>
  </p>
</form>

<h2>Carro de la compra</h2>

<ul>

<% 

//DECLARAMOS UN ARRAYLIST DE LA COMPRA QUE IR� CRECIENDO ... 
//CON "session.getAttribute("misElementos")", CONSEGUIMOS QUE SE GUARDE EL OBJ QUE SE HAYA IDO GRABANDO PREVIAMENTE EN LA SESI�N.
List<String>listaElementos = (List<String>)session.getAttribute("misElementos");

//ESTABLECEMOS UNA SESION, USAMOS setAttribute(nombreDeSesion, obj que queremos que guarde la sesi�n)
//si(listaElementos==null)cr�ame la sesi�n.
if(listaElementos==null){
	listaElementos= new ArrayList<String>();
	session.setAttribute("misElementos", listaElementos);
}

//ALMACENAMOS EN EL ARRAY LOS ELEMENTOS SELECCIONADOS
String[]elementos = request.getParameterValues("articulos");

if(elementos!=null){
	for(String elemTemp : elementos){
		
		listaElementos.add(elemTemp);
	}
}

for(String elemTemp : listaElementos){
	//<li>PARA HACER UNA LISTA. LA ETIQUETA <li> siempre va dentro de etiquetas <ul> 
	out.println("<li>" + elemTemp + "</li>");	
}
%>
</ul>
</body>

</html>