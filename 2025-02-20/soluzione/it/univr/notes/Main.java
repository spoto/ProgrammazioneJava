package it.univr.notes;

public class Main {

	public static void main(String[] args) throws IllegalNoteException {
		// una canzone fatta da 4 note
		Song s1 = new BasicSong(new ItalianNote(5), new ItalianNote(25), new EnglishNote(13), new EnglishNote(38));
		// una scala dalla nota inglese di semitono 20 in su, fino alla nota inglese di semitono 31
		Song s2 = new Scale(new EnglishNote(20));
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s1.shift(-3) = " + s1.shift(-3));
		System.out.println("s2.shift(4) = " + s2.shift(4));
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		s2.shift(29); // va in eccezione, perché l'ultima nota di s2 esce dai limiti 0...MAX_SEMITONE
	}
}