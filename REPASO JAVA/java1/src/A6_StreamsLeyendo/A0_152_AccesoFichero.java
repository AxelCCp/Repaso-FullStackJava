package A6_StreamsLeyendo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class A0_152_AccesoFichero {
	public static void main(String[]args) {
		LeerFichero accediendo = new LeerFichero();
		accediendo.lee();
	}
}

class LeerFichero {
	public void lee() {
		try {
			entrada = new FileReader("C:/Users/Boo/Downloads/STREAMS.txt");
			int c = entrada.read();
			while(c!=-1) {
			//el método read devuelve -1 cuando llega al final.
				c=entrada.read(); //guarda en c el caracter que esté evaluando a cada momento de while.
				char letra = (char)c;
				System.out.print(letra);
			}
		} catch (IOException e) {
			System.out.println("No se encontró el archivo");
			e.printStackTrace();
		}
	}
	FileReader entrada;
}