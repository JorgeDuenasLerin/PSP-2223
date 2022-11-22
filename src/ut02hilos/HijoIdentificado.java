package ut02hilos;

public class HijoIdentificado implements Runnable {

	private static final int NUM_SALUDOS = 2;
	private static final int NUM_HIJO = 4;
	
	int id;
	
	public HijoIdentificado(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		for(int i=0; i< NUM_SALUDOS; i++) {
			System.out.println("Soy el hijo " + id);
		}
	}

	public static void main(String[] args) {
		for(int i = 1; i<= NUM_HIJO; i++) {
			HijoIdentificado hijo = new HijoIdentificado(i);
			hijo.run();
			/*
			Thread t = new Thread(hijo);
			t.start();
			new Thread(new HijoIdentificado(i)).start();
			*/
		}
		
		for(int i=0; i< NUM_SALUDOS; i++) {
			System.out.println("Soy el principal");
		}
	}
}





