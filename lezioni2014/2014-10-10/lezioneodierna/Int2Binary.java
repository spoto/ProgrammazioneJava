package lezioneodierna;

import java.util.Scanner;

public class Int2Binary {
	public static void main(String[] args) {
		System.out.print("Numero da convertire: ");

		int n;
		do {
			n = new Scanner(System.in).nextInt();
		}
		while (n < 0);

		String binary = "";

		do {
			binary = n % 2 + binary;
			n /= 2;
		}
		while (n > 0);

		System.out.println(binary);
	}
}
