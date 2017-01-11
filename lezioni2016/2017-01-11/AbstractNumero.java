
public abstract class AbstractNumero implements Numero {
	private int value;

	protected AbstractNumero(int value) {
		this.value = value;
	}

	@Override
	public final int getValue() {
		return value;
	}

	@Override
	public final void aggiungi(Numero n) {
		this.value += n.getValue();
	}

	@Override
	public final void sottrai(Numero n) {
		if (this.value - n.getValue() < 0)
			throw new ArithmeticException();

		this.value -= n.getValue();
	}

	@Override
	public final boolean equals(Object other) {
		return other instanceof Numero &&
				this.value == ((Numero) other).getValue();
	}

	public final int hashCode() {
		return this.value;
	}

	@Override
	public final int compareTo(Numero other) {
		return value - other.getValue();
	};
}
