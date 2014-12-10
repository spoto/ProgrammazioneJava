package date;

public class Persona extends EssereVivente {
	private final String nome;
	
	public Persona(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return nome;
	}
}
