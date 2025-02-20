package it.univr.notes;

/**
 * Una nota musicale, identificata dal suo semitono: da 0 (nota più bassa)
 * fino a MAX_SEMITONE (nota più alta).
 * 
 * Interfaccia completa, non modificate nulla.
 */
public interface Note {

	// il semitono massimo delle note: è l'ultimo semitono valido
	final int MAX_SEMITONE = 5 * 12 - 1;

	// restituisce il semitono di questa nota
	int getSemitone();

	// restituisce una descrizione stringa di questa nota
	String toString();

	// restituisce una nota howManySemitones più in alta di questa nota
	// (o più bassa, se howManySemitones fosse negativo); la nota
	// risultante deve essere dello stesso tipo di questa nota
	// (una ItalianNote restituisce una ItalianNote ecc.);
	// lancia una IllegalNoteException se il risultato è fuori dai
	// limiti 0...MAX_SEMITONE
	Note shift(int howManySemitones) throws IllegalNoteException;
}