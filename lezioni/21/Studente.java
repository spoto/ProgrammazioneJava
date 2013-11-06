
public class Studente extends Persona {
	private int matricola;

	public Studente(String nome, String cognome, int matricola) {
		super(nome, cognome);

		this.matricola = matricola;
	}

	public int getMatricola() {
		return matricola;
	}
}
