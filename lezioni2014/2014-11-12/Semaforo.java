
public class Semaforo {
	// un semaforo deve sapere di che colore è
	private Colore colore;

	private static boolean nazionalità;
	private final static boolean ITALIANA = true;
	private final static boolean INGLESE = false;
	
	public Semaforo() {
		colore = Colore.VERDE;
	}

	public void rosso() {
		colore = Colore.ROSSO;
	}

	public void arancione() {
		colore = Colore.ARANCIONE;
	}

	public void verde() {
		colore = Colore.VERDE;
	}

	public void prossimo() {
		if (nazionalità == ITALIANA && colore == Colore.ARANCIONE2)
			colore = Colore.ARANCIONE;

		int index = colore.ordinal();
		if (nazionalità == ITALIANA)
			index = (index + 1) % 3;
		else
			index = (index + 1)	% 4;

		colore = Colore.values()[index];

		/*
		switch (colore) {
		case VERDE:
			colore = Colore.ARANCIONE; break;
		case ARANCIONE:
			colore = Colore.ROSSO; break;
		case ROSSO:
			if (nazionalità == ITALIANA)
				colore = Colore.VERDE;
			else
				colore = Colore.ARANCIONE2;
			break;
		case ARANCIONE2:
			colore = Colore.VERDE;
			break;
		}
		*/
	}

	public static void diventaItaliano() {
		nazionalità = ITALIANA;
	}

	public static void diventaInglese() {
		nazionalità = INGLESE;
	}

	public String toString() {
		switch (colore) {
		case VERDE:
			return "O\nO\n*\n";
		case ARANCIONE:
		case ARANCIONE2:
			return "O\n*\nO\n";
		case ROSSO:
			return "*\nO\nO\n";
		default:
			return ""; // non si verificherà mai
		}
	}
}
