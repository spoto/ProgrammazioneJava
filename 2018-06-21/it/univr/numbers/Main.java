package it.univr.numbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		try (Scanner keyboard = new Scanner(System.in)) {
			System.out.print("Inserisci un numero non negativo: ");
			int n = keyboard.nextInt();

			List<Number> numbersAsList = new ArrayList<>();
			numbersAsList.add(new DecimalNumber(n));
			numbersAsList.add(new BinaryNumber(n));
			numbersAsList.add(new BinaryNumberWithParity(n));
			numbersAsList.add(new OctalNumber(n));
			numbersAsList.add(new HexNumber(n));
			numbersAsList.add(new Base58Number(n));
			System.out.println("lista: " + numbersAsList);

			// copia tutti gli elementi della lista dentro l'insieme
			Set<Number> numbersAsSet = new HashSet<>(numbersAsList);
			System.out.println("insieme: " + numbersAsSet);
		}
		catch (IllegalArgumentException e) {
			System.out.println("Non sono ammessi numeri negativi");
		}
	}
}