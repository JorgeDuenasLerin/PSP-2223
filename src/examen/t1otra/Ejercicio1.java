package examen.t1otra;

public class Ejercicio1 {

	private static final int SIZE = 16;
	private static final int MAX = 1000;
	private static final int NUM_THREADS = 4;
	
	public static void imprime(int[] nums) {
		for(int i = 0;i< nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
	
	public static void imprimeVerificado(boolean[] veris) {
		for(int i = 0;i< veris.length; i++) {
			System.out.println(veris[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[SIZE];
		boolean[] primos = new boolean[SIZE/2];
		int cachosSize = SIZE / NUM_THREADS;
		Runnable[] gens = new Runnable[NUM_THREADS];
		Thread[] tGens = new Thread[NUM_THREADS];
		
		// Generar primos
		for(int i = 0 ; i < NUM_THREADS; i ++) {
			gens[i] = new Generador(i*cachosSize, (i+1)*cachosSize, nums);
			tGens[i] = new Thread(gens[i]);
			tGens[i].start();
		}
		
		for(int i = 0 ; i < NUM_THREADS; i ++) {
			try {
				tGens[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Interrupción inesperada");
			}
		}
		System.out.println("Primos generados");
		imprime(nums);
		
		//imprime(nums);
		for(int i = 0 ; i < NUM_THREADS; i ++) {
			gens[i] = new Verificador(i*cachosSize, (i+1)*cachosSize, nums, primos);
			tGens[i] = new Thread(gens[i]);
			tGens[i].start();
		}
		
		for(int i = 0 ; i < NUM_THREADS; i ++) {
			try {
				tGens[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Interrupción inesperada");
			}
		}
		
		System.out.println("Primos verificados");
		imprimeVerificado(primos);
	}

	/*
	 * Las meto dentro para que quede en un ejercicio
	 * */
	static class Generador implements Runnable {
		
		int start;
		int end;
		int[] datos;
		
		public Generador (int start, int end, int[] datos) {
			this.start = start;
			this.end = end;
			this.datos = datos;
		}

		@Override
		public void run() {
			for(int i = start; i < end; i++) {
				datos[i] = (int) (Math.random()*MAX);
			}
		}
	}
	
	static class Verificador implements Runnable {
		
		int start;
		int end;
		int[] datos;
		boolean[] resultados;
		
		public Verificador (int start, int end, int[] datos, boolean[] resultados) {
			this.start = start;
			this.end = end;
			this.datos = datos;
			this.resultados = resultados;
		}

		@Override
		public void run() {
			for(int i = start; i < end; i=i+2) {
				resultados[i/2] = (datos[i]+datos[i+1])> MAX; // Condición de primos
			}
		}
	}
}
