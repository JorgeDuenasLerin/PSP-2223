package ut03comunicaciones.observer;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;

class DescansilloDeLaEscalera {
    public interface MarujaMarujo {
        void update(String event);
    }
  
    private final List<MarujaMarujo> observers = new ArrayList<>();
  
    private void notifyObservers(String event) {
    	
    	for(int i = 0; i < observers.size(); i++) {
    		observers.get(i).update(event);
    	}
    	
    	/*
    	for(Observer o : observers ) {
    		o.update(event);
    	}
    	*/
    	
    	/*
        observers.forEach(new Consumer<Observer>() {
			@Override
			public void accept(Observer o) {
				o.update(event);				
			}
		});
		*/
    	
    	/*
    	observers.forEach(paco -> paco.update(event));
    	*/
    }
  
    public void addObserver(MarujaMarujo observer) {
        observers.add(observer);
    }
  
    public void seAbreElDescasillo() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            notifyObservers(line);
        }
    }
}
