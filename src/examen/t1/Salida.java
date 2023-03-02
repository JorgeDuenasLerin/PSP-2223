package examen.t1;

public class Salida {
	int esperando;
	Object salida;
	
	public Salida() {
		esperando = 0;
	}
	
	public int getNumCorredoresEsperando() {
		return esperando;
	}
	
	public synchronized void enSusPuestos() {
		esperando++;
		try {
			this.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
