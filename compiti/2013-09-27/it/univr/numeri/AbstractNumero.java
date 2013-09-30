package it.univr.numeri;

public abstract class AbstractNumero implements Numero {

	private int value;

	protected AbstractNumero(int value) {
		if (value < 0)
			throw new ArithmeticException("valore negativo");

		this.value = value;
	}

	@Override
	public final int getValue() {
		return value;
	}

	@Override
	public final void aggiungi(Numero n) {
		value += n.getValue();
	}

	@Override
	public final void sottrai(Numero n) {
		if (value >= n.getValue())
			value -= n.getValue();
		else
			throw new ArithmeticException("risultato negativo");
	}

	@Override
	public final int compareTo(Numero o) {
		return value - o.getValue();
	}

	@Override
	public final boolean equals(Object other) {
		return other instanceof Numero && value == ((Numero) other).getValue();
	}

	@Override
	public final int hashCode() {
		return value;
	}
}
