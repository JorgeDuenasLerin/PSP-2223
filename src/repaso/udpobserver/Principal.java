package repaso.udpobserver;

public class Principal {

	public static void main(String[] args) {
		UDPServer server = new UDPServer(4321);
		
		LectorDeDatos l1 = new LectorDeDatos("Paco");
		LectorDeDatos l2 = new LectorDeDatos("Amparo");
		
		server.addLector(l1);
		server.addLector(l2);
		
		new Thread(server).start();
		
	}

}
