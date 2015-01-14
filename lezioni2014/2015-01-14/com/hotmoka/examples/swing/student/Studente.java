package com.hotmoka.examples.swing.student;

public class Studente {
	private final String nome;
	private final String cognome;
	private final int matricola;
	
	public Studente(String nome, String cognome, int matricola){
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
	}

	public boolean equals(Object obj) {
		return obj instanceof Studente &&
				((Studente) obj).matricola == matricola;
	};

	@Override
	public int hashCode() {
		return matricola;
	}
}
