package it.univr.cards;

public class Hand {

	private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;
	private Card card5;
	  
	/**
	 * Costruisce una mano di cinque carte, a caso, ma senza ripetizioni.
	 * 
	 * @param min la carta minima che può essere generata
	 */
	public Hand(int min) {
		card1 = new Card(min);

		do {
			card2 = new Card(min);
		}
		while (card1.equals(card2));

		do {
			card3 = new Card(min);
		}
		while (card1.equals(card3) || card2.equals(card3));

		do {
			card4 = new Card(min);
		}
		while (card1.equals(card4) || card2.equals(card4) || card3.equals(card4));

		do {
			card5 = new Card(min);
		}
		while (card1.equals(card5) || card2.equals(card5) || card3.equals(card5) || card4.equals(card5));
	}

	/**
	 * Restituisce una descrizione stringa delle cinque carte, del tipo:
	 * Q♦ 10♠ K♠ 7♣ J♥
	 */
	public String toString() {
		return card1.toString() + " " + card2.toString() + " " + card3.toString() + " "
				+ card4.toString() + " " + card5.toString();
	}

	/**
	 * Ritorna la categoria di questa mano di carte:
	 * https://it.wikipedia.org/wiki/Punti_del_poker
	 * 
	 * Le possibilità sono:
	 * <lu>
	 * <li> "royal flush" (scala reale)
	 * <li> "straight flush" (scala a colore)
	 * <li> "four of a kind" (poker)
	 * <li> "full house" (full)
	 * <li> "flush" (colore)
	 * <li> "straight" (scala)
	 * <li> "three of a kind" (tris)
	 * <li> "two pairs" (doppia coppia)
	 * <li> "pair" (coppia)
	 * <li> "high card" (carta isolata)
	 * </lu>
	 * 
	 * @return
	 */
	public String category() {
		return "unknown";
	}
}
