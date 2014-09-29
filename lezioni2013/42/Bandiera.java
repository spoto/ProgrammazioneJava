import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Bandiera extends JFrame {
	private JPanel verde;
	private JPanel bianco;
	private JPanel rosso;

	public Bandiera() {
		super("Bandiera");

		setLayout(new BorderLayout());
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		add(createCenter(), BorderLayout.CENTER);
		add(createSouth(), BorderLayout.SOUTH);

		createMenu();

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent e) {
			}

			@Override
			public void windowClosed(WindowEvent e) {
			}

			@Override
			public void windowClosing(WindowEvent e) {
				new CheckExit().setVisible(true);
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			}

			@Override
			public void windowIconified(WindowEvent e) {
			}

			@Override
			public void windowOpened(WindowEvent e) {
			}
			
		});
	}

	private void createMenu() {
		JMenuItem verde = new JMenuItem("verde");
		JMenuItem rosso = new JMenuItem("rosso");
		JMenuItem bianco = new JMenuItem("bianco");
		JMenuItem reset = new JMenuItem("reset");

		JMenu informazioni = new JMenu("informazioni");
		JMenuItem preferenze = new JMenuItem("preferenze");
		JMenuItem licenza = new JMenuItem("licenza");
		informazioni.add(preferenze);
		informazioni.add(licenza);

		rosso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Bandiera.this.rosso.setBackground(Color.RED);
			}			
		});

		bianco.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Bandiera.this.bianco.setBackground(Color.WHITE);
			}			
		});

		verde.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Bandiera.this.verde.setBackground(Color.GREEN);
			}			
		});

		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Bandiera.this.rosso.setBackground(Color.GRAY);
				Bandiera.this.bianco.setBackground(Color.GRAY);
				Bandiera.this.verde.setBackground(Color.GRAY);
			}			
		});

		JMenu controllo = new JMenu("controllo");
		controllo.add(verde);
		controllo.add(rosso);
		controllo.add(bianco);
		controllo.add(reset);
		controllo.add(informazioni);

		JMenuBar bar = new JMenuBar();
		bar.add(controllo);

		setJMenuBar(bar);
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
