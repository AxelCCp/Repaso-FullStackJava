package A1_POO;

public class A7_40_UsoVehiculo {
	
	public static void main(String[]args) {
		
		A0_28_Coche coche1 = new A0_28_Coche();
		coche1.setColor("Verde");
		
		A6_40_Furgoneta furgoneta1 = new A6_40_Furgoneta(10,500);
		furgoneta1.setColor("Negro");
		furgoneta1.setAsientos("si");
		furgoneta1.setClimatizador("si");
		
		System.out.println(furgoneta1.getDatosFurgoneta());
		System.out.println(furgoneta1.getDatosGenerales());
		
		System.out.println("-------------");
		System.out.println(coche1.getDatosGenerales());
		System.out.println(coche1.getColor());	
	}
}
