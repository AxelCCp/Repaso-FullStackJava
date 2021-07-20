package A0_Bucles;

import javax.swing.JOptionPane;

public class A2_22_FactorialBucle {
	public static void main(String[]args) {
		long resultado=1L;
		int numero = Integer.parseInt(JOptionPane.showInputDialog("ingresa un número:"));
		for(int i=numero; i>0; i--) {
			resultado= resultado*i;
		}
		System.out.println("el Factorial de " + numero + ": " + resultado);
	}
}


