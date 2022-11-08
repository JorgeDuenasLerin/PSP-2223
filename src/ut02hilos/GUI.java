package ut02hilos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame{

	public GUI() {
		super("Mi primera ventana");
		
		setLayout(new FlowLayout());
		
		JLabel l = new JLabel();
		l.setText("Hola mundo!");
		getContentPane().add(l);
		
		JButton b = new JButton("¡Púlsame!");
		getContentPane().add(b);
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				l.setText("¡Pulsado!");
			}
		});
		
		setSize(500,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GUI();
	}
}
