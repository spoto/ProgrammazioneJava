import java.util.Scanner;


public class Int2Octal {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int num;
		
		do {
			System.out.print("Inserisci il numero: ");
			num = keyboard.nextInt();
		}
		while (num < 0);

		final int BASE = 8;
		String result = "";
		
		do {
			result = (num % BASE) + result;
			num = num / BASE;
		}
		while (num > 0);

		System.out.println(result);

		keyboard.close();
	}
}