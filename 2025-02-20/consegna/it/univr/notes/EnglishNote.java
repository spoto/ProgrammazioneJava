package it.univr.notes;

//una nota che si stampa secondo la modalità inglese
public class EnglishNote extends AbstractNote {

	/**
	 * Costruisce la nota.
	 * 
	 * @param semitone il semitono della nota
	 * @throws IllegalNoteException se il semitono è fuoti dai limiti 0...MAX_SEMITONE
	 */
	public EnglishNote(int semitone) throws IllegalNoteException {
		// completare
	}

	public Note shift(int howManySemitones) throws IllegalNoteException {
		// completare
	}

	// le 12 note inglesi
	private final static String[] NOTES = {
		"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"
	};

	// restituisce la rappresentazione di questa nota inglese, per esempio 3.A
	public String toString() {
		// completare
	}
}
