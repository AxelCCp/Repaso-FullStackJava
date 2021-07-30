package A5_Modelo;

//EL MODELO VISTA CONTROLADOR PIDE ENCAPSULAR LOS DATOS REFERENTES A LA BASE DE DATOS,...
//...POR MOTIVOS DE SEGURIDAD.

//DECLARAMOS, ENCAPSULAMOS, Y DESARROLLAMOS GET Y SET, DE LOS CAMPOS QUE NOS VA A MOSTRAR LA TABLA. 


public class A0_211_Productos {
	
	
	public A0_211_Productos() {
		nArticulo="";
		seccion="";
		precio="";
		pOrigen="";
	}
	
	public String getnArticulo() {
		return nArticulo;
	}
	public void setnArticulo(String nArticulo) {
		this.nArticulo = nArticulo;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getpOrigen() {
		return pOrigen;
	}
	public void setpOrigen(String pOrigen) {
		this.pOrigen = pOrigen;
	}


	private String nArticulo;
	private String seccion;
	private String precio;
	private String pOrigen;

}
