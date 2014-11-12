
public class Felino {
	private final String nome;

	public Felino(String nome) {
		this.nome = nome;
	}

	protected String getNome() {
		return nome;
	}

	public String toString() {
		return "Sono un felino e mi chiamo " + nome;
	}

	public double costo() {
		return 0.0;
	}

	public boolean domestico() {
		return true;
	}
}