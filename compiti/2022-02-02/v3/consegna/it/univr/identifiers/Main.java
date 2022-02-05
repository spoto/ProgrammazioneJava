package it.univr.identifiers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// CLASSE COMPLETA, NON MODIFICARE
public class Main {

	public static void main(String[] args) {
		Iterable<String> words = readWords();

		ThreeStyleIdentifier id1 = new ThreeStyleIdentifier(words);
		System.out.println("id1 = " + id1);
		SnakeStyleIdentifier id2 = new SnakeStyleIdentifier(words);
		System.out.println("id2 = " + id2);
		ThreeStyleIdentifier id3 = new ThreeStyleIdentifier(id1, id2);
		System.out.println("id3 = " + id3);
		System.out.println("id3 snake style = " + id3.toSnakeStyle());
	}

	// legge da tastiera una sequenza di parole
	private static Iterable<String> readWords() {
		System.out.println("Inserisci una parola alla volta e termina con END");
		List<String> words = new ArrayList<>();
		
		try (Scanner keyboard = new Scanner(System.in)) {
			while (true) {
				String word = keyboard.nextLine();
				if (word.equals("END"))
					return words; // "END" non fa parte della sequenza ritornata

				words.add(word);
			}
		}
	}
}