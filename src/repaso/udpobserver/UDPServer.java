package repaso.udpobserver;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

public class UDPServer implements Runnable {
	/***********************************
	 * Patrón Observer 
	 * @author jdueñas
	 */
	public interface LectorUDP {
		public void llegaronDatos(String dat0);
	}
	
	private ArrayList<LectorUDP> lectores;
	
	public void addLector(LectorUDP lector) {
		// Añadir a lectores
		lectores.add(lector);
	}
	
	private void notificarLectoresNuevoDato(String dato) {
		for(LectorUDP l : lectores) {
			l.llegaronDatos(dato);
		}
	}
	/***********************************
	 * Fin Patrón Observer 
	 */
	
	// Código UDPServer
	int port;
	private static final int MAX_LENGTH = 65535;
	public UDPServer(int port) {
		this.port = port;
		lectores = new ArrayList<LectorUDP>();
	}

	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(port);
			byte [] buffer = new byte[MAX_LENGTH];
			while(true) {
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);// Aquí se queda bloqueado.
				String dato = new String(packet.getData(),0,packet.getLength());
				notificarLectoresNuevoDato(dato);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
