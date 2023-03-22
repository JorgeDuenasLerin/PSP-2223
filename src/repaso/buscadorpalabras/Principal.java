package repaso.buscadorpalabras;

import java.io.File;

public class Principal {

	private static final int NUM_PARAMS = 3;
	// Procesar las parámetros
	// Distribuir trabajo
	// Ejecutar trabajo
	// Esperar fin
	// Recoger información

	/***
	 * java repaso.buscadospalabras.Principal 6 "cadena" "C:\Users"
	 * java repaso.buscadospalabras.Principal numThreads cadena directorio 
	 * */
	public static void main(String[] args) {
		// Procesar las parámetros
		if(args.length != NUM_PARAMS) {
			System.err.println("Error en el número de parámetros");
			return;
		}
		int numThreads = 0;
		String busqueda = "";
		File localizacion;
		String[] rutas;
		try {
			numThreads = Integer.parseInt(args[0]);
			busqueda = args[1];
			localizacion = new File(args[2]);
			rutas = localizacion.list();
		} catch(Exception e) {
			System.err.println("Error procesando parámetros");
			System.err.println(e);
			return;
		}
		int cantidadTrabajo = rutas.length / numThreads;
		
		// Distribuir trabajo
		Thread[] trabajadores = new Thread[numThreads];
		Buscador[] buscadores = new Buscador[numThreads];
		

		for(int i = 0; i < numThreads; i++) {
			int fin;
			if(i==numThreads-1) {
				fin = rutas.length;
			} else {
				fin = cantidadTrabajo*(i+1); //cantidadTrabajo*i + cantidadTrabajo*1
			}
			buscadores[i] = new Buscador(
									rutas,
									localizacion,
									busqueda,
									cantidadTrabajo*i,
									fin
								);
			trabajadores[i]= new Thread(buscadores[i]);
			
			// Ejecutar trabajo
			trabajadores[i].start();					
		}
		
		// Esperar fin
		// Recoger información
		int total=0;
		for(int i = 0; i < numThreads; i++) {
			try {
				trabajadores[i].join();
				total+=buscadores[i].getCount();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("El número total de coincidencias es: " + total);
	}
}