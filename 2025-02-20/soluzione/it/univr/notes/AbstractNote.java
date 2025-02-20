package it.univr.notes;

/**
 * Implementazione parziale di una nota: implementa
 * la costruzione a partire dal semitono e l'accesso al semitono.
 */
public abstract class AbstractNote implements Note {
	private final int semitone;

	/**
	 * Costruisce la nota.
	 * 
	 * @param semitone il semitono della nota
	 * @throws IllegalNoteException se il semitono è fuoti dai limiti 0...MAX_SEMITONE
	 */
	protected AbstractNote(int semitone) throws IllegalNoteException {
		if (semitone < 0 || semitone > MAX_SEMITONE)
			throw new IllegalNoteException("Le note devono avere un semitono tra 0 e " + MAX_SEMITONE + " inclusi");

		this.semitone = semitone;
	}

	public final int getSemitone() {
		return semitone;
	}
}