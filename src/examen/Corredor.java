package examen;

public class Corredor implements Runnable{
	
	private static final int META = 1000;
	private static final int TAMANO_BLOQUE = 50;
	private Salida salida;
	private int dorsal;
	
	public Corredor(int dorsal, Salida salida) {
		this.dorsal = dorsal;
		this.salida = salida;
	}

	@Override
	public void run() {
		System.out.println(dorsal + " esperando salida..");
			
		salida.enSusPuestos();
		
		
		int metros = 0;
		int avance = 0;
		while(metros<META) {
			espera();
			avance = corre();
			metros += avance;
			System.out.println("("+dorsal+")" + avance + " - " + metros + "/" + META);
		}
		System.out.println("He llegado " + dorsal);
	}

	private int corre() {
		return (int) ((Math.random()*TAMANO_BLOQUE) + TAMANO_BLOQUE);
	}

	private void espera() {
		try {
			Thread.sleep((int) ((Math.random()*TAMANO_BLOQUE) + TAMANO_BLOQUE));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
