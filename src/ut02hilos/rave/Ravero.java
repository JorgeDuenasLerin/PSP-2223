package ut02hilos.rave;

public class Ravero implements Runnable {
	private WC wc;
	private int id;
	
	public Ravero(int id, WC wc) {
		this.wc = wc;
		this.id = id;
	}
	
	private void duerme(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) { // Que la fiesta no pare!
			System.out.println(id +" Fiesta!!");
			duerme(250);
			if(!wc.ocupado()) {    // Si dos consultan al mismo tiempo
				synchronized(wc) { // Uno de ellos se queda aquí
					wc.entra();
					System.out.println(id + "Entro!!");
					duerme(1000);
					System.out.println(id + "Salgo!!");
					wc.sal();
				}
			}
		}
	}
	
}
