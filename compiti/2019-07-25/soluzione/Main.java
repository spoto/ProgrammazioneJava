import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Predicate;

import it.univr.words.Words;

public class Main {
	public static void main(String[] args) {
		Predicate<String> startsWithJ = new Predicate<String>() {

			@Override
			public boolean test(String word) {
				return !word.isEmpty() && 'J' == word.charAt(0);
			}
		};

		Predicate<String> longerThan4 = new Predicate<String>() {

			@Override
			public boolean test(String word) {
				return word.length() > 4;
			}
		};

		try (Scanner keyboard = new Scanner(System.in)) {
			System.out.print("File name: ");
			String fileName = keyboard.nextLine();

			try {
				Words words = new Words(fileName);
				System.out.println("\nI have extracted " + words + "\nThe most frequent word is \"" + words.mostFrequent() + "\"");
				words = new Words(fileName, startsWithJ); // in alternativa si puo' usare una lambda espressione
				System.out.println("\nI have extracted " + words + " that start with J");
				System.out.println("The most frequent word is \"" + words.mostFrequent() + "\"");
				words = new Words(fileName, longerThan4);
				System.out.println("\nI have extracted " + words + " that are longer than four characters");
				System.out.println("The most frequent word is \"" + words.mostFrequent() + "\"\n");
			}
			catch (NoSuchElementException e) {
				System.out.println("I have selected zero words!");
			}
			catch (IOException e) {
				System.out.println("There was a problem accessing " + fileName);
			}
		}
	}
}