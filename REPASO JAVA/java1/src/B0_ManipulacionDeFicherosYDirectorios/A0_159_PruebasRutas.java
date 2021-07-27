package B0_ManipulacionDeFicherosYDirectorios;

import java.io.File;

public class A0_159_PruebasRutas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SINO LE PONEMOS UN RUTA, GUARDARÁ EL ARCHIVO EN LA CARPETA DEL PROYECTO
		File archivo = new File("ejemploArchivo");
		//IMPRIME LA RUTA ABSOLUTA DEL ARCHIVO
		System.out.println(archivo.getAbsolutePath());
		//VEMOS Y SI EL ARCHIVO EXISTE O NO
		System.out.println(archivo.exists());
	}
}
