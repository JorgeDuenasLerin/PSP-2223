package ut03comunicaciones.comm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HolaCliente {

	public static void main(String[] args) {
		String ip = args[0]; // IP
		int port = Integer.parseInt(args[1]);
		
		Socket conn;
		try {
			conn = new Socket(ip,port);
		
			DataOutputStream outTCP = new DataOutputStream(conn.getOutputStream());
			DataInputStream inTCP = new DataInputStream(conn.getInputStream());
			
			System.out.println("Server dice:" + inTCP.readUTF());
			
			String msg;
			Scanner sc = new Scanner(System.in);
			do {
				msg = sc.nextLine();
				// Aquí pensar
				outTCP.writeUTF(msg);
				String msgModificado = inTCP.readUTF();
				System.out.println("El server dice:" + msgModificado);
			}while(!msg.equals(HolaServer.MENSAJE_FIN));
			
			inTCP.close();
			outTCP.close();
			conn.close();
			sc.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
