package examen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {
	
	private static final int CAMPO_USER = 0;
	private static final int CAMPO_MEM = 3;
	private static final String MEM_CERO = "0.0";

	public static String removeEspacios(String cadena) {
		String limpia = "";
		boolean espacio = false;
		for(int i = 0; i <cadena.length(); i++) {
			if(cadena.charAt(i)!=' ') {
				espacio = false;
				limpia += cadena.charAt(i);
			} else {
				if(!espacio ) {
					limpia += ' ';
				}
				espacio = true;
			}
		}
		return limpia;
	}
	
	public static void main(String[] args) throws IOException {

		Process p = new ProcessBuilder("ps", "aux").start();
		try {

			BufferedReader lector = new BufferedReader (new InputStreamReader(p.getInputStream()));
			String linea;

			boolean primera = true;
			while ((linea = lector.readLine ()) != null) {
				if(primera) {
					System.out.println(linea);
					primera = false;
				} else {
					String[] cachos = removeEspacios(linea).split(" ");
					if(cachos[CAMPO_USER].equals(args[0]) && !cachos[CAMPO_MEM].equals(MEM_CERO)) {
						System.out.println(linea);
					}
				}
			}
			lector.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
