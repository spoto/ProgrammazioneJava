package it.univr.esami;

public class Studente {

	private String nome;
	private Esame[] esami;

	public Studente(String nome) {
		this.nome = nome;
		this.esami = new Esame[50];
	}

	public void registra(Esame esame) {
		for (int pos = 0; pos < 50; pos++)
			if (esami[pos] == null) {
				esami[pos] = esame;
				return;
			}
	}

	public int getNumeroEsamiFatti() {
		for (int pos = 0; pos < 50; pos++)
			if (esami[pos] == null)
				return pos;

		return 50;
	}

	/**
	 * Restituisce la media dei voti presi. Se non ha fatto
	 * ancora alcun esame restituisce 0.0
	 * 
	 * @return la media, o 0.0
	 */

	public double getMediaVoti() {
		int numeroEsami = getNumeroEsamiFatti();
		if (numeroEsami == 0)
			return 0.0;
		
		double somma = 0.0;
		for (int pos = 0; pos < numeroEsami; pos++)
			somma += esami[pos].getVoto();

		return somma / numeroEsami;
	}

	public String toString() {
		String res = "Sono " + nome + "\nHo superato gli esami:\n";

		for (int pos = 0; pos < 50; pos++)
			if (esami[pos] != null)
				res += "  " + esami[pos].toString() + '\n';

		return res;
	}

	// NO!!!!!
	public Esame[] getEsami() {
		return esami;
	}
}
