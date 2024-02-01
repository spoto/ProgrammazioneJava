package it.univr.sudoku;

// enumerazione di 9 emoji: non modificate
public enum Emoji {
	GRINNING("😀"),
	MONEY("🤑"),
	THINKING("🤔"),
	LAUGHING("🤣"),
	TONGUE("😛"),
	HEARTS("😍"),
	MELTING("🫠"),
	HALO("😇"),
	UPSIDE_DOWN("🙃");

	private final String s;

	private Emoji(String s) {
		this.s = s;
	}

	public String toString() {
		return s;
	}
}
