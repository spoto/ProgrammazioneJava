package it.univr.notes;

/**
 * Implementazione parziale di una nota: implementa
 * la costruzione a partire dal semitono e l'accesso al semitono.
 */
public abstract class AbstractNote implements Note {

	// completare

	/**
	 * Costruisce la nota.
	 * 
	 * @param semitone il semitono della nota
	 * @throws IllegalNoteException se il semitono è fuoti dai limiti 0...MAX_SEMITONE
	 */
	protected AbstractNote(int semitone) throws IllegalNoteException {
		// completare
	}

	public final int getSemitone() {
		// completare
	}
}