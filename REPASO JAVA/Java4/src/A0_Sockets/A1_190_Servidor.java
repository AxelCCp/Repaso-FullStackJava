package A0_Sockets;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class A1_190_Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoServidor mimarco=new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}


//PARA HACER QUE EL MARCO EST� SIEMPRE A LA ESCUCHA, USAMOS RUNNABLE
class MarcoServidor extends JFrame implements Runnable  {
	
	public MarcoServidor(){
		setBounds(900,300,280,350);				
		JPanel milamina= new JPanel();
		milamina.setLayout(new BorderLayout());
		areatexto=new JTextArea();
		milamina.add(areatexto,BorderLayout.CENTER);
		add(milamina);
		setVisible(true);
		//CREAMOS HILO
		Thread miHilo = new Thread(this);
		miHilo.start();
	}
	
	//EL C�DIGO QUE ESTAR� A LA ESCUCHA VA DENTRO DE RUN() 
	//ABRIMOS PUERTO 999 Y QUE EST� A LA ESCUCHA
	@Override
	public void run() {
		//System.out.println("A la escucha");
		//USAMOS CLASE SERVERSOCKET, UN CONSTRUCTOR DE ESTA CLASE CREA UN SERVIDOR DE SOCKET...
		//..ABIERTO Y RECIVE UN ARGUMENTO INT CON EL N� DE PUERTO.
		//USAMOS METODO ACCEPT() DE SERVERSOCKET, QUE DEVUELVE UN OBJ SOCKET, PERMANECE A LA...
		//..ESCUCHA Y ACEPTA LA CONEXI�N.
		try {
			ServerSocket servidor = new ServerSocket(9999);
			//BUCLE INFINITO PARA QUE SE PUEDA ENVIAR M�S DE UN MENSAJE, CON WHILE, DESPU�S...
			//DE LLEGAR A miSocket.close(); EL PROGRAMA VOLVER� EL INICIO DEL WHILE.
			while(true) {
			Socket miSocket = servidor.accept();
			//CREAMOS EL FLUJO DE ENTRADA, Y POR PAR�METRO, LE INDICAMOS POR CUAL SOCKET VIAJA LA...
			//INFORMACI�N DE ENTRADA. PARA ESTO USAMOS GETINPUTSTREAM()
			DataInputStream flujoEntrada = new DataInputStream(miSocket.getInputStream());
			//ALMACENAMOS EN UN STRING LA INFORMACI�N QUE VIENE EN EL FLUJO DE ENTRADA
			String mensajeTxt = flujoEntrada.readUTF();
			//ESCRIBIMOS EN �REA DE TEXTO
			areatexto.append("\n" + mensajeTxt);
			//CERRAMOS CONEXI�N
			miSocket.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private	JTextArea areatexto;
}
