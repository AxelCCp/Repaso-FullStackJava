package A0_Sockets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;


public class A0_190_Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoCliente mimarco=new MarcoCliente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){	
		setBounds(600,300,280,350);
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		add(milamina);
		setVisible(true);
	}		
}

class LaminaMarcoCliente extends JPanel{
	
	public LaminaMarcoCliente(){
		JLabel texto=new JLabel("CLIENTE");
		add(texto);
		campo1=new JTextField(20);
		add(campo1);		
		miboton=new JButton("Enviar");
		EnviaTexto evento1 = new EnviaTexto();
		miboton.addActionListener(evento1);
		add(miboton);	
		
	}
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			//System.out.println(campo1.getText());
			
			//LE DECIMOS AL  CLIENTE QUE TIENE QUE COMUNICAR CON UNA DIRECCIÓN IP Y A TRAVÉS DE UN PUERTO
			//(DIRECCIÓN IP DEL SERVIDOR, EN ESTE CASO LA DEL PC,PUERTO) 
			try {
				Socket miSocket = new Socket("192.168.0.4",9999);
				//CREAMOS FLUJO DE SALIDA LE INDICAMOS POR DÓNDE VA A CIRCULAR. VA A CIRCULAR POR miSocket...
				//..Y USAMOS getOutputStream()
				DataOutputStream flujoSalida = new 	DataOutputStream(miSocket.getOutputStream());
				//INDICAMOS AL FLUJO DE SALIDA, QUÉ ES LO QUE VA A CIRCULAR DE SALIDA. ESCRIBE EN EL FLUJO DE..
				//..SALIDA LO QUE ESTÁ ESCRITO EN EL JTextField Campo1.
				flujoSalida.writeUTF(campo1.getText());
				flujoSalida.close();
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}
	

	private JTextField campo1;
	private JButton miboton;	
}