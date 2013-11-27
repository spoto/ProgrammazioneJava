package it.univr.numeri;

public class Esadecimale extends Numero {

	public void check() {
		if (getValue() < 0)
			System.out.println("Puoi costruire solo"
					+ " esadecimali non negativi");
	}

	private final static String cifre
		= "0123456789ABCDEF";

	public String toString() {
		String risultato = "";
		int value = getValue();

		do {
			risultato = cifre.charAt(value % 16)
				+ risultato;
			value /= 16;
		}
		while (value != 0);

		return risultato;
	}

	public Esadecimale(int value) {
		super(value);
	}
}
