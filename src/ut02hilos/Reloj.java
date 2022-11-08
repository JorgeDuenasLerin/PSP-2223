package ut02hilos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Reloj extends JFrame{

	public Reloj() {
		super("Reloj");
		
		setLayout(new FlowLayout());
		
		JLabel l = new JLabel();
		l.setText("0");
		getContentPane().add(l);
		
		JButton b = new JButton("¡Comienza!");
		getContentPane().add(b);
		
		Object sync = new Object();
		
		Contador c = new Contador(l, sync);
		Thread t = new Thread(c);
		t.start();
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				synchronized(sync) {
					sync.notify();
				}
			}
		});
		
		JButton bPara = new JButton("¡Para!");
		getContentPane().add(bPara);
		bPara.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				t.interrupt();
			}
		});
		
		setSize(500,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Reloj();
	}
}
