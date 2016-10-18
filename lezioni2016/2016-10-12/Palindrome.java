import java.util.Scanner;


public class Palindrome {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Inserisci la frase: ");
		String s = keyboard.nextLine();

		int left = 0, right = s.length() - 1;
		boolean isPalindrome = true;
		
		while (left < right && isPalindrome)
			if (s.charAt(left++) != s.charAt(right--))
				isPalindrome = false;
			
		if (isPalindrome)
			System.out.println("è palindroma");
		else
			System.out.println("non è palindroma");

		keyboard.close();
	}
}
