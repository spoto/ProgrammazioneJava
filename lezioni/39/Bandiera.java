import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Bandiera extends JFrame {
	private JPanel verde;
	private JPanel bianco;
	private JPanel rosso;

	public Bandiera() {
		super("Bandiera");

		setLayout(new BorderLayout());
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(createCenter(), BorderLayout.CENTER);
		add(createSouth(), BorderLayout.SOUTH);
	}

	private JPanel createCenter() {
		JPanel center = new JPanel();
		center.setBackground(Color.GRAY);

		verde = new JPanel();
		bianco = new JPanel();
		rosso = new JPanel();
		
		center.setLayout(new GridLayout(1, 3));
		center.add(verde);
		center.add(bianco);
		center.add(rosso);

		return center;
	}

	private JPanel createSouth() {
		JPanel south = new JPanel();
		south.setBackground(Color.GRAY);	

		JButton comandaRosso = new JButton("Rosso");
		comandaRosso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rosso.setBackground(Color.RED);
			}			
		});

		JButton comandaBianco = new JButton("Bianco");
		comandaBianco.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bianco.setBackground(Color.WHITE);
			}			
		});

		JButton comandaVerde = new JButton("Verde");
		comandaVerde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				verde.setBackground(Color.GREEN);
			}			
		});

		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rosso.setBackground(Color.GRAY);
				bianco.setBackground(Color.GRAY);
				verde.setBackground(Color.GRAY);
			}			
		});

		south.setLayout(new GridLayout(1, 4));

		south.add(comandaVerde);
		south.add(comandaBianco);
		south.add(comandaRosso);
		south.add(reset);
		
		return south;
	}

	public static void main(String[] args) {
		new Bandiera().setVisible(true);
	}
}
