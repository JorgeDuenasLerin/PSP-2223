package examen.t1;

public class Carrera {

	private static final int CORREDORES = 2;

	public static void main(String[] args) {
		Salida salida = new Salida();
		Thread[] corredores = new Thread[CORREDORES];
		
		for (int i = 0; i < CORREDORES; i++) {
			corredores[i] = new Thread(new Corredor(i+1, salida));
			corredores[i].start();
		}
		
		System.out.println("3, 2, 1,...");
		while(salida.getNumCorredoresEsperando()!=CORREDORES) {
			try {
				Thread.sleep(CORREDORES);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Salida!");
		synchronized (salida) {
			salida.notifyAll();
		}
		
		
		for (int i = 0; i < CORREDORES; i++) {
			try {
				corredores[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Carrera finalizada");

	}

}
