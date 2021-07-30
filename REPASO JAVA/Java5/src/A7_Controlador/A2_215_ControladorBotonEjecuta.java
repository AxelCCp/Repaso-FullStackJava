package A7_Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import A5_Modelo.A2_215_EjecutaConsultas;
import A6_Vista.A0_210_MarcoAplicacion;

public class A2_215_ControladorBotonEjecuta implements ActionListener{

	//LE PASAMOS POR PAR�METRO UN OBJ DE LA CLASE DEL MARCO, PARA QUE PUEDA RECONOCER EL BOT�N
	public A2_215_ControladorBotonEjecuta(A0_210_MarcoAplicacion elmarco) {
		this.elmarco=elmarco;
	}
	
	//DESDE ESTE M�TODO DEBEMOS ACCEDER AL M�TODO EJECUTACONSULTAS DE LA CLASE A2_215_EjecutaConsultas.
	//HAY QUE ALMACENAR LA INFORMACI�N SELECCIONADA DE LOS JCOMBOBOX SECCIONES Y PA�SES.
	//CON LA INSTANCIA "elMarco" PUEDO  USAR LA VARIABLE OBJETO DE secciones Y USAR EL M�TODO getSelectedItem().
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String seleccionSeccion = (String) elmarco.secciones.getSelectedItem();
		String seleccionPaises = (String) elmarco.paises.getSelectedItem();
		
		//AHORA HAY QUE ALMACENAR,RECORRER Y ESCRIBIR EN EL JTEXTAREA LO QUE SE SELECCION� EN LOS JCOMBOBOX
		//ALMACENAR:
		resultadoConsulta=obj.fitraBBDD(seleccionSeccion, seleccionPaises);
		//RECORREMOS LA INFORMACI�N DE LAS 4 COLUMNAS DE LA INSTRUCCI�N SQL:
		try {
			elmarco.resultado.setText("");//CON ESTO RESETEAMOS EL AREA DE TEXTO.
			while(resultadoConsulta.next()) {
				
				elmarco.resultado.append(resultadoConsulta.getString(1));
				elmarco.resultado.append("...");
				elmarco.resultado.append(resultadoConsulta.getString(2));
				elmarco.resultado.append("...");
				elmarco.resultado.append(resultadoConsulta.getString(3));
				elmarco.resultado.append("...");
				elmarco.resultado.append(resultadoConsulta.getString(4));
				elmarco.resultado.append("\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	private A0_210_MarcoAplicacion elmarco;
	private A2_215_EjecutaConsultas obj = new A2_215_EjecutaConsultas();
	private ResultSet resultadoConsulta;

}
