package lezioneodierna;

import java.util.Scanner;

public class Inversione {

	public static void main(String[] args) {
		System.out.print("Stringa da invertire: ");
		String input = new Scanner(System.in).nextLine();

		String inversa = "";
		for (int pos = 0; pos < input.length(); pos++)
			inversa = input.charAt(pos) + inversa;

		System.out.println(inversa);
	}
}
