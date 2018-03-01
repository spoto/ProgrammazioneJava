package it.univr.esami;

public class Studente {
	public final int matricola;
	public final String nome;
	public final String cognome;
	
	public Studente(int matricola, String nome, String cognome) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	@Override
	public boolean equals(Object other) {
		return other instanceof Studente && ((Studente) other).matricola == matricola;
	}

	@Override
	public int hashCode() {
		return matricola;
	}
}