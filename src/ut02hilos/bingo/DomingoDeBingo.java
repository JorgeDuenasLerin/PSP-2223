package ut02hilos.bingo;

public class DomingoDeBingo {
	public static void main(String[] args) {
		Bola b= new Bola();
		
		Binguero paco = new Binguero("Paco", b);
		new Thread(paco).start();
		Binguero jorge = new Binguero("Jorge", b);
		new Thread(jorge).start();
		Binguero amparo = new Binguero("Amparo", b);
		new Thread(amparo).start();
		
		Bingo bingo = new Bingo(b);
		new Thread(bingo).start();
		
		System.out.println("All the threads are started");
	}
}