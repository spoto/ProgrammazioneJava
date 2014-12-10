package date;

public class Studente extends Persona implements Comparable<Studente> {

	private final int matricola;

	public Studente(String nome, int matricola) {
		super(nome);
		
		this.matricola = matricola;
	}

	public boolean haMatricolaMinore(Studente altro) {
		if (matricola < altro.matricola)
			return true;
		else
			return false;
	}

	public String toString() {
		return super.toString() + " con matricola " + matricola;
	}

	public int compareTo(Studente altro) {
		if (matricola < altro.matricola)
			return -1;
		else if (matricola > altro.matricola)
			return 1;
		else
			return 0;
	}
}
