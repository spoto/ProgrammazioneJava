public class Cornice {
    public static void main(String[] args) {
	for (int dim = 2; dim <= 9; dim++)
	{
	    // stampa una riga di dim @
	    for (int i = 0; i < dim; i++)
		System.out.print("@");

	    System.out.println();

	    // stampa dim-2 righe fatte da una @,
	    // dim-2 spazi e una @
	    for (int i = 0; i < dim - 2; i++) {
		System.out.print("@");
		for (int j = 0; j < dim - 2; j++)
		    System.out.print(" ");
		System.out.println("@");
	    }

	    // stampa una riga di dim @
	    for (int i = 0; i < dim; i++)
		System.out.print("@");

	    System.out.println();
	}
    }
}
