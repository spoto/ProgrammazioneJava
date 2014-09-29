package it.univr.esami;

public class Esame {

	private String nome;
	private int voto;

	public Esame(String nome, int voto) {
		this.nome = nome;
		this.voto = voto;
	}

	public String toString() {
		return "esame di " + nome + " con voto " + voto;
	}

	public int getVoto() {
		return voto;
	}
}
