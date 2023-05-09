package repaso.casino;

public class Casino {

	public static void main(String[] args) {
		Ruleta ruleta = Ruleta.getInstance();
		Banca banca = Banca.getInstance();
		Jugador j1 = new Jugador("Jorge");
		Jugador j2 = new Jugador("Ana");
		
		new Thread(banca).start();
		new Thread(j1).start();
		new Thread(j2).start();
	}

}
