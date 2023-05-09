package repaso.casino;

public class Ruleta {
	private static final long TIEMPO_JUGADA = 3000;
	public static final int MAX_NUMEROS = 37;
	public static final int MAX_NUMEROS_NO_ZERO = 36;
	private int n;
	private static Ruleta instance;
	
	private Ruleta () {
		instance = null;
	}
	
	public static Ruleta getInstance() {
		if(instance==null) {
			instance = new Ruleta();
		}
		return instance;
	}
	
	public void lanzarBola() {
		try {
			System.out.println("Hagan sus apuestas!");
			Thread.sleep(TIEMPO_JUGADA);
			n = (int) (Math.random()*MAX_NUMEROS);
			System.out.println("Salió el " +n+ "!");
			synchronized (this) {
				notifyAll();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* Todos los threads están consultando */
	public int getNumero() {
		return n;
	}
}
