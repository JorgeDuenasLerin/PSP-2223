package examen.ordinaria;

import java.io.BufferedReader;
import java.io.FileReader;

public class WordCounter implements Runnable {
	public static final int NUM_LETRAS = ('z'-'a')+1; //26
	private static final int EOF = -1;
	private String ruta;
	private int[] contadoresLetras;
	
	public WordCounter(String rutaFichero) {
		ruta = rutaFichero;
		//contadores = new int[26];//Mala práctica
		contadoresLetras = new int[NUM_LETRAS];
	}
	
	@Override
	public void run() {
		try {
			BufferedReader reader = new BufferedReader (
											new FileReader(ruta)
										);
			int c;
			// Mientras queden datos
			while((c = reader.read()) != EOF) {
				// Procesar
				if('a' <= c && c <= 'z') { // minúsculas
					contadoresLetras[c-'a']++;
				} else if( 'A' <= c && c <= 'Z'){ // mayus
					contadoresLetras[c-'A']++;
				}
			}
			// Finalizar
			reader.close();
		}catch (Exception e) {
		}
	}
	
	/* OPCIÓN 1
	 * 'a', 'z', 'A', 'f'
	 * */
	public int getCount(char c) {
		if('a' <= c && c <= 'z') { // minúsculas
			return contadoresLetras[c-'a'];
		} else if( 'A' <= c && c <= 'Z'){ // mayus
			return contadoresLetras[c-'A'];
		}
		return 0;
	}
	
	/* OPCIÓN 2
	 * Traer todo
	 * */
	public int[] getCounter() {
		return contadoresLetras;
	}
}
