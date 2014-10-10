package lezioneodierna;

import java.util.Scanner;

public class Int2Hex {
	public static void main(String[] args) {
		System.out.print("Numero da convertire: ");

		int n;
		do {
			n = new Scanner(System.in).nextInt();
		}
		while (n < 0);

		String hex = "";

		do {
			hex = "0123456789ABCDEF".charAt(n % 16) + hex;
			n /= 16;
		}
		while (n > 0);

		System.out.println(hex);
	}
}
