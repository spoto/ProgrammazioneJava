package com.hotmoka.examples.swing.student;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StudentFrame extends JFrame {

	private Set<Studente> studenti = new HashSet<Studente>();
	private JTextField matricola;
	private JTextField cognome;
	private JTextField nome;
	private JLabel numeroStudenti;

	public StudentFrame() {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(2, 1));
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3, 2));
		p1.add(new JLabel("nome: ", JLabel.RIGHT));
		nome = new JTextField();
		p1.add(nome);
		p1.add(new JLabel("cognome: ", JLabel.RIGHT));
		cognome = new JTextField();
		p1.add(cognome);
		p1.add(new JLabel("matricola: ", JLabel.RIGHT));
		matricola = new JTextField();
		p1.add(matricola);
		JPanel p2 = new JPanel();
		numeroStudenti = new JLabel("Hai inserito 0 studenti");
		p2.add(numeroStudenti);
		centerPanel.add(p1);
		centerPanel.add(p2);

		JPanel southPanel = new JPanel();
		JButton aggiungi = new JButton("aggiungi");
		aggiungi.addActionListener
			(event -> { studenti.add(mkStudente()); aggiornaConteggio(); });
		JButton rimuovi = new JButton("rimuovi");
		rimuovi.addActionListener
			(event -> { studenti.remove(mkStudente()); aggiornaConteggio(); });
		southPanel.add(aggiungi);
		southPanel.add(rimuovi);
		
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);

		pack();
	}

	private void aggiornaConteggio() {
		numeroStudenti.setText("Hai inserito " + studenti.size() + " studenti");
	}

	private Studente mkStudente() {
		return new Studente(nome.getText(), cognome.getText(),
				Integer.parseInt(matricola.getText()));
	}
}