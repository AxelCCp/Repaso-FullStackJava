package A1_SocketsAplicacion_V1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;


public class A0_192_Cliente {

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
		nick = new JTextField(5);
		add(nick);
		JLabel texto=new JLabel("-CHAT-");
		add(texto);
		ip = new JTextField(8);
		add(ip);
		campoChat = new JTextArea(12,20);
		add(campoChat);
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
			
			
			try {
				Socket miSocket = new Socket("192.168.0.4",9999);
				
				PaqueteEnvio datos = new PaqueteEnvio();
				datos.setNick(nick.getText());
				datos.setIp(ip.getText());
				datos.setMensaje(campo1.getText());
				
				//PARA MANDAR EL OBJETO "DATOS" CREAMOS FLUJO DE SALIDA
				ObjectOutputStream paqueteDatos = new ObjectOutputStream(miSocket.getOutputStream()); 
				//LE DECIMOS QUE ESCRIBA EL OBJ "DATOS" EN EL FLUJO DE SALIDA "PAQUETEDATOS" 
				paqueteDatos.writeObject(datos);
				miSocket.close();
				
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
	
	private JTextField campo1,nick,ip;
	private JButton miboton;	
	private JTextArea campoChat;
}



//IMPLENTAMOS LA INTERFAZ SERIALIZABLE, YA QUE PARA MANDAR EL OBJ "DATOS" AL SERVIDOR, HAY QUE...
//..SERIALIZAR EL OBJ DATOS, CONVIRTI?NDOLO EN BYTES. 
class PaqueteEnvio implements Serializable{
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	private String nick,ip,mensaje;
}