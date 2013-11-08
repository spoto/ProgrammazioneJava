import java.util.Scanner;

import it.univr.gioco15.Gioco15;


public class Main {

	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		Gioco15 gioco = new Gioco15();

		do {
			System.out.println(gioco.toString());
			System.out.println("riga: ");
			int riga = tastiera.nextInt();
			System.out.println("colonna: ");
			int colonna = tastiera.nextInt();

			gioco.sposta(colonna, riga);
		}
		while (true);
	}
}