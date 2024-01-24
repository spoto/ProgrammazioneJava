package it.univr.music;

public class EnglishNote extends Note {
	public final static EnglishNote C = new EnglishNote(0);
	public final static EnglishNote C_SHARP = new EnglishNote(1);
	public final static EnglishNote D = new EnglishNote(2);
	public final static EnglishNote D_SHARP = new EnglishNote(3);
	public final static EnglishNote E = new EnglishNote(4);
	public final static EnglishNote F = new EnglishNote(5);
	public final static EnglishNote F_SHARP = new EnglishNote(6);
	public final static EnglishNote G = new EnglishNote(7);
	public final static EnglishNote G_SHARP = new EnglishNote(8);
	public final static EnglishNote A = new EnglishNote(9);
	public final static EnglishNote A_SHARP = new EnglishNote(10);
	public final static EnglishNote B = new EnglishNote(11);

	private EnglishNote(int semitone) {
		super(semitone);
	}

	private final static String[] names
		= { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" };

	@Override
	public String toString() {
		return names[semitone];
	}
}