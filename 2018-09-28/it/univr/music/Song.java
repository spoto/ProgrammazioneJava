package it.univr.music;

import java.util.SortedMap;
import java.util.TreeMap;

public class Song {
	private final String lyrics;
	private final SortedMap<Integer, Note> notes = new TreeMap<>();

	public Song(String lyrics) {
		this.lyrics = lyrics;
	}

	public void add(Note note, int position) {
		if (position < 0 || position >= lyrics.length())
			throw new IllegalArgumentException();

		if (notes.containsKey(position))
			throw new NoteAtSamePositionException();

		notes.put(position, note);
	}

	@Override
	public String toString() {
		String result = "";
		while (result.length() < lyrics.length())
			result += " ";

		for (Integer position: notes.keySet())
			result = replace(result, position, notes.get(position).toString());

		return result + '\n' + lyrics;
	}

	private static String replace(String original, int position, String what) {
		int finalPosition = position + what.length();
		if (finalPosition < original.length())
			return original.substring(0, position).concat(what).concat(original.substring(finalPosition));
		else
			return original.substring(0, position).concat(what);
	}
}