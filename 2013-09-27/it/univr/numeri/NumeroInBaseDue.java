package it.univr.numeri;

public class NumeroInBaseDue extends NumeroInBase {

	public NumeroInBaseDue(int value) {
		super(value, 2);
	}

	@Override
	public String toString() {
		String s = "";
		int value = getValue();

		do {
			s = value % 2 + s;
			value /= 2;
		}
		while (value > 0);

		return s;
	}
}
