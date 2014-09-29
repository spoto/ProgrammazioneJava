package it.univr.numeri;

public class Decimale extends Numero {

	public Decimale(int value) {
		super(value);
	}

	public void check() {
		// non c'è nulla da controllare
	}

	public String toString() {
		return String.valueOf(getValue());
	}

}
