package A4_Excepciones;

import java.io.EOFException;

import javax.swing.JOptionPane;

//BUCLE FOR.
//COMPROBAR EMAIL. 

public class A1_146_Email {
	public static void main(String[]args) throws ArrayIndexOutOfBoundsException {
		
		String email = JOptionPane.showInputDialog("Ingresa tu email:");
		
		try {
			examinaEmail(email);
		}catch(EOFException e) {
			System.out.println("Email incorrecto.............");
		}
	
	}
	
	static void examinaEmail(String xEmail) throws EOFException {
		int arroba=0;
		boolean punto=false;
			
		if(xEmail.length()<=3) {
			//LANZAMOS MANUALMENTE UN ERROR DE ESTE TIPO
			throw new EOFException();
			
		}else {
			for(int i=0; i<xEmail.length(); i++) {
				if(xEmail.charAt(i)=='@') {
					arroba++;
				}
				if(xEmail.charAt(i)=='.') {
					punto=true;
				}
			}
			if(arroba==1 && punto==true)System.out.println("Email Correcto");
			else System.out.println("Email incorrecto");
		}
	}
}
