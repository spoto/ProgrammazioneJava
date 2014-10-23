
public class Semaforo {
	// un semaforo deve sapere di che colore è
	private int colore; // 0=verde, 1=arancione, 2=rosso
	private final static int VERDE = 0;
	private final static int ARANCIONE = 1;
	private final static int ROSSO = 2;
	private final static int ARANCIONE2 = 3;

	private static boolean nazionalità;
	private final static boolean ITALIANA = true;
	private final static boolean INGLESE = false;
	
	public Semaforo() {
	}

	public void rosso() {
		colore = ROSSO;
	}

	public void arancione() {
		colore = ARANCIONE;
	}

	public void verde() {
		colore = VERDE;
	}

	public void prossimo() {
		if (nazionalità == ITALIANA && colore == ARANCIONE2)
			colore = ARANCIONE;

		colore++;
		if (nazionalità == ITALIANA)
			colore %= 3;
		else
			colore %= 4;
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
