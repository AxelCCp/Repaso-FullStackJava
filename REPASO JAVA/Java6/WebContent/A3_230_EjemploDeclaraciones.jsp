<html>

<body>

<h1 style="text-aling:center">

Ejemplo declaraciones 

</h1>

<%!
private int resultado;
public int metodoSuma(int num1, int num2){
	resultado=num1+num2;
	return resultado;
}

public int metodoResta(int num1, int num2){
	resultado=num1-num2;
	return resultado;
}

public int metodoMultiplica(int num1, int num2){
	resultado=num1*num2;
	return resultado;
}
%>

EL resultado de la suma es: <%= metodoSuma(7, 5)%>
<br>
EL resultado de la resta es: <%= metodoResta(7, 5)%>
<br>
EL resultado de la multiplicación es: <%= metodoMultiplica(7, 5)%>

</body>


</html>