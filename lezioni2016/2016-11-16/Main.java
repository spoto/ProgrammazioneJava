import it.univr.gioco15.Gioco15;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Gioco15 gioco15 = new Gioco15();
		Scanner tastiera = new Scanner(System.in);
		
		do {
			System.out.println(gioco15.toString());
			System.out.print("\nriga: ");
			int riga = tastiera.nextInt();
			System.out.println("colonna: ");
			int colonna = tastiera.nextInt();
			gioco15.sposta(riga, colonna);
		}
		while (true);
	}
}
