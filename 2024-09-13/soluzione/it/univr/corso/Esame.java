package it.univr.corso;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Un esame di un corso di laurea, con il nome dell'esame e il corso
 * di laurea a cui appartiene.
 */
public class Esame {
	private final String nome;
	private final Corso corso;
	private final SortedSet<Studente> iscritti = new TreeSet<>();

	/**
	 * Crea un esame con il nome indicato, per il corso indicato, inizialmente senza iscritti.
	 */
	public Esame(String nome, Corso corso) {
		this.nome = nome;
		this.corso = corso;
	}

	/**
	 * Iscrive lo studente indicato a questo esame.
	 * 
	 * @throws StudenteIllegaleException se ci fosse gia' uno studente
	 *                                   iscritto a questo esame con la stessa matricola
	 */
	public void iscrivi(Studente studente) throws StudenteIllegaleException {
		if (!iscritti.add(studente))
			throw new StudenteIllegaleException("Esiste gia' uno studente iscritto con matricola " + studente.getMatricola());
	}

	@Override
	public String toString() {
		// restituisce la stringa ottenuta concatenando tutti gli iscritti all'esame
		// in ordine crescente per matricola; all'inizio riporta nome dell'esame e corso
		return "Esame di " + nome + " del corso di " + corso + ":\n" +
			iscritti.stream()
				.map(Studente::toString)
				.collect(Collectors.joining("\n"));
	}

	/**
	 * Esegue l'azione indicata per ogni studente iscritto che soddisfa
	 * la condizione indicata.
	 */
	public void perOgniIscritto(Predicate<Studente> condizione, Consumer<Studente> azione) {
		iscritti.stream().filter(condizione).forEachOrdered(azione);
	}
}