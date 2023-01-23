package ut03comunicaciones.comm;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HolaServer {
	public static final String MENSAJE_FIN = "adios";

	public static void main(String[] args) {
		ServerSocket server;
		int port = Integer.parseInt(args[0]);
		String msg = args[1]+"\n";
		
		try {
			server = new ServerSocket(port);
			System.out.println("Escuchando en puerto: " + port);
			
			while(true) {
				//Bloqueo para aceptar peticiones
				Socket connCliente = server.accept();
				System.out.println("Comienzo thread");
				
				new Thread(()->{
					atenderPeticion(connCliente, msg);
				}).start();
				
				System.out.println("Escucho otro cliente");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void atenderPeticion(Socket connCliente, String msg) {
		try {
			System.out.println("Se conectó un cliente: " + connCliente.getInetAddress());
			
			/*Genero los dos Streams de entrada/salida*/
			DataOutputStream outTCP = new DataOutputStream  (
					connCliente.getOutputStream()
				);
			DataInputStream inTCP = new DataInputStream(
					connCliente.getInputStream()
				);
			
			// Escribir bienvenida
			outTCP.writeUTF(msg);
			outTCP.flush();
			
			/*Leer el mensaje que nos manda y escribirlo por pantalla*/
			
			String msgDeCliente;
			
			do {
				msgDeCliente = inTCP.readUTF();
				outTCP.writeUTF(msgDeCliente.toUpperCase());
			}while(!msgDeCliente.equalsIgnoreCase(MENSAJE_FIN));
			
			System.out.println("Cliente cierra conexión");
			
			inTCP.close();
			outTCP.close();
			connCliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
