import java.util.Scanner;


public class Int2Binary {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int num;
		
		do {
			System.out.print("Inserisci il numero: ");
			num = keyboard.nextInt();
		}
		while (num < 0);

		final int BASE = 2;
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