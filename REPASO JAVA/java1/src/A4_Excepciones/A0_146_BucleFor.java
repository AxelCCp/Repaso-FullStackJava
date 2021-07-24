package A4_Excepciones;

import javax.swing.JOptionPane;

//BUCLE FOR.
//COMPROBAR EMAIL. 

public class A0_146_BucleFor {
	public static void main(String[]args) throws ArrayIndexOutOfBoundsException {
		
		int arroba=0;
		boolean punto=false;
		
		String email = JOptionPane.showInputDialog("Ingresa tu email:");
		if(email.length()<=3) {
			//LANZAMOS MANUALMENTE UN ERROR DE ESTE TIPO
			//ArrayIndexOutOfBoundsException e = new ArrayIndexOutOfBoundsException(); 
			//throw e;
			throw new ArrayIndexOutOfBoundsException();
			
		}else {
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
}
