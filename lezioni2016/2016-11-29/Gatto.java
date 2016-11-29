
public class Gatto extends Felino {
	private final String nome;

	public Gatto(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return nome;
	}

	public boolean èDomestico() {
		return true;
	}

	public int costo() {
		return 0;
	}

	public void miagola() {
		System.out.println("miao miao");
	}
}
