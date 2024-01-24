package it.univr.music;

public abstract class Note implements Comparable<Note> {
	protected final int semitone;

	protected Note(int semitone) {
		if (semitone < 0 || semitone > 11)
			throw new IllegalArgumentException();

		this.semitone = semitone;
	}

	@Override
	public abstract String toString();

	@Override
	public final boolean equals(Object other) {
		return other instanceof Note && ((Note) other).semitone == semitone;
	}

	@Override
	public final int hashCode() {
		return semitone;
	}

	@Override
	public final int compareTo(Note other) {
		return semitone - other.semitone;
	}
}