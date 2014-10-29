
// copiando le date è immutabile!
public class Studente {
	private String nome;
	private String cognome;
	private Data nascita;

	public Studente(String nome, String cognome, Data nascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.nascita = new Data(nascita);  // copio l'oggetto!
	}

	public String toString() {
		return "Mi chiamo " + nome + " " + cognome
				+ ", sono nato il " + nascita.toString();
	}

	public Data getDataDiNascita() {
		return new Data(nascita);  // copio l'oggetto
	}
}
