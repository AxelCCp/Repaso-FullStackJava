package A1_POO;

public class A0_28_Coche {
	//CONSTRUCTOR
	public A0_28_Coche() {
		ruedas=4;
		largo=2000;
		ancho=300;
		motor=1600;
		pesoPlataforma=500;
	}
	//CARACTERÍSTICAS COMUNES
	private int ruedas;
	private int largo;
	private int ancho;
	private int motor;
	private int pesoPlataforma;
	//CARACTERÍSTICAS PARTICULARES
	private String color;
	private int pesoTotal;
	private boolean asientosCuero;
	private boolean climatizador;
	//MÉTODO DE DATOS GENERALES
	public String getDatosGenerales() {
		return "La plataforma del vehículo tiene " + ruedas + " ruedas." 
				+ "\nMide " + largo/1000 + " metros."
				+ "\nTiene un ancho de " + ancho + " cm."
				+ "\nY un peso de plataforma de " + pesoPlataforma + " Kg.";
	}
	//GETTERS Y SETTERS
	public void setColor(String colorCoche) {
		color=colorCoche;
	}	
	public String getColor() {
		return "El color del coche es: " + color;
	}
	public void setAsientos(String asientosCuero) {
		if(asientosCuero=="si") this.asientosCuero = true;
		else this.asientosCuero = false;
	}
	public String getAsientos() {
		if(asientosCuero==true)return "El coche tiene Asientos de Cuero";
		else return "El coche NO tiene Asientos de Cuero";
	}
	public void setClimatizador(String climatizador) {
		if(climatizador=="si")this.climatizador=true;
		else this.climatizador=false;
	}
	public String getClimatizador() {
		if(this.climatizador=true) return "El auto tiene climatizador";
		else return "El auto NO tiene climatizador";
	}
	int pesoModelo1;
	public void setPesoFinal(int pesoModelo) {
		this.pesoTotal = pesoModelo + pesoPlataforma;	
		pesoModelo1 = pesoModelo;
	}
	public String getPesoFinal() {
		return "El peso de modelo es: " + pesoModelo1
				+ "\nEl peso total del automovil es: " + pesoTotal;
	}
	
	

}
