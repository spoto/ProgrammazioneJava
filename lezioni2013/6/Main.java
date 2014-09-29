import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		System.out.println("frase: ");
		String frase = scanner.nextLine();

		String risultato = "";
		int len = frase.length();
		for (int pos = 0; pos < len; pos++)
			risultato = frase.charAt(pos) + risultato;

		System.out.println(risultato);
	}
}
