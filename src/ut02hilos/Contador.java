package ut02hilos;

import javax.swing.JLabel;

public class Contador implements Runnable {
	private static final long INTERVALO = 1;
	JLabel _salida;
	Object _sync;
	
	int cont = 0;
	
	public Contador(JLabel salida, Object sync) {
		_salida = salida;
		_sync = sync;
	}
	
	private void parar() {
		try {
			synchronized(_sync) {
				_sync.wait();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		parar();
		
		while(true) {
			cont++;
			_salida.setText(Integer.toString(cont));
			
			try {
				Thread.sleep(INTERVALO);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				parar();
			}
		}
	}
}
