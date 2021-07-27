package A8_leyendoYescribiendoBytes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class A0_155_LecturaEscrituraBytes {
	public static void main(String[]xxx) {
		int contadorBytes=0;
		int datosEntrada [] = new int[34219];
		
		try {
			FileInputStream archivoLectura = new FileInputStream("C:/Users/Boo/Downloads/1a048b57090001e4082a2f8f18f7bce5.jpg");
			boolean finalArchivo = false;
			while(!finalArchivo) {
				int byteEntrada = archivoLectura.read();
				
				if(byteEntrada!=-1)datosEntrada[contadorBytes]=byteEntrada; //almacena los bytes.
				
				else finalArchivo=true;
				
				System.out.println(datosEntrada[contadorBytes]);
				contadorBytes++;
			}
			System.out.println(contadorBytes);
			archivoLectura.close();
		}catch(IOException e) {
			
		}
		creaFichero(datosEntrada);
	}
	static void creaFichero(int datosNuevoFichero[]) {
		try {
			FileOutputStream ficheroNuevo = new FileOutputStream("C:/Users/Boo/Downloads/copiaImagen.jpg");
			for(int i=0;i<datosNuevoFichero.length;i++) {
				ficheroNuevo.write(datosNuevoFichero[i]);
			}
			ficheroNuevo.close();
		}catch(IOException e) {
			System.out.println("Error al crear el archivo");
			e.printStackTrace();
		}
	}
}
