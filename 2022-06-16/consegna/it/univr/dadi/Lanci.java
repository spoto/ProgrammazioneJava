package it.univr.dadi;

/**
 * Una classe che rappresenta l'esecuzione di piu' lanci con dei dadi.
 * Permette di vedere i risultati ottenuti e la frequenza dei numeri ottenuti.
 */
public class Lanci {

	/**
	 * Costruisce un'esecuzione di quanti lanci con i dadi indicati.
	 * Questo costruttore eseguire i lanci richiesti con i dadi forniti
	 * e si salvera' le informazioni necessarie a implementare i metodi
	 * della classe.
	 * 
	 * @param quanti il numero di lanci da eseguire
	 * @param dadi i dadi da lanciare. Per ogni lancio, il risultato e'
	 *             la somma dei risultati di ciascun dado
	 * @throws IllegalArgumentException se quanti non e' positivo oppure
	 *         se non vengono forniti dadi da lanciare
	 */
	public Lanci(int quanti, Dado... dadi) {
		// completare
	}

	/**
	 * Restituisce la sequenza dei risultati ottenuti dal costruttore lanciando i dadi.
	 * Sara' una stringa fatta da una sequenza, fra parentesi quadre, di numeri separati da virgola.
	 */
	@Override
	public final String toString() {
		// completare
	}

	/**
	 * Restituisce una rappresentazione a istogramma delle frequenze dei
	 * numeri ottenuti dal costruttore lanciando i dadi. Per ogni numero
	 * ottenuto, questi istogramma rappresentano quante volte quel numero e' stato
	 * ottenuto. Gli istogrammi sono fatti da una sequenza di asterischi lunga
	 * in modo proporzionale alla frequenza, seguita dalla frequenza tra parentesi
	 * tonde. Si vedano gli esempi nel testo del compito.
	 */
	public final String frequenze() {
		// completare
	}

	/**
	 * Restituisce una barra di linghezza proporzianale
	 * alla frequenza indicata con cui si e' ottenuto il risultato "i" lanciando i dadi.
	 * Si trattera' di una sequenza di asterischi. Per esempio, se il numero 4
	 * fosse uscito nel 15.3% dei casi, allora questo metodo verra' chiamato con i = 4
	 * e frequenza = 15.3 e dovra' ritornare 15 asterischi.
	 */
	protected String barra(int i, double frequenza) {
		// completare
	}
}
