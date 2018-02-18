package it.univr.hairbnb;

public class Review {

	public enum Stars {
		ONE,
		TWO,
		THREE,
		FOUR,
		FIVE
	}

	private final String author;
	private final String text;
	private final Stars stars;

	public Review(String author, String text, Stars stars) {
		this.author = author;
		this.text = text;
		this.stars = stars;
	}

	@Override
	public String toString() {
		return author + " (" + stars() + ")\n" + text + "\n";
	}

	private String stars() {
		switch (stars) {
		case ONE: return "*";
		case TWO: return "**";
		case THREE: return "***";
		case FOUR: return "****";
		default: return "*****";
		}
	}

	public int howManyStars() {
		switch (stars) {
		case ONE: return 1;
		case TWO: return 2;
		case THREE: return 3;
		case FOUR: return 4;
		default: return 5;
		}
	}
}