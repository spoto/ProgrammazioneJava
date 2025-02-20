package it.univr.notes;

import java.util.Iterator;
import java.util.List;

// implementazione concreta di una canzone, cioè di una sequenza di note
public class BasicSong extends AbstractSong {

	// le note di questa canzone
	private final List<Note> sequence;

	// costruisce una canzone fatta dalle note indicate
	public BasicSong(Note... notes) {
		// completare
	}

	public Iterator<Note> iterator() {
		// completare
	}

	public Song shift(int howManySemitones) throws IllegalNoteException {
		// completare
	}
}