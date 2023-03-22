package examen.ordinaria;

public class DivisoresPrimosMain {
	private static final int NUM_PARAMS = 2;
	private static final int NUM_MINIMO = 30000;
	private static final int THREADS_MAX = 10;
	private static final int THREADS_MIN = 2;

	public static void main(String[] args) {
		// Verificación
		if(args.length != NUM_PARAMS) {
			System.err.print("Número de parámetro incorrectos");
			return;
		}
		int numTrabajo = Integer.parseInt(args[0]);
		int numThreads = Integer.parseInt(args[1]);
		
		if (numTrabajo < NUM_MINIMO || numThreads < THREADS_MIN || THREADS_MAX < numThreads) {
			System.err.print("Parámetro incorrectos");
			return;
		}
		
		int cantidadDeNumerosPorThread = numTrabajo/numThreads;
		
		// Mientras queden datos
		for (int i = 0; i < numThreads; i++) {
			//   Procesar
			// Inicio comienza en 1
			int ini = (i==0)?1:i*cantidadDeNumerosPorThread; /* calculo de inicio */
			// último se encarga has el final
			int fin = (i==numThreads-1)?numTrabajo:ini+cantidadDeNumerosPorThread; /* calculo de fin */
			
			new Thread(
					new DivisoresPrimos(
							ini,
							fin,
							numTrabajo
						)
				).start();
		}
	}
}
