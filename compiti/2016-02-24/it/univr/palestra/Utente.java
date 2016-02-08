package it.univr.palestra;

public class Utente implements Comparable<Utente> {
	private final String nome;
	private final String cognome;
	
	public Utente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	@Override
	public boolean equals(Object other) {
		return other instanceof Utente &&
			((Utente) other).nome.equals(nome) &&
			((Utente) other).cognome.equals(cognome);
	}

	@Override
	public int hashCode() {
		return nome.hashCode() ^ cognome.hashCode();
	}

	@Override
	public int compareTo(Utente other) {
		int diff = cognome.compareTo(other.cognome);
		if (diff != 0)
			return diff;
		else
			return nome.compareTo(other.nome);
	}

	@Override
	public String toString() {
		return nome + " " + cognome;
	}
}