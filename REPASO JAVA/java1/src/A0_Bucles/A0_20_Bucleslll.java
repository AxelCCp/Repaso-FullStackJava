package A0_Bucles;

import javax.swing.JOptionPane;

public class A0_20_Bucleslll {
	public static void main(String [] args) {
		
		String genero="";
		do {
			genero = JOptionPane.showInputDialog("¿Cuál es tu Genero? M:masculino / F:femenino");
		}while(genero.equalsIgnoreCase("M") == false && genero.equalsIgnoreCase("F")==false);
		
		int altura = Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu Altura"));
		int pesoIdeal;
		System.out.println(genero);
		System.out.println(altura);
		
		if(genero.equalsIgnoreCase("m")){
			pesoIdeal = altura - 110;
			System.out.println("M: tu peso ideal es: " + pesoIdeal);
		}
		else if(genero.equalsIgnoreCase("f")) {
			pesoIdeal = altura -120;
			System.out.println("F: tu peso ideal es: " + pesoIdeal);
		}
	}

}
