package A0_JList_SwingAvanzado;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class A0_265_JList {
	public static void main(String[]args){
		
		JFrame marco1 = new MarcoDeLista();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.setVisible(true);	
	}
}



class MarcoDeLista extends JFrame{
	public MarcoDeLista() {
		setTitle("Prueba de lista");
		setBounds(400,300,400,300);
		String [] meses = {"ENERO","FEBRERO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO",
							"SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
		
		listaDeMeses = new JList<String>(meses);
		//CANTIDAD DE ELEMENTOS QUE SE DEBEN VER POR DEFECTO (4)
		listaDeMeses.setVisibleRowCount(4);
		
		JScrollPane laminaDesplazamiento = new JScrollPane(listaDeMeses);
		
		laminaDeLista = new JPanel();
		laminaDeLista.add(laminaDesplazamiento);
		
		listaDeMeses.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				List<String> valores = listaDeMeses.getSelectedValuesList();
				StringBuilder texto = new StringBuilder("Mes seleccionado: ");
				for(String elem : valores) {
					String palabra = elem;
					texto.append(palabra);
					texto.append(" ");
				}
				//AL ROTULO LE ESTABLECEMOS COMO TEXTO EL OBJ StringBuilder
				rotulo.setText(texto.toString());
			}
		});
		
		laminaDeTexto = new JPanel();
		rotulo= new JLabel("Mes seleccionado:");
		laminaDeTexto.add(rotulo);
		add(laminaDeLista,BorderLayout.NORTH);
		add(laminaDeTexto,BorderLayout.SOUTH);
	}
	private JList <String> listaDeMeses;
	private JPanel laminaDeLista,laminaDeTexto;
	private JLabel rotulo;
}