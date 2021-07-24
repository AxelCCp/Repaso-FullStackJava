package A4_Excepciones;
//EXCEPSIONES PROPIAS
import java.io.EOFException;
import javax.swing.JOptionPane;

//BUCLE FOR.
//COMPROBAR EMAIL. 

public class A2_147_Email {
	public static void main(String[]args) throws ArrayIndexOutOfBoundsException {
		
		String email = JOptionPane.showInputDialog("Ingresa tu email:");
		try {
			examinaEmail(email);
		} catch (LongitudEmailErroneo e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void examinaEmail(String xEmail) throws LongitudEmailErroneo {
		int arroba=0;
		boolean punto=false;
			
		if(xEmail.length()<=3) {
			throw new LongitudEmailErroneo("El mail es muy corto");
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

class LongitudEmailErroneo extends Exception{
	public LongitudEmailErroneo() {
	}
	public LongitudEmailErroneo(String msjError) {
		super(msjError);
	}
}

