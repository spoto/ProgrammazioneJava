package it.univr.numeri;

public class NumeroInBaseSedici extends NumeroInBase {

	public NumeroInBaseSedici(int value) {
		super(value, 16);
	}

	@Override
	public String toString() {
		String s = "";
		int value = getValue();

		do {
			s = cifra(value % 16) + s;
			value /= 16;
		}
		while (value > 0);

		return s;
	}

	private static char cifra(int n) {
		if (n < 10)
			return (char) ('0' + n);
		else
			return (char) ('a' + n - 10);
	}
}
