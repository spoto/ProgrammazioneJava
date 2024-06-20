package it.univr.file;

public abstract class AbstractComponent implements Component {
	private final String name;

	/**
	 * Costruisce una componente con il nome indicato.
	 */
	protected AbstractComponent(String name) {
		this.name = name;
	}

	@Override
	public final String getName() {
		return name;
	}

	@Override
	public final String toString() {
		return toString("");
	}
}