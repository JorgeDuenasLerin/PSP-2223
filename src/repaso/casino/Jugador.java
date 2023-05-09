package repaso.casino;

public class Jugador implements Runnable{

	private static final int SALDO = 1000;
	int saldo;
	int apuesta;
	int cantidad;
	
	String nombre;
	Ruleta ruleta;
	Banca banca;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		saldo = SALDO;
		ruleta = Ruleta.getInstance();
		banca = Banca.getInstance();
	}	
	
	public void modificaSaldo(int cantidad) {
		this.saldo += cantidad;
	}

	@Override
	public void run() {
		while(saldo >= Banca.APUESTA_MINIMA) {
			cantidad = Banca.APUESTA_MINIMA;
			apuesta = (int) (( Math.random() * Ruleta.MAX_NUMEROS_NO_ZERO) + 1);
			System.out.println("Soy " + getNombre() + " aposté por el " + apuesta);
			try {
				synchronized (ruleta) {
					ruleta.wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			banca.gestionaApuesta(this);
			System.out.println("Soy " + getNombre() + " me quedan " + saldo);
		}
		System.out.println("Estoy en bancarrota");
	}

	public int getCantidad() {
		return cantidad;
	}

	public int getApuesta() {
		return apuesta;
	}

	public String getNombre() {
		return nombre;
	}

}
