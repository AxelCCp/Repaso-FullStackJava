package B2_AplicacionFinal_V1;

//CÓDIGO ORIGINAL DEL PROFESOR 
import java.awt.*;
import javax.swing.*;

public class A0_224_AplicacionUniversal_V1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoBBDD mimarco=new MarcoBBDD();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class MarcoBBDD extends JFrame{

	public MarcoBBDD(){
		
		setBounds(300,300,700,700);
		
		LaminaBBDD milamina=new LaminaBBDD();
		
		add(milamina);
		
	}	
	
}

class LaminaBBDD extends JPanel{
	
	public LaminaBBDD(){
		
		setLayout(new BorderLayout());
		
		comboTablas=new JComboBox();
		
		areaInformacion=new JTextArea();
		
		add(areaInformacion,BorderLayout.CENTER);		
		
		add(comboTablas, BorderLayout.NORTH);
		
		
		
		}
	
	
	

	
	private JComboBox comboTablas;

	private JTextArea areaInformacion;
	
	
	
}

