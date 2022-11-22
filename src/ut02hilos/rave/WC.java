package ut02hilos.rave;

public class WC {

	private boolean ocu;
	
	public WC() {
		ocu = false;
	}
	
	public boolean ocupado() {
		return ocu;
	}

	public void entra() {
		ocu = true;
	}

	public void sal() {
		ocu = false;
	}

}
