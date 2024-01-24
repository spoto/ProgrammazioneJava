package it.univr.cartellone;

public class Main {

	public static void main(String[] args) {
		CartelloneModificabile c = new CartelloneModificabile();

		// treno 1549 per Venezia delle 10:30 del 28/2/2014
		c.add(new Train(new Time(2014, 28, 2, 10, 30), 1549, "Venezia"));

		// treno 1804 per Bologna delle 11:45 del 28/2/2014
		c.add(new Train(new Time(2014, 28, 2, 11, 45), 1804, "Bologna"));

		// treno 1802 per Milano delle 11:45 del 28/2/2014
		c.add(new Train(new Time(2014, 28, 2, 11, 45), 1802, "Milano"));

		// treno 211 per Trieste delle 12:01 del 28/2/2014
		c.add(new Train(new Time(2014, 28, 2, 12, 01), 211, "Trieste"));

		// treno 1561 per Venezia delle 11:59 del 28/2/2014
		c.add(new Train(new Time(2014, 28, 2, 11, 59), 1561, "Venezia"));

		System.out.println(c);

		Cartellone lim = new CartelloneLimitato(c, 3);

		System.out.println("\nI prossimi 3 treni");
		System.out.println(lim);
	}
}