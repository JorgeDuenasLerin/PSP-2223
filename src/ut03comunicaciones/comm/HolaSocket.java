package ut03comunicaciones.comm;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class HolaSocket {
	public static void main(String[] args) {
		String ip = args[0];
		int port = Integer.parseInt(args[1]);
		String msg = args[2];
		
		try {
			Socket con = new Socket(ip, port);
			System.out.println("Conectado con servidor");
			DataOutputStream outTCP = new DataOutputStream (con.getOutputStream());
			DataInputStream inTCP = new DataInputStream  (con.getInputStream());
			
			//Leo mensaje
			System.out.println(inTCP.readUTF());
			
			// mando mensaje
			outTCP.writeUTF(msg);
			System.out.println("Escribo el mensaje en el socket");
			
			inTCP.close();
			outTCP.close();
			con.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
