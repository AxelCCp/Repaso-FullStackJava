package A1_POO;

public class A1_28_UsoCoche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		A0_28_Coche renault = new A0_28_Coche();
		renault.setColor("amarillo");
		renault.setAsientos("no");
		renault.setClimatizador("si");
		renault.setPesoFinal(400);
		
		System.out.println(renault.getDatosGenerales());
		System.out.println("");
		System.out.println(renault.getColor());
		System.out.println(renault.getAsientos());
		System.out.println(renault.getClimatizador());
		System.out.println(renault.getPesoFinal());
		
	}

}
