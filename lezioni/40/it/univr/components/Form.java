package it.univr.components;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Form extends JFrame {
	public Form() {
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 1));

		final TextCampoInserimento nome = new TextCampoInserimento("Nome", 10);
		final TextCampoInserimento cognome = new TextCampoInserimento("Cognome", 13);
		final IntCampoInserimento età = new IntCampoInserimento("età", 4);

		add(nome);
		add(cognome);
		add(età);

		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new OutputWindow("ciao " + nome.getText()
						+ " " + cognome.getText()
						+ " hai " + età.getValue()
						+ " anni").setVisible(true);
			}
			
		});
		add(ok);
	}

	public static void main(String[] args) {
		new Form().setVisible(true);
	}
}
