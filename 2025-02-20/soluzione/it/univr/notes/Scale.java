package it.univr.notes;

import java.util.Iterator;

// implementazione di una scala, cioè di una canzone
// che parte da una nota e continua con le note
// successivamente più alte, per un totale di 12 note
public class Scale extends AbstractSong {
	private final Note start;
	public final static int LENGTH = 12;

	// costruisce una scala, cioè una canzone fatta dalle note
	//
	// start
	// start.shift(1)
	// start.shift(2)
	// ...
	// start.shift(11)
	//
	// lancia una IllegalNoteException
	// se una delle note della scala è fuori dai limiti 0...MAX_SEMITONE
	public Scale(Note start) throws IllegalNoteException {
		this.start = start;

		// è sufficiente controllare l'ultima nota, quella più acuta
		if (start.getSemitone() + LENGTH - 1 > Note.MAX_SEMITONE)
			throw new IllegalNoteException("Le note devono avere un semitono tra 0 e " + Note.MAX_SEMITONE + " inclusi");
	}

	public Iterator<Note> iterator() {
		return new Iterator<Note>() {
			private int counter;

			@Override
			public boolean hasNext() {
				return counter < LENGTH;
			}

			@Override
			public Note next() {
				try {
					return start.shift(counter++);
				}
				catch (IllegalNoteException e) {
					// impossibile, poiché il costruttore ha già verificato che siamo nei limiti;
					// andava bene anche return null
					throw new RuntimeException(e);
				}
			}
		};
	}

	public Song shift(int howManySemitones) throws IllegalNoteException {
		return new Scale(start.shift(howManySemitones));
	}
}