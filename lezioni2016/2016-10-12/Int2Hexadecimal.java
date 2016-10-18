import java.util.Scanner;


public class Int2Hexadecimal {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int num;
		
		do {
			System.out.print("Inserisci il numero: ");
			num = keyboard.nextInt();
		}
		while (num < 0);

		final int BASE = 16;
		String result = "";
		
		do {
			result = "0123456789ABCDEF".charAt(num % BASE) + result;
			num = num / BASE;
		}
		while (num > 0);

		System.out.println(result);

		keyboard.close();
	}
}