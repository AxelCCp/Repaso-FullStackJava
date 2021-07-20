package A1_POO;

public class A6_40_Furgoneta extends A0_28_Coche {
	
	//CARACTERÍSTICAS PROPIAS DE LA FURGONETA
	private int capacidadCarga;
	private int plazasExtra;
	
	
	public A6_40_Furgoneta(int plazasExtra, int capacidadCarga) {
		super();
		this.capacidadCarga=capacidadCarga;
		this.plazasExtra=plazasExtra;
	}
	
	
	public String getDatosFurgoneta() {
		return "La capacidad de Carga es: " + capacidadCarga + " Y las plazas son: " + plazasExtra;
		
	}
	
	
	

}
