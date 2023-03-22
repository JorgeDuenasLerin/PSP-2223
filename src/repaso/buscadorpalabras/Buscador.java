package repaso.buscadorpalabras;

import java.awt.BufferCapabilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Buscador implements Runnable {

	String[] rutas;
	String busqueda;
	File localizacion;
	int ini;
	int fin;
	int count;
	
	public Buscador(String[] rutas, File localizacion, String busqueda, int ini, int fin) {
		this.rutas = rutas;
		this.busqueda = busqueda;
		this.localizacion = localizacion;
		this.ini = ini;
		this.fin = fin;
		count = 0;
	}

	@Override
	public void run() {
		// Mientras queden datos
		for (int i = ini; i < fin; i++) {
			// Procesar
			int c = encuentraYCuenta(rutas[i], busqueda);
			count += c;
			System.out.println("Aparece en " + rutas[i] + " " + c + " veces");
		}
	}

	private int encuentraYCuenta(String ruta, String busqueda) {
		int c = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(localizacion+"/"+ruta));
			String line;
			while((line = br.readLine()) != null) {
				if(line.contains(busqueda)) {
					c++;
				}
			}
		}catch (Exception e) {
			System.err.println("Ocurrio un error en el fichero " + ruta);
			System.err.println(e);
		}
		return c;
	}

	public int getCount() {
		return count;
	}

}
