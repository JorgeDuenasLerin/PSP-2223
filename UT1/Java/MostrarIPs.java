package UT1.Java;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MostrarIPs {
	// Adaptador de Ethernet Ethernet 3:
	// Adaptador de Ethernet (.*):
	private static String ENCUENTRA_ADAPTADOR="^Adaptador de Ethernet (.*)$";

	//    Dirección IPv4. . . . . . . . . . . . . . : 192.168.217.1
	//    Dirección IPv4. . . . . . . . . . . . . . : (.*)
	private static String ENCUENTRA_IP="^.*IPv4[. ]*: (.*)$";

	private static void extract(String extractor, String line, boolean newLine){
		Pattern r = Pattern.compile(extractor);
		Matcher m = r.matcher(line);
		if (m.find( )) {
		   	System.out.print(m.group(1) + "\t");
		   	if(newLine){
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws IOException {

		Process p = new ProcessBuilder("CMD", "/C", "IPCONFIG").start();

		try {

			BufferedReader lector = new BufferedReader (new InputStreamReader(p.getInputStream()));
			String linea;

			while ((linea = lector.readLine ()) != null) {    
				MostrarIPs.extract(ENCUENTRA_ADAPTADOR, linea, false);
				MostrarIPs.extract(ENCUENTRA_IP, linea, true);
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