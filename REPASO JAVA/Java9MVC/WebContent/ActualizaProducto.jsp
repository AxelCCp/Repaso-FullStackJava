<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de registro</title>
</head>
<body>
	
	<h1 style="text-align:center">Actualizar producto</h1>
	<form name="form1" method="get" action="ControladorProductos">
	<!-- -LA INFORMACI�N DE HIDDEN SE MANDAR� AL CONTROLADOR JUNTO CON LOS DATOS DEL FORMULARIO. 
	...LO MANDAMOS CON VALOR actualizarBBDD, PARA USAR UN IF EN EL CONTROLADOR, Y AS� SABER QUE HAY QUE ACTUALIZAR -->
	<input type="hidden" name="instruccion" value="actualizarBBDD">
	
	<!-- ENVIAMOS AL CONTROLADOR EL C�DIGO DEL ART�CULO. JUNTO CON LA INFORMACI�N DEL FORMULARIO, PARA MANDARLA
	 ...DESPUES AL MODELO, CLASE QUE HAR� LA ACTUALIZACI�N. USAMOS NOMBRE DE VARIABLE DE CLASS PRODUCTOS "cArt"  -->
	<input type="hidden" name="CArt" value="${ProductoActualizar.cArt}">
		
        <table width="50%" border="0">
           <!--<tr>
                <td width="27%">C�digo art�culo</td>
                <td width="73%"><label for="CArt"></label>
                <input type="text" name="CArt" id="CArt"></td>
            </tr> -->
            <tr>
                <td>Secci�n</td>
                <td><label for="seccion"></label>
                <input type="text" name="seccion" id="seccion" value="${ProductoActualizar.seccion}"></td>
            </tr>
            <tr>
                <td>Nombre art�culo</td>
                <td><label for="NArt"></label>
                <input type="text" name="NArt" id="NArt" value="${ProductoActualizar.nArt}"></td>
            </tr>
            <tr>
                <td>Fecha</td>
                <td><label for="fecha"></label>
                <input type="text" name="fecha" id="fecha" value="${ProductoActualizar.fecha}"></td>
            </tr>
            <tr>
                <td>Precio</td>
                <td><label for="precio"></label>
                <input type="text" name="precio" id="precio" value="${ProductoActualizar.precio}"></td>
            </tr>
            <tr>
                <td>Importado</td>
                <td><label for="importado"></label>
                <input type="text" name="importado" id="importado" value="${ProductoActualizar.importado}"></td>
            </tr>
            <tr>
                <td>Pa�s de origen</td>
                <td><label for="POrig"></label>
                <input type="text" name="POrig" id="POrig" value="${ProductoActualizar.pOrig}"></td>
                
            </tr>
            </br></br>
            <tr>
             	
                <td> <input type="submit" name="envio" id="envio" value="Enviar"></td>
                <td> <input type="reset" name="borrar" id="borrar" value="Restablecer"></td>
            </tr>
		</table>
		
	</form>
	

</body>
</html>