package repaso.udpobserver;

public class LectorDeDatos implements UDPServer.LectorUDP {

	String id;
	public LectorDeDatos (String id) {
		this.id = id;
	}
	
	@Override
	public void llegaronDatos(String dat) {
		System.out.println(id + " recibe: " + dat);
	}
}
