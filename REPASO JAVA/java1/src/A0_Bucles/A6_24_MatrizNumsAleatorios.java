package A0_Bucles;

import javax.swing.JOptionPane;

public class A6_24_MatrizNumsAleatorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int Nelementos = Integer.parseInt(JOptionPane.showInputDialog("Ingresa n° de elementos de la matriz:" ));
		
		int [] aleatorios = new int [Nelementos];
		
		for(int i=0; i<aleatorios.length; i++) {
			aleatorios[i] = (int)Math.round(Math.random()*100);
		}
		
		
		for(int elementos: aleatorios) {
			System.out.print(elementos + "/");
		}

	}

}
