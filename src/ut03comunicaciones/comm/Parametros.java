package ut03comunicaciones.comm;

public class Parametros {

	public static void main(String[] args) {
		System.out.println("Listado de parámetros");
		for(String s: args) {
			System.out.println(String.format("\tParámetro: %s", s));
		}
	}

}
