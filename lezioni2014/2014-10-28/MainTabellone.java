public class MainTabellone {

	public static void main(String[] args) {
		Tabellone c = new Tabellone(13);

		for (int i = 13; i <= 99; i++) {
			System.out.println(c);
			c.next();
		}
	}

}
