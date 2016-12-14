import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		try (Scanner keyboard = new Scanner(System.in)) {
			System.out.print("Nome file: ");
			String filename = keyboard.next();
			WordCounter counter;

			try {
				counter = new WordCounter(filename);
			}
			catch (FileNotFoundException e) {
				System.out.println("File non esistente");
				return;
			}
			catch (IOException e) {
				System.out.println("Errore nella lettura del file");
				return;
			}

			System.out.println("Numero di parole: " + counter.count);
		}
	}

}
