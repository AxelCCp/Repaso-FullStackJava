package A4_Excepciones;

import javax.swing.JOptionPane;

public class A3__148_VariasExcepciones {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			division();
		}catch(ArithmeticException e) {
			System.out.println("estas dividiendo por 0");
		}catch(NumberFormatException e) {
			System.out.println("no haz introducido un número entero");
			System.out.println(e.getMessage());
			System.out.println("Se ha generado un error de este tipo: " + e.getClass().getName());
		}
	}

	static void division() {
		int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un 1er num: "));
		int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un 2do num: "));
		System.out.println("la división de num1/num2 es: " + num1/num2 );
	}	
}
