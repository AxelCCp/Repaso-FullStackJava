package A0_Bucles;

import javax.swing.JOptionPane;

//BUCLE FOR.
//COMPROBAR EMAIL. 

public class A1_21_BucleFor {
	public static void main(String[]args) {
		
		/*
		for(int i=10;i>0;i-=2) {
			System.out.println(i);
		}
		*/
		
		/*
		boolean arroba = false;  
		String email = JOptionPane.showInputDialog("Ingresa tu Email:");
		//System.out.println("La longitud de tu email es: " + email.length());
		
		for(int i=0; i<email.length(); i++) {
			if(email.charAt(i)=='@') {
				arroba=true;
			}
		}
		if(arroba==true) System.out.println("Email correcto");
		else if(arroba==false ) System.out.println("Email Incorrecto");
		*/
		
		int arroba=0;
		boolean punto=false;
		String email = JOptionPane.showInputDialog("Ingresa tu email:");
		for(int i=0; i<email.length(); i++) {
			if(email.charAt(i)=='@') {
				arroba++;
			}
			
			if(email.charAt(i)=='.') {
				punto=true;
			}
		}
		
		if(arroba==1 && punto==true)System.out.println("Email Correcto");
		else System.out.println("Email incorrecto");
		
		
	}
}
