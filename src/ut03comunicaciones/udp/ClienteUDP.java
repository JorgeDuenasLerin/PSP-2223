package ut03comunicaciones.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClienteUDP {

	public static void main(String[] args) {
		try {
			DatagramSocket ds =  new DatagramSocket();
			byte buffer[] = "Hola mundo\n".getBytes();
			//String ip = "192.168.20.200";
			String ip = "192.168.255.255";
			//ds.setBroadcast(true);
			DatagramPacket p = new DatagramPacket(
					buffer,
					buffer.length,
					InetAddress.getByName(ip),
					4321
				);
			
			ds.send(p);
			ds.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
