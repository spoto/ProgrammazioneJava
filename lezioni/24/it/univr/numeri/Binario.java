package it.univr.numeri;

public class Binario extends Numero {

	public void check() {
		if (getValue() < 0)
			System.out.println("Puoi costruire solo"
					+ " binari non negativi");
	}

	public String toString() {
		String risultato = "";
		int value = getValue();

		do {
			risultato = (value % 2) + risultato;
			value /= 2;
		}
		while (value != 0);

		return risultato;
	}

	public Binario(int value) {
		super(value);
	}
}
