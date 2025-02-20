package it.univr.notes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// implementazione concreta di una canzone, cioè di una sequenza di note
public class BasicSong extends AbstractSong {
	private final List<Note> sequence;

	// costruisce una canzone fatta dalle note indicate
	public BasicSong(Note... notes) {
		this.sequence = new ArrayList<>();

		for (Note note: notes)
			sequence.add(note);
	}

	private BasicSong(List<Note> sequence) {
		this.sequence = sequence;
	}

	public Iterator<Note> iterator() {
		return sequence.iterator();
	}

	public Song shift(int howManySemitones) throws IllegalNoteException {
		List<Note> newSequence = new ArrayList<>();
		for (Note note: sequence)
			newSequence.add(note.shift(howManySemitones));

		return new BasicSong(newSequence);
	}
}