package ut05seguridad;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MD5Checker {

	private static final int MD5_LENGTH = 32;

	public static void main(String[] args) {
		HashMap<String,String> mapa = new HashMap<String,String>(); 
		mapa.put("Hola", "f688ae26e9cfa3ba6235477831d5122e");
		mapa.put("Mal", "f688ae26e9cfa3ba6235477831d51333");
		mapa.put("Bien", "23ac817975a0870e6803ed13f134d799");
		
		//mapa.get("Hola");
		for(String k : mapa.keySet()) {
			// Utilizo k y calculo su md5sum
			String md5calculado = calcularMD5(k);			
			// Obtengo el md5sum del has map
			String md5almacenado = mapa.get(k);
			// Compruebo si son iguales
			if(md5calculado.equals(md5almacenado)) {
				System.out.println(k + " Tiene el MD5 bien");			
			} else {
				System.out.println(k + " ERROR en la suma de verficiación");
			}
		}
	}

	private static String calcularMD5(String k) {
		Process pb;
		String md5sum = "";
		try {
			pb = new ProcessBuilder("md5sum").start();
			DataOutputStream  out = new DataOutputStream(pb.getOutputStream());
			out.write(k.getBytes());
			out.close();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(pb.getInputStream()));
			md5sum = in.readLine();
			md5sum = md5sum.substring(0, MD5_LENGTH);
			in.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return md5sum;
	}

}
