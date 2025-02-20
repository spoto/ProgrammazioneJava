package it.univr.notes;

/**
 * Una canzone, cioè una sequenza di note. Iterando su una canzone
 * si ottengono le note della canzone in sequenza.
 * 
 * Interfaccia completa, non modificate nulla.
 */
public interface Song extends Iterable<Note> {

	// restituisce la descrizione delle note di questa canzone,
	// separate da spazi
	String toString();

	// restituisce una canzone ottenuta alzando ciascuna nota di questa canzone
	// di howManySemitones (o abbassandola, se howManySemitones fosse negativo);
	// lancia una IllegalNoteException se almeno una nota del risultato
	// finisce fuoti dai limiti 0...MAX_SEMITONE
	Song shift(int howManySemitones) throws IllegalNoteException;
}
