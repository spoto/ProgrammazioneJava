package it.univr.cards;

import java.util.Random;

/**
 * Una carta da gioco.
 */
public class Card {
	// stato degli oggetti
	private final int value;
	private final int suit;

	// costanti per il seme: non sono stato degli oggetti
	// spades (♠), hearts (♥), diamonds (♦) and clubs (♣)
	private final static int SPADES = 0;
	private final static int HEARTS = 1;
	private final static int DIAMONDS = 2;
	private final static int CLUBS = 3;
	
	// usato per generare carte casualmente
	private final static Random random = new Random();

	/**
	 * Genera una carta a caso da min (incluso) in su.
	 * 
	 * @param min la carta minima che può essere generata (2-14)
	 */
	public Card(int min) {
		this.value = min + random.nextInt(15 - min);
		this.suit = random.nextInt(4);
	}

	/**
	 * Genera una carta a caso.
	 */
	public Card() {
		this(1);
	}

	public int getValue() {
		return value;
	}

	public int getSuit() {
		return suit;
	}

	/**
	 * Ritorna una descrizione della carta sotto forma di stringa.
	 */
	public String toString() {
		String result;

		switch (value) {
		case 11: result = "J"; break;
		case 12: result = "Q"; break;
		case 13: result = "K"; break;
		case 14: result = "1"; break;
		default: result = String.valueOf(value); break;
		}

		switch (suit) {
		case SPADES: result += "\u2660"; break;
		case HEARTS: result += "\u2665"; break;
		case DIAMONDS: result += "\u2666"; break;
		case CLUBS: result += "\u2663"; break;
		}

		return result;
	}

	/**
	 * Determina se questa carta e uguale ad other.
	 * 
	 * @param other l'altra carta
	 * @return true se e solo se le due carte sono uguali
	 */
	public boolean equals(Card other) {
		return value == other.value && suit == other.suit;
	}
}