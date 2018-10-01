package it.univr.music;

public class ItalianNote extends Note {
	public final static ItalianNote DO = new ItalianNote(0);
	public final static ItalianNote DO_DIESIS = new ItalianNote(1);
	public final static ItalianNote RE = new ItalianNote(2);
	public final static ItalianNote RE_DIESIS = new ItalianNote(3);
	public final static ItalianNote MI = new ItalianNote(4);
	public final static ItalianNote FA = new ItalianNote(5);
	public final static ItalianNote FA_DIESIS = new ItalianNote(6);
	public final static ItalianNote SOL = new ItalianNote(7);
	public final static ItalianNote SOL_DIESIS = new ItalianNote(8);
	public final static ItalianNote LA = new ItalianNote(9);
	public final static ItalianNote LA_DIESIS = new ItalianNote(10);
	public final static ItalianNote SI = new ItalianNote(11);

	private ItalianNote(int semitone) {
		super(semitone);
	}

	private final static String[] names
		= { "do", "do#", "re", "re#", "mi", "fa", "fa#", "sol", "sol#", "la", "la#", "si" };

	@Override
	public String toString() {
		return names[semitone];
	}
}