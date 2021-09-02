// MAIN DI PROVA: NON DOVETE MODIFICARE NULLA

package it.univr.dates;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Ecco le date del 2021:");
		for (Date date: Dates.of(2021))
			System.out.println(date);

		System.out.println("Ecco 5 date casuali tra il 2000 e il 2100:");
		for (Date date: Dates.random(5))
			System.out.println(date);

		try (Scanner keyboard = new Scanner(System.in)) {
			System.out.print("Quante date vuoi stampare? ");
			int howMany = keyboard.nextInt();
			System.out.println("Ecco le prime " + howMany + " date a partire dal 2021:");
			for (Date date: Dates.from(2021)) {
				if (howMany-- <= 0)
					break;

				System.out.println(date);
			}
		}
	}
}
