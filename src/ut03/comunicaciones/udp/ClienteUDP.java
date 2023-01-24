package ut03.comunicaciones.udp;

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
			DatagramPacket p = new DatagramPacket(
					buffer,
					buffer.length,
					InetAddress.getByName("192.168.20.200"),
					8888
				);
			
			ds.send(p);
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
