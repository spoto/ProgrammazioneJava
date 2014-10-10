package lezioneodierna;

public class Palindroma {
	
	public static void main(String[] args) {
		System.out.println("stringa da controllare: ");
		String input = new java.util.Scanner(System.in).nextLine();
		
		int left = 0, right = input.length() - 1;
		boolean palindroma = true;
		while (left < right && palindroma)
			if (input.charAt(left++) != input.charAt(right--))
				palindroma  = false;

		if (palindroma)
			System.out.println("La stringa è palindroma");
		else
			System.out.println("La stringa non è palindroma");
	}
}
