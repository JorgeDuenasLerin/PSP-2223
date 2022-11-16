package ut02hilos.rave;

public class Fiesta {
	public static void main(String args[]) {
		WC wc = new WC();
		
		new Thread(new Ravero(1, wc)).start();
		new Thread(new Ravero(2, wc)).start();
		new Thread(new Ravero(3, wc)).start();
	}
}
