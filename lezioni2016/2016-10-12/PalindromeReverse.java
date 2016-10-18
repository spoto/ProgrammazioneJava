import java.util.Scanner;


public class PalindromeReverse {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Inserisci la frase: ");
		String s = keyboard.nextLine();

		String reverse = "";
		for (int pos = 0; pos < s.length(); pos++)
			reverse = s.charAt(pos) + reverse;

		boolean isPalindrome = s.equals(reverse);
		if (isPalindrome)
			System.out.println("è palindroma");
		else
			System.out.println("non è palindroma");

		keyboard.close();
	}
}
