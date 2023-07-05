package it.univr.sets;

public class Main {

	public static void main(String[] args) {
		new Main(new String[] { "Fausto", "Samantha", "Giulio", "Giovanna" });
	}

	/**
	 * Crea alcuni insieme contenenti i nomi indicati e li stampa.
	 */
	private Main(String[] names) {
		// crea un PunishableSet contenente names inizializzati a 1000 punti
		PunishableSet<String> set1 = null; // COMPLETARE
		play("set1", set1);

		// crea un PunishableSet contenente names inizializzati a una
		// quantita' di punti pari alla propria lunghezza (cioè Aurora 6 punti,
		// Samatha 7 punti ecc.)
		PunishableSet<String> set2 = null; // COMPLETARE
		play("set2", set2);

		// crea un PunishableSet contenente names inizializzati a una
		// quantita' di punti pari al proprio numero di vocali (cioè Fausto 3 punti,
		// Giulio 4 punti ecc.)
		PunishableSet<String> set3 = null; // COMPLETARE
		play("set3", set3);

		// crea un PunishableSet contenente names inizializzati a 2000 punti
		PunishableSet<String> set4 = null; // COMPLETARE
		play("set4", set4);

		// crea un PunishableSet contenente names inizializzati a 600 punti,
		// in modo che quando si aggiunge un elemento "s" venga stampato "adding s"
		// e che quando si rimuove un elemento "s" venga stampato "removing s"
		PunishableSet<String> set5 = null; // COMPLETARE
		play("set5", set5);

		// questo dovrebbe generare una IllegalArgumentException perché points è negativo
		set5.punish("Fausto", -2);
	}

	// esegue alcune operazioni sull'insieme "set" e alla fine lo stampa
	private void play(String setName, PunishableSet<String> set) {
		set.add("Aurora");
		set.punish("Fausto", 500);
		set.punish("Giovanna", 100);
		set.punish("Giovanna", 900);
		set.remove("Giulio");
		set.remove("Giulia");
		System.out.println(setName + ":\n" + set + "\n");
	}

	// conta il numero di vocali contenute in "s"
	private int countVowels(String s) {
		int counter = 0;

		for (int pos = 0; pos < s.length(); pos++)
			if ("aeiouAEIOU".indexOf(s.charAt(pos)) != -1)
				counter++;

		return counter;
	}

	// stampa "adding s"
	private void adding(String s) {
		System.out.println("adding " + s);
	}

	// stampa "removing s"
	private void removing(String s) {
		System.out.println("removing " + s);
	}
}
