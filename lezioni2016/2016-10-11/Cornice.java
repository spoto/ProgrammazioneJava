import java.util.Scanner;

public class Cornice {
    public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);

	// chiedere un input finché non sia soddisfatta COND
	int max;
	do {
	    System.out.print("Inserisci la dimensione massima: ");
	    max = keyboard.nextInt();
	}
	while (max < 2);

	for (int dim = 2; dim <= max; dim++) {
	    String initial = "";
	    String inner = "";

	    for (int counter = 0; counter < dim; counter++)
		initial += '*';

	    inner += '*';
	    for (int counter = 1; counter < dim - 1; counter++)
		inner += ' ';
	    inner += '*';

	    System.out.println(initial);
	    for (int counter = 1; counter < dim - 1; counter++)
		System.out.println(inner);
	    System.out.println(initial);
	}
    }
}
