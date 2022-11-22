package ut02hilos;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

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
	
	public static String getCurrentTimeStamp() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss.SSS");
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
	
	@Override
	public void run() {
		parar();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.S");
		while(true) {
			cont++;
			//_salida.setText(Integer.toString(cont));
			_salida.setText(getCurrentTimeStamp());
			
			try {
				Thread.sleep(INTERVALO);
			} catch (InterruptedException e) {
				//e.printStackTrace();
				parar();
			}
		}
	}
}
