package it.univr.notes;

// implementazione parziale di una canzone: solo il metodo toString()
public abstract class AbstractSong implements Song {

	public final String toString() {
		String result = "";
		for (Note note: this) {
			if (!result.isEmpty())
				result += " ";

			result += note;
		}

		return result;
	}
}
