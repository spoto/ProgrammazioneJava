public class Cornice2 {
    public static void main(String[] args) {
	System.out.print("Inserisci il messaggio: ");
	String messaggio = new java.util.Scanner(System.in).nextLine();
	int dim = messaggio.length() + 4;

	// inverte messaggio
	String inversa = "";
	for (int pos = 0; pos < messaggio.length(); pos++)
	    inversa = messaggio.substring(pos, pos + 1)
		+ inversa;

	messaggio = inversa;

	// stampa una riga di dim @
	for (int i = 0; i < dim; i++)
	    System.out.print("@");

	System.out.println();

	System.out.println("@ " + messaggio + " @");

	// stampa una riga di dim @
	for (int i = 0; i < dim; i++)
	    System.out.print("@");

	System.out.println();
    }
}
