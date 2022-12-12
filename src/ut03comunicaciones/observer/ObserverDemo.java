package ut03comunicaciones.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("Enter Text : ");
        DescansilloDeLaEscalera descansillo= new DescansilloDeLaEscalera ();
        
        Persona amparo = new Persona("Amparo");
        Persona joaquin = new Persona("Joaquin");
        Persona pedro = new Persona("Pedro");
        
        descansillo.addObserver(amparo);
        descansillo.addObserver(joaquin);
        descansillo.addObserver(pedro);
        descansillo.addObserver(new DescansilloDeLaEscalera.MarujaMarujo() {
			@Override
			public void update(String event) {
				if(event.contains("Jorge")) {
					System.out.print("Eres un $#%$");
				}
			}
		});
        
        /*
        eventSource.addObserver(event -> {
            System.out.println("Received response: " + event);
        });
        */

        descansillo.seAbreElDescasillo();
    }
}