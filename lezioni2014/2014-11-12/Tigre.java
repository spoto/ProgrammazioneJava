
public class Tigre extends Felino {

	public Tigre(String nome) {
		super(nome);
	}

	public boolean domestico() {
		return false;
	}

	public double costo() {
		return 200.0;
	}

	public String toString() {
		return "Sono una tigre feroce e mi chiamo " + getNome();
	}
}
