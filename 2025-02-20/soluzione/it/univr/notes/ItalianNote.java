package it.univr.notes;

// una nota che si stampa secondo la modalità italiana
public class ItalianNote extends AbstractNote {

	/**
	 * Costruisce la nota.
	 * 
	 * @param semitone il semitono della nota
	 * @throws IllegalNoteException se il semitono è fuoti dai limiti 0...MAX_SEMITONE
	 */
	public ItalianNote(int semitone) throws IllegalNoteException {
		super(semitone);
	}

	public Note shift(int howManySemitones) throws IllegalNoteException {
		return new ItalianNote(getSemitone() + howManySemitones);
	}

	// le 12 note italiane
	private final static String[] NOTES = {
		"do", "do#", "re", "re#", "mi", "fa", "fa#", "sol", "sol#", "la", "la#", "si"
	};

	// restituisce la rappresentazione di questa nota italiana, per esempio 2.fa#
	public String toString() {
		int semitone = getSemitone();
		return (semitone / 12 + 1) + "." + NOTES[semitone % 12];
	}
}
