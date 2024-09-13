package it.univr.corso;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Un esame di un corso di laurea, con il nome dell'esame e il corso
 * di laurea a cui appartiene.
 */
public class Esame {
	// aggiungete campi se servissero

	/**
	 * Crea un esame con il nome indicato, per il corso indicato, inizialmente senza iscritti.
	 */
	public Esame(String nome, Corso corso) {
		// completare
	}

	/**
	 * Iscrive lo studente indicato a questo esame.
	 * 
	 * @throws StudenteIllegaleException se ci fosse già uno studente
	 *                                   iscritto a questo esame con la stessa matricola
	 */
	public void iscrivi(Studente studente) throws StudenteIllegaleException {
		// completare
	}

	@Override
	public String toString() {
		// restituisce la stringa ottenuta concatenando tutti gli iscritti all'esame
		// in ordine crescente per matricola; all'inizio riporta nome dell'esame e corso;
		// si veda l'esempio nel testo del compito
		
		// completare
	}

	/**
	 * Esegue l'azione indicata per ogni studente iscritto che soddisfa
	 * la condizione indicata.
	 */
	public void perOgniIscritto(Predicate<Studente> condizione, Consumer<Studente> azione) {
		// completare
	}
}
