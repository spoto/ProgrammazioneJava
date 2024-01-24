package it.univr.numeri;

public class NumeroBCD extends AbstractNumero {

	public NumeroBCD(int value) {
		super(value);
	}

	@Override
	public String toString() {
		String s = "";
		int value = getValue();

		do {
			for (int i = 0, cifra = value % 10; i < 4; i++, cifra /= 2)
				s = cifra % 2 + s;

			value /= 10;
		}
		while (value > 0);

		return s;
	}
}