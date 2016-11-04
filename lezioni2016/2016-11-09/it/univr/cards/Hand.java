package it.univr.cards;

/**
 * Una mano di cinque carte.
 */
public class Hand {
	// stato degli oggetti
	private final Card card1;
	private final Card card2;
	private final Card card3;
	private final Card card4;
	private final Card card5;
	
	/**
	 * Costruisce una mano di cinque carte, a caso, ma senza ripetizioni.
	 * 
	 * @param min la carta minima che può essere generata
	 */
	public Hand(int min) {
		card1 = new Card(min);

		Card next;

		do {
			next = new Card(min);
		}
		while (next.equals(card1));

		card2 = next;

		do {
			next = new Card(min);
		}
		while (next.equals(card1) || next.equals(card2));

		card3 = next;

		do {
			next = new Card(min);
		}
		while (next.equals(card1) || next.equals(card2) || next.equals(card3));

		card4 = next;

		do {
			next = new Card(min);
		}
		while (next.equals(card1) || next.equals(card2) || next.equals(card3) || next.equals(card4));

		card5 = next;
	}

	/**
	 * Restituisce una descrizione stringa delle cinque carte.
	 */
	public String toString() {
		return card1.toString() + " " + card2.toString() + " " + card3.toString()
			+ " " + card4.toString() + " " + card5.toString();	
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
		if (isStraight())
			if (sameSuit())
				if (card1.getValue() == 14 || card2.getValue() == 14 || card3.getValue() == 14 || card4.getValue() == 14 || card5.getValue() == 14)
					return "royal flush";
				else
					return "straight flush";
			else
				return "straight";
		else if (sameSuit())
			return "flush";
		else if (fourOfAKind())
			return "four of a kind";
		else if (fullHouse())
			return "full house";
		else if (threeOfAKind())
			return "three of a kind";
		else if (onlyOneIsUnique())
			return "two pairs";
		else if (allHaveDifferentValues())
			return "high card";
		else
			return "one pair";
	}

	/**
	 * Determina se solo una carta di questa mano è unica nella mano.
	 * 
	 * @return true se e solo se una sola carta di questa mano è unica nella mano
	 */
	private boolean onlyOneIsUnique() {
		int count = 0;

		if (isUnique(card1.getValue()))
			count++;
		if (isUnique(card2.getValue()))
			count++;
		if (isUnique(card3.getValue()))
			count++;
		if (isUnique(card4.getValue()))
			count++;
		if (isUnique(card5.getValue()))
			count++;

		return count == 1;
	}

	private boolean isUnique(int value) {
		return countHowManyHaveValue(value) == 1;
	}

	/**
	 * Determina se quattro delle carte di questa mano hanno lo stesso valore.
	 *
	 * @return true se e solo se quattro delle carte di questa mano hanno lo stesso valore
	 */
	private boolean fourOfAKind() {
		return fourHaveValue(card1.getValue()) ||
			fourHaveValue(card2.getValue()) ||
			fourHaveValue(card3.getValue()) ||
			fourHaveValue(card4.getValue()) ||
			fourHaveValue(card5.getValue());
	}

	/**
	 * Determina se tre delle carte di questa mano hanno lo stesso valore.
	 *
	 * @return true se e solo se tre delle carte di questa mano hanno lo stesso valore
	 */
	private boolean threeOfAKind() {
		return threeHaveValue(card1.getValue()) ||
			threeHaveValue(card2.getValue()) ||
			threeHaveValue(card3.getValue()) ||
			threeHaveValue(card4.getValue()) ||
			threeHaveValue(card5.getValue());
	}

	private boolean fourHaveValue(int value) {
		return countHowManyHaveValue(value) == 4;
	}

	private int countHowManyHaveValue(int value) {
		int count = 0;
		if (card1.getValue() == value)
			count++;
		if (card2.getValue() == value)
			count++;
		if (card3.getValue() == value)
			count++;
		if (card4.getValue() == value)
			count++;
		if (card5.getValue() == value)
			count++;
		return count;
	}

	private boolean threeHaveValue(int value) {
		int count = countHowManyHaveValue(value);

		return count == 3;
	}


	/**
	 * Determina se tre delle carte di questa mano hanno lo stesso valore e le altre due un altro valore (uguale).
	 *
	 * @return true se e solo se tre delle carte di questa mano hanno lo stesso valore e le altre due un altro valore (uguale)
	 */
	private boolean fullHouse() {
		int first = card1.getValue();
		int firstHowMany = 1;
		int second = 0;
		int secondHowMany = 0;

		if (card2.getValue() == first)
			firstHowMany++;
		else if (second == 0) {
			second = card2.getValue();
			secondHowMany++;
		}
		else if (card2.getValue() == second)
			secondHowMany++;
		else
			return false;

		if (card3.getValue() == first)
			firstHowMany++;
		else if (second == 0) {
			second = card3.getValue();
			secondHowMany++;
		}
		else if (card3.getValue() == second)
			secondHowMany++;
		else
			return false;

		if (card4.getValue() == first)
			firstHowMany++;
		else if (second == 0) {
			second = card4.getValue();
			secondHowMany++;
		}
		else if (card4.getValue() == second)
			secondHowMany++;
		else
			return false;

		if (card5.getValue() == first)
			firstHowMany++;
		else if (second == 0) {
			second = card5.getValue();
			secondHowMany++;
		}
		else if (card5.getValue() == second)
			secondHowMany++;
		else
			return false;

		return firstHowMany == 3 || secondHowMany == 3;
	}

	/**
	 * Determina se le carte di questa mano sono in scala, senza buchi.
	 * 
	 * @return true se e solo se le carte sono in scala e senza buchi
	 */
	private boolean isStraight() {
		int v1 = card1.getValue();
		int v2 = card2.getValue();
		int v3 = card3.getValue();
		int v4 = card4.getValue();
		int v5 = card5.getValue();

		return allHaveDifferentValues()
			&& Math.max(v1, Math.max(v2, Math.max(v3, Math.max(v4, v5)))) - Math.min(v1, Math.min(v2, Math.min(v3, Math.min(v4, v5)))) == 4;
	}

	private boolean allHaveDifferentValues() {
		int v1 = card1.getValue();
		int v2 = card2.getValue();
		int v3 = card3.getValue();
		int v4 = card4.getValue();
		int v5 = card5.getValue();

		return v1 != v2 && v1 != v3 && v1 != v4 && v1 != v5
			&& v2 != v3 && v2 != v4 && v2 != v5
			&& v3 != v4 && v3 != v5
			&& v4 != v5;
	}

	/**
	 * Determina se le carte di questa mano hanno tutte lo stesso seme.
	 * 
	 * @return true se e solo se le carte hanno lo stesso colore
	 */
	private boolean sameSuit() {
		int suit = card1.getSuit();
		
		return suit == card2.getSuit() && suit == card3.getSuit() && suit == card4.getSuit() && suit == card5.getSuit();
	}
}