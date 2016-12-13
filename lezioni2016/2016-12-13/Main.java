import it.univr.date.Date;
import it.univr.date.NonExistentDateException;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner keyboard = new Scanner(System.in)) {
			boolean ok;
			Date d = null;

			do {
				ok = true;

				System.out.print("giorno: ");
				String g = keyboard.next();

				System.out.print("mese: ");
				String m = keyboard.next();

				System.out.print("anno: ");
				String a = keyboard.next();

				int gi, mi, ai;

				try {
					gi = Integer.parseInt(g);
					mi = Integer.parseInt(m);
					ai = Integer.parseInt(a);
					d = new Date(gi, mi, ai);
				}
				catch (NumberFormatException e) {
					// finiamo qui solo se il parseInt ha generato
					// una NumberFormatException
					System.out.println("giorno mese o anno illegale");
					ok = false;
				}
				catch (NonExistentDateException e) {
					System.out.println("data inesistente");
					ok = false;
				}
			}
			while (!ok);

			System.out.println("ho costruito " + d);
		}
	}

}
