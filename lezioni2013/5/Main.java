import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num;

		do {
			System.out.println("numero: ");
			num = scanner.nextInt();
		}
		while (num < 0);

		String binario = "";
		do {
			binario = num % 2 + binario;
			num /= 2;
		}
		while (num > 0);

		System.out.println(binario);
	}

}
