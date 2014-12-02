package it.univr.circuit;

public class Main {

	public static void main(String[] args) {
		// creiamo l'insieme di tutte le variabili
		String[] allVariables = new String[] { "v", "w", "x", "y", "z", "a", "b" };

		// solo v e y sono vere in questo assegnamento
		Assignment assignment = new Assignment("v", "y");

		// stampiamo 100 circuiti a caso e il loro valore di verità nell'assegnamento;

		for (int i = 0; i < 100; i++) {
			Circuit circuit = Circuit.mkRandom(3, allVariables);
			System.out.printf
				("%30s:%s\n", circuit, circuit.isTrueIn(assignment));
		}
	}
}