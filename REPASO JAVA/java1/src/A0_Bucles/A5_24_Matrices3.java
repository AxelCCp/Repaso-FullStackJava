package A0_Bucles;

import javax.swing.JOptionPane;

public class A5_24_Matrices3 {
	public static void main(String[]args) {
		String[]paises = new String[8];
		
		for(int i=0; i<paises.length;i++) {
			paises[i] = JOptionPane.showInputDialog("Ingresa el país " + (i+1) + ": ");
		}
		
		int x = 0;
		for(String elementos: paises) {
			x++;
			System.out.println("País " + x + " " + elementos);
		}
		
		
	}

}
