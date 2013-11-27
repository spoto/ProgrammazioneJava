package it.univr.numeri;

public abstract class Numero {

	private int value;

	protected Numero(int value) {
		this.value = value;

		check();
	}

	public abstract String toString();
	public abstract void check();

	public int getValue() {
		return value;
	}

	public final void add(Numero altro) {
		this.value += altro.value;

		check();
	}

	public final void subtract(Numero altro) {
		this.value -= altro.value;

		check();
	}	
}
