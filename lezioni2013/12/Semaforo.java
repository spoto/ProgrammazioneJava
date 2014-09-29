
public class Semaforo {

	/**
	 * Il colore in cui è in questo
	 * momento il semaforo:
	 * 0=verde
	 * 1=arancione tra verde e rosso
	 * 2=rosso
	 * 3=arancione tra rosso e verde
	 */
	private int colore;

	/**
	 * E' italiano? Oppure inglese?
	 */
	private boolean italiano;

	private static int counter = 0;

	public Semaforo() {
		colore = 0;
		italiano = true;
		counter++;
	}

	public Semaforo(int colore, boolean italiano) {
		this.colore = colore;
		this.italiano = italiano;
		counter++;

		if (italiano && (colore < 0 || colore > 2))
			System.out.println("stato inconsistente");
		else if (!italiano && (colore < 0 || colore > 3))
			System.out.println("stato inconsistente");
	}

	public boolean italiano() {
		return italiano;
	}

	public boolean inglese() {
		return !italiano;
	}

	public boolean verde() {
		return colore == 0;
	}

	public boolean arancione() {
		return colore == 1 || colore == 3;
	}

	public boolean rosso() {
		return colore == 2;
	}

	public static int numeroSemaforiCreatiFinora() {
		return counter;
	}

	public void setCountry(boolean italiano) {
		this.italiano = italiano;

		if (italiano && colore == 3)
			colore = 1;
	}

	public void next() {
		if (italiano)
			colore = (colore + 1) % 3;
		else
			colore = (colore + 1) % 4;
	}

	public String toString() {
		switch (colore) {
		case 0:
			return "O\nO\n*\n";
		case 1:
		case 3:
			return "O\n*\nO\n";
		default:
			return "*\nO\nO\n";
		}
	}
}
