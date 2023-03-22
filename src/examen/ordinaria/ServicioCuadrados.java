package examen.ordinaria;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ServicioCuadrados {

	private static final int NUM_PARAMS = 2;
	private static final String FIN = "fin";
	private static final int BUFFER_SIZE = 65535;
	private static final String CARACTER_SEPARADOR = " ";
	private static final String BROADCAST = "255.255.255.255";
	
	static int pReceive;
	static int pSend;
	
	public static void main(String[] args) {
		// Procesar los parámetros de inicio
		if(args.length != NUM_PARAMS) {
			System.err.println("Error en número de parámetros");
			return;
		}
		
		try {
			pReceive = Integer.parseInt(args[0]);
			pSend 	 = Integer.parseInt(args[1]);
		}catch(Exception e) {
			System.err.println("Error en parámetros");
			System.err.println(e);
			return;
		}
		
		try {
			DatagramSocket receiver = new DatagramSocket(pReceive);
			String comando = "";
			// Mientras queden datos
			while(!comando.equalsIgnoreCase(FIN)) {
				// Procesar datos
				comando = recibeInfo(receiver);
				String cuadrado = generaCuadrado(comando);
				System.out.println(cuadrado);
				enviaInfo(cuadrado , pSend);
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}

	private static void enviaInfo(String info, int port) {
		byte[] buffer = info.getBytes();
		try {
			
			DatagramSocket sender = new DatagramSocket();
			sender.setBroadcast(true);
			DatagramPacket paquete = new DatagramPacket(
											buffer,
											buffer.length,
											InetAddress.getByName(BROADCAST),
											port
									);
			sender.send(paquete);
			sender.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String generaCuadrado(String comando) {
		String cuadrado = "";
		// Procesar parámetros
		String[] params = comando.split(CARACTER_SEPARADOR);
		int altura = Integer.parseInt(params[0]);
		int ancho = Integer.parseInt(params[1]);
		char simbolo = params[2].charAt(0);
		
		// Mientras queden datos
		// TODO: Refactorizar para hacer más claro
		for(int i = 0; i< altura; i++) {
			// Pintar fila
			// Si es primera o última
			//  pinta mazacote
			if(i == 0 || i == altura-1) {
				for(int j=0;j<ancho; j++) {
					cuadrado += simbolo;
				}
			} else {
			// Si no
			//   Pinta hueca
				for(int j=0;j<ancho; j++) {
					if(j==0||j==ancho-1) {
						cuadrado += simbolo;
					} else {
						cuadrado += " ";
					}
				}
			}
			cuadrado += "\n";
		}
		/*
		<<<<<<<<
		<      <
		<      <
		<<<<<<<<
		*/

		return cuadrado;
	}

	private static String recibeInfo(DatagramSocket receiver) {
		byte[] buffer = new byte[BUFFER_SIZE];
		DatagramPacket paquete = new DatagramPacket(
					buffer,
					BUFFER_SIZE
				);
		String info = "";
		try {
			receiver.receive(paquete);
			info = new String(paquete.getData(), 0, paquete.getLength());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return info;
	}
}
