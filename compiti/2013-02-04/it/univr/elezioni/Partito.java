package it.univr.elezioni;

public class Partito {

	private final String nome;

	public Partito(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	@Override
	public boolean equals(Object altro) {
		return altro instanceof Partito && ((Partito) altro).nome.equals(nome);
	}

	@Override
	public int hashCode() {
		return nome.hashCode();
	}
}