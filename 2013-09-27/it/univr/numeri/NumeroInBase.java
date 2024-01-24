package it.univr.numeri;

public abstract class NumeroInBase extends AbstractNumero {
	private final int base;

	protected NumeroInBase(int value, int base) {
		super(value);

		if (base < 2 || base > 16)
			throw new ArithmeticException("La base deve essere fra 2 e 16");

		this.base = base;
	}

	public final int getBase() {
		return base;
	}
}
