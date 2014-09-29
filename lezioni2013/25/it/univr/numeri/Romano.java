package it.univr.numeri;

public class Romano extends Numero {

	public void check() {
		if (getValue() <= 0 || getValue() > 399)
			System.out.println("Puoi costruire solo"
					+ " numeri romani fra 1 e 399");
	}

	public String toString() {
		String risultato;
		int value = getValue();

		risultato = centinaia(value);
		value = value % 100;
		risultato += cinquantine(value);
		value = value % 50;
		risultato += decine(value);
		value = value % 10;
		risultato += cinquine(value);
		value = value % 5;
		risultato += unita(value);

		return risultato;
	}

	private String unita(int value) {
		switch (value) {
		case 0: return "";
		case 1: return "I";
		case 2: return "II";
		case 3: return "III";
		default: return "IV";
		}
	}

	private String cinquine(int value) {
		if (value < 5)
			return "";
		else
			return "V";
	}

	private String decine(int value) {
		if (value < 10)
			return "";
		else if (value < 20)
			return "X";
		else if (value < 30)
			return "XX";
		else if (value < 40)
			return "XXX";
		else
			return "XL";
	}

	private String cinquantine(int value) {
		if (value < 50)
			return "";
		else
			return "L";
	}

	private String centinaia(int value) {
		if (value < 100)
			return "";
		else if (value < 200)
			return "C";
		else if (value < 300)
			return "CC";
		else
			return "CCC";
	}

	public Romano(int value) {
		super(value);
	}
}
