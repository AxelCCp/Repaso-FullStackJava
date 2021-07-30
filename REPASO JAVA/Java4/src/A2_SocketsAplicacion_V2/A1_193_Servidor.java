package A2_SocketsAplicacion_V2;

import javax.swing.*;

import A2_SocketsAplicacion_V2.MarcoServidor;
import A2_SocketsAplicacion_V2.PaqueteEnvio;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class A1_193_Servidor  {

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
		
		try {
			ServerSocket servidor = new ServerSocket(9999);
			//PARA ALMACENAR LA INFORMACI�N DEL PAQUETE "DATOS" QUE LLEGA DESDE EL CLIENTE.
			String nick,ip,mensaje;
			//CREAMOS UNA INSTANCIA DE LA CLASE PaqueteEnvio, PARA PODER RECONSTRUIR EL OBJ "DATOS". 
			PaqueteEnvio paqueteRecibido;
			
			while(true) {
			Socket miSocket = servidor.accept();
			//CREAMOS EL FLUJO DE ENTRADA, Y POR PAR�METRO, LE INDICAMOS POR CUAL SOCKET VIAJA LA...
			//...INFORMACI�N DE ENTRADA. PARA ESTO USAMOS GETINPUTSTREAM()
			ObjectInputStream paqueteDatos = new ObjectInputStream(miSocket.getInputStream());
			//ALMACENAMOS LA INFORMACI�N QUE VIENE EN EL FLUJO DE ENTRADA paqueteDatos
			paqueteRecibido = (PaqueteEnvio) paqueteDatos.readObject();
			//EXTRAEMOS INFORMACI�N DE pqueteRecibido
			nick = paqueteRecibido.getNick();
			ip = paqueteRecibido.getIp();
			mensaje = paqueteRecibido.getMensaje(); 
			//AGREGAMOS LA INFORMACI�N EXTRA�DA AL areaTexto
			areatexto.append("\nNick: "+nick);
			areatexto.append("\nIP: "+ip);
			areatexto.append("\nMensaje: "+mensaje);
			
			//CREAMOS PUENTE PARA REENVIAR LA INFORMACI�N CONTENIDA EN "paqueteRecibido", AL CLIENTE...
			//...DE DESTINO(ip DE DESTINO, PUERTO DESTINO)
			Socket enviaDestinatario = new Socket(ip,9090);
			//CREAMOS FLUJO DE SALIDA Y POR PAR�METRO ESPECIFICAMOS EL SOCKET POR EL CUAL VIAJA
			ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
			//ESCRIBIMOS LA INFORMACI�N DE "paqueteRecibido" EN EL FLUJO DE SALIDA "paqueteReenvio"
			paqueteReenvio.writeObject(paqueteRecibido);
			//CERRAMOS CONEXI�N DE SOCKETS
			paqueteReenvio.close();
			enviaDestinatario.close();
			miSocket.close();
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private	JTextArea areatexto;
}
