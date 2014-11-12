
public class Gatto extends Felino {

	public Gatto(String nome) {
		super(nome);
	}

	public String toString() {
		return "Sono un gatto e mi chiamo " + getNome();
	}

	public double costo() {
		return 15.0;
	}
}
