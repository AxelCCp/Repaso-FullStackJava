package A7_Controlador;

//DESUÉS DE CONFIGURAR ESTE CÓDIGO, HAY QUE IR A LA CLASE DEL MARCO Y PONERLA A LA ESCUCHA CON addWindowListener().
//LE PASAMOS EL MARCO POR PARÁMETRO CON "this", YA QUE LO PIDE EL CONSTRUCTOR PARA EJECUTAR EL CÓDIGO.
//DE ESTE MODO, CUANDO SE ABRA EL MARCO DE LA APP, SE CARGARÁ EL JCOMBOBOX, GRACIAS A LA CONFIGURACIÓN DE WindowOpened(WindowEvent e) 

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import A5_Modelo.A1_211_CargaMenus;
import A6_Vista.A0_210_MarcoAplicacion;

public class A1_212_ControladorCargaMenus extends WindowAdapter {
	//PARA CARGAR EL JCOMBOBOX DE SECCIONES, NOS TRAEMOS UN OBJ DE LA CLASE DEL MARCO 
	public A1_212_ControladorCargaMenus ( A0_210_MarcoAplicacion elMarco) {
		this.elMarco=elMarco;
	}
	
	//ESTE MÉTODO TIENE QUE EJECUTAR LA CONSULTA SQL
	public void windowOpened(WindowEvent e) {
		
		//LLAMAMOS AL MÉTODO DE EJECUTACONSULTAS(), PARA QUE NOS DEVUELVA LAS SECCIONES:  
		obj.ejecutaConsultas();
		//RECORREMOS LAS SECCIONES Y LAS ALMACENAMOS EN EL JCOMBOBOX. CON "obj", PODEMOS RECORRER EL RESULTSET "rs" DE LA...
		//...CLASE CARGASECCIONES. ESTO SE PUEDE HACER, YA QUE AL LLAMAR AL MÉTODO EJECUTACONSULTAS(), PODEMOS USAR "rs".
		try {
			while(obj.rs.next()) {
				elMarco.secciones.addItem(obj.rs.getString(1));
			}
			
			while(obj.rs2.next()) {
				elMarco.paises.addItem(obj.rs2.getString(1));
			}
		}catch(Exception e2) {
			//e2.printStackTrace();
		}
	}
	A1_211_CargaMenus obj = new A1_211_CargaMenus();
	
	private A0_210_MarcoAplicacion elMarco;
}
