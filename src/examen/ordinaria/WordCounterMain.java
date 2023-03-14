package examen.ordinaria;

public class WordCounterMain {

	
	public static void main(String[] args) {
		Thread[] trabajadores = new Thread[args.length];
		WordCounter[] contadores = new WordCounter[args.length];

		//El programa arrancará un Thread por cada fichero		
		for(int i=0;i<args.length; i++) {
			contadores[i] = new WordCounter(args[i]);
			trabajadores[i] = new Thread(contadores[i]);
			trabajadores[i].start();
		}
		
		//El programa principal esperará a que terminen los Threads
		for(int i = 0; i < trabajadores.length; i++) {
			try {
				trabajadores[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//sumará el número de letras de cada
		//Por cada letra
		//  Por cada wordcounter
		//    suma
		//  lo escribirá por pantalla.
		for(char c = 'a'; c <= 'z'; c++) {
			int total = 0;
			for(int i = 0; i < contadores.length; i++) {
				//¿Quién tiene la información?
				// extraer información
				// PISTA: hay que usar getCount
				total += contadores[i].getCount(c);
			}
			System.out.println(c + ":" + total);
		}
		
		//Crear arrayGeneral de enteros
		int[] arrayGeneral = new int[WordCounter.NUM_LETRAS]; 
		//Por cada thread-contador
		for(int i=0; i<contadores.length; i++) {
			// Traer array
			int[] esteTioHaContado = contadores[i].getCounter();
			// Sumar a arrayGeneral
			// ¿?
			for(int f = 0; f<arrayGeneral.length;f++) {
				arrayGeneral[f]+=esteTioHaContado[f];
			}
		}
		//Imprimir arrayGeneral
		// [2, 0, 4, 6, ... 2]
		for(int f = 0; f<arrayGeneral.length;f++) {
			// Magia
			System.out.println((char)(f+'a') + ":" + arrayGeneral[f]);
		}
	}
}
