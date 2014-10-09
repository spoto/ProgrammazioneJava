import java.util.Scanner;
import ....

public class Vocale {
    public static void main(String[] args) {
	System.out.print("Inserisci la stringa: ");
	String input = new Scanner(System.in).nextLine();
	boolean trovata = false; // falso

	for (int pos = 0; pos < input.length(); pos++) {
	    char c = input.charAt(pos);
	    if ("aeiou".indexOf(c) != -1) {
		trovata = true;
		break; // fine ciclo
	    }
	}

	System.out.printf("%scontiene vocali\n",
			  trovata ? "" : "non ");
    }
}
