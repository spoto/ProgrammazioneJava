import it.univr.cards.Hand;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int counter = 0; counter < 500000; counter++) {
			Hand h = new Hand(8);
			System.out.printf("%19s : %s\n", h.toString(), h.category());
		}
	}

}
