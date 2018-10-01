package it.univr.music;

public class Main {

	public static void main(String[] args) {
		Song yellowSubmarine = new Song("In the town where I was born lived a man who sailed the sea");
		yellowSubmarine.add(EnglishNote.C_SHARP, 7);  // C# su "town"
		yellowSubmarine.add(EnglishNote.C_SHARP, 56); // C# su "sea"
		yellowSubmarine.add(EnglishNote.F_SHARP, 24); // F# su "born"
		yellowSubmarine.add(EnglishNote.G_SHARP, 37); // G# su "man"
		// yellowSubmarine.add(EnglishNote.A, 24); // questo genenerebbe una NoteAtSamePositionException

		System.out.println(yellowSubmarine);
	}
}