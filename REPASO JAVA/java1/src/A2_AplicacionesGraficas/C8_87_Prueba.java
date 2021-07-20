package A2_AplicacionesGraficas;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class C8_87_Prueba {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoPrueba marco1 = new MarcoPrueba();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class MarcoPrueba extends JFrame{
	public MarcoPrueba() {
		setBounds(500,300,500,350);
		LaminaPrueba lamina1 = new LaminaPrueba();
		add(lamina1);
		setVisible(true);
	}
}

class LaminaPrueba extends JPanel{
	public LaminaPrueba() {
		JTextField campo1 = new JTextField(20);
		add(campo1);
		//CREAMOS UNA VARIABLE Document, PARA ALMACENAR LO QUE SE PONE EN CAMPO1
		Document documento1 = campo1.getDocument();
		EscuchaTexto evento1 = new EscuchaTexto();
		documento1.addDocumentListener(evento1);
	}
	private class EscuchaTexto implements DocumentListener{
		@Override
		public void changedUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub	
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("haz insertado texto");
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("haz borrado texto");
		}
	}
}