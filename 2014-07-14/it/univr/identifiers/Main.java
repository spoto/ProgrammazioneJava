package it.univr.identifiers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Iterable<String> words = readWords();

		System.out.println("In camel-style, le parole che hai inserito diventano");
		System.out.println(new CamelStyleIdentifier(words));
		System.out.println("In snake-style, le parole che hai inserito diventano");
		System.out.println(new SnakeStyleIdentifier(words));
		System.out.println("Le loro versioni progressive 816 sono");
		System.out.println(new ProgressiveIdentifier(new CamelStyleIdentifier(words), 816));
		System.out.println(new ProgressiveIdentifier(new SnakeStyleIdentifier(words), 816));
	}

	private static Iterable<String> readWords() {
		List<String> words = new ArrayList<String>();
		Scanner keyboard = new Scanner(System.in);

		while (true) {
			String word = keyboard.nextLine();
			if (word.equals("END"))
				break;
			words.add(word);
		}

		keyboard.close();

		return words;
	}
}