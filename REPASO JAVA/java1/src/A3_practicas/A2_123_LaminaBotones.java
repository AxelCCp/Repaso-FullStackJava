package A3_practicas;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class A2_123_LaminaBotones extends JPanel {
	public A2_123_LaminaBotones(String titulo, String[]opciones) {
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),titulo)); //ESTABLECEMOS TIPO DE BORDES
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); //ESTABLECEMOS DISPOSICI?N DE LAMINA, VER LA API.
		grupo = new ButtonGroup();
		for(int i=0;i<opciones.length;i++) {
			JRadioButton bot = new JRadioButton(opciones[i]);
			bot.setActionCommand(opciones[i]); //ESTABLECE LA ACCI?N DE COMANDO PARA EL BOT?N.ES UN M?TODO QUE JRADIOBUTTON HEREDA DE ABSTRACTBUTTON.	
		    add(bot);
		    grupo.add(bot);
		    bot.setSelected(i==0);//POR DEFECTO APARECER? LA 1RA OPCI?N
		}
	}
	//METODO
	public String dameSeleccion() {
		ButtonModel miBoton = grupo.getSelection();
		String x =miBoton.getActionCommand();
		return x;
	}
	
	private ButtonGroup grupo;
}
