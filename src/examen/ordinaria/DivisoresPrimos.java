package examen.ordinaria;

public class DivisoresPrimos implements Runnable{
	private int start;
	private int end;
	private int number;
	
	public DivisoresPrimos(
				int start,
				int end,
				int number
			) {
		this.start = start;
		this.end = end;
		this.number = number;
	}

	@Override
	public void run() {
		// Mientras queden datos
		for (int i = start; i < end; i++) {
			//   Procesar
			if(divideDeFormaEntera(i,number) && esPrimo(i)) {
				System.out.print(i + " ");
			}
		}
	}

	private boolean divideDeFormaEntera(int i, int n) {
		return (n % i) == 0;
	}

	private boolean esPrimo(int n) {
		boolean esPrimo = true;
		int i = 2;
		while(esPrimo && i <= Math.sqrt(n) ) {
			if(n%i==0) {
				esPrimo = false;
			}
			i++;
		}
		return esPrimo;
	}
}
