package ut02hilos.bingo;

public class Binguero implements Runnable{
	private Bola b;
	private String name;
	public Binguero(String name, Bola b){
		this.name = name;
		this.b=b;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (b) {
				try{
					System.out.println(name+" esperando a la bola.");
					b.wait();
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				System.out.println(name+" he escuchado el:" + b.getMsg());
			}
		}
		
	}
}