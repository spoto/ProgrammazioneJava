package it.univr.circuit;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		// creiamo l'insieme di tutte le variabili
		Set<String> allVariables = new HashSet<String>();
		allVariables.add("v");
		allVariables.add("w");
		allVariables.add("x");
		allVariables.add("y");
		allVariables.add("z");
		allVariables.add("a");
		allVariables.add("b");

		// solo v e y sono vere in questo assegnamento
		Assignment assignment = new Assignment("v", "y");

		// stampiamo 100 circuiti a caso e il loro valore di verità nell'assegnamento;
		// nel frattempo li aggiungiamo a un insieme di circuiti
		Set<Circuit> allCircuits = new HashSet<Circuit>();

		for (int i = 0; i < 100; i++) {
			Circuit circuit = Circuit.mkRandom(3, allVariables);
			System.out.printf("%30s:%s\n", circuit, circuit.isTrueIn(assignment));
			allCircuits.add(circuit);
		}

		// stampiamo i circuiti che abbiamo generato
		System.out.println("Tutti i circuiti generati: " + allCircuits);

		// sono 100? o forse meno?
		System.out.println("In totale ho generato " + allCircuits.size() + " circuiti");

		// adesso facciamo le cose complesse:
		// generiamo molti circuiti e di profondità maggiore;
		// prendiamo anche nota del tempo che ci mettiamo
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++)
			allCircuits.add(Circuit.mkRandom(5, allVariables));
		long elapsed = System.currentTimeMillis() - start;

		// sono 10100? o forse meno?
		System.out.println("In totale ho generato " + allCircuits.size()
			+ " circuiti in " + elapsed + "ms");		
	}
}