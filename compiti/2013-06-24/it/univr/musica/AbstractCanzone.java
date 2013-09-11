package it.univr.musica;

public abstract class AbstractCanzone implements Canzone {

	@Override
	public final String toString() {
		String result = getNome() + ":\n";
		for (Nota nota: this)
			result += nota + "\n";

		return result;
	}
}