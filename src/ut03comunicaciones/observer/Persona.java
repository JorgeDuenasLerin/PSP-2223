package ut03comunicaciones.observer;

public class Persona implements DescansilloDeLaEscalera.MarujaMarujo{

	String nombre;
	public Persona (String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void update(String event) {
		System.out.println(String.format("Soy %s, ha pasado %s.", nombre, event));
	}
}
