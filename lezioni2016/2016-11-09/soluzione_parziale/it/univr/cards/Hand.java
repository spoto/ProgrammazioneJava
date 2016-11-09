package it.univr.cards;

/**
 * Una mano di cinque carte.
 */
public class Hand {
	// stato degli oggetti
	private final Card[] cards;
	
	/**
	 * Costruisce una mano di cinque carte, a caso, ma senza ripetizioni.
	 * 
	 * @param min la carta minima che può essere generata
	 */
	public Hand(int min) {
		this.cards = new Card[5];

		for (int pos = 0; pos < this.cards.length; pos++)
			do {
				this.cards[pos] = new Card(min);
			}
			while (isDuplicate(pos));

		sort();
	}

	private void sort() {
		while (swap());
	}

	private boolean swap() {
		boolean done = false;
		for (int pos = 0; pos < cards.length - 1; pos++)
			if (cards[pos].compareTo(cards[pos + 1]) > 0) {
				// scambio
				Card temp = cards[pos];
				cards[pos] = cards[pos + 1];
				cards[pos + 1] = temp;
				done = true;
			}

		return done;
	}

	private boolean isDuplicate(int max) {
		for (int pos = 0; pos < max; pos++)
			if (this.cards[pos].equals(this.cards[max]))
				return true;
		
		return false;
	}

	/**
	 * Restituisce una descrizione stringa delle cinque carte.
	 */
	public String toString() {
		return cards[0].toString() + " " + cards[1].toString() + " " + cards[2].toString()
			+ " " + cards[3].toString() + " " + cards[4].toString();	
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
				if (cards[0].getValue() == 14 ||
					cards[1].getValue() == 14 ||
					cards[2].getValue() == 14 ||
					cards[3].getValue() == 14 ||
					cards[4].getValue() == 14)
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
		for (int pos = 0; pos < 5; pos++)
			if (isUnique(cards[pos].getValue()))
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
		for (int pos = 0; pos < cards.length; pos++)
			if (fourHaveValue(cards[pos].getValue()))
				return true;

		return false;
	}

	/**
	 * Determina se tre delle carte di questa mano hanno lo stesso valore.
	 *
	 * @return true se e solo se tre delle carte di questa mano hanno lo stesso valore
	 */
	private boolean threeOfAKind() {
		for (int pos = 0; pos < cards.length; pos++)
			if (threeHaveValue(cards[pos].getValue()))
				return true;

		return false;
	}

	private boolean fourHaveValue(int value) {
		return countHowManyHaveValue(value) == 4;
	}

	private boolean threeHaveValue(int value) {
		return countHowManyHaveValue(value) == 3;
	}


	private int countHowManyHaveValue(int value) {
		int count = 0;
		for (int pos = 0; pos < cards.length; pos++)
			if (cards[pos].getValue() == value)
				count++;

		return count;
	}

	/**
	 * Determina se tre delle carte di questa mano hanno lo stesso valore e le altre due un altro valore (uguale).
	 *
	 * @return true se e solo se tre delle carte di questa mano hanno lo stesso valore e le altre due un altro valore (uguale)
	 */
	private boolean fullHouse() {
		return false;
		/*
		int first = card1.getValue();
		int firstHowMany = 1;
		int second = 0;
		int secondHowMany = 0;

		if (card2.getValue() == first)
			firstHowMany++;
		else if (second == 0) {
			second = card2.getValue();
			secondHowMany = 1;
		}
		else if (card2.getValue() == second)
			secondHowMany++;countHowManyHaveValue
		else
			return false;

		if (card3.getValue() == first)
			firstHowMany++;
		else if (second == 0) {
			second = card3.getValue();
			secondHowMany = 1;
		}
		else if (card3.getValue() == second)
			secondHowMany++;
		else
			return false;

		if (card4.getValue() == first)
			firstHowMany++;
		else if (second == 0) {
			second = card4.getValue();
			secondHowMany = 1;
		}
		else if (card4.getValue() == second)
			secondHowMany++;
		else
			return false;

		if (card5.getValue() == first)
			firstHowMany++;
		else if (second == 0) {
			second = card5.getValue();
			secondHowMany = 1;
		}
		else if (card5.getValue() == second)
			secondHowMany++;
		else
			return false;

		return firstHowMany == 3 || secondHowMany == 3;
		*/
	}

	/**
	 * Determina se le carte di questa mano sono in scala, senza buchi.
	 * 
	 * @return true se e solo se le carte sono in scala e senza buchi
	 */
	private boolean isStraight() {
		if (allHaveDifferentValues()) {
			int v1 = cards[0].getValue();
			int v2 = cards[1].getValue();
			int v3 = cards[2].getValue();
			int v4 = cards[3].getValue();
			int v5 = cards[4].getValue();

			return Math.max(v1, Math.max(v2, Math.max(v3, Math.max(v4, v5))))
				- Math.min(v1, Math.min(v2, Math.min(v3, Math.min(v4, v5)))) == 4;
		}
		else
			return false;
	}

	private boolean allHaveDifferentValues() {
		for (int pos = 0; pos < cards.length; pos++)
			if (!isUnique(cards[pos].getValue()))
				return false;

		return true;
	}

	/**
	 * Determina se le carte di questa mano hanno tutte lo stesso seme.
	 * 
	 * @return true se e solo se le carte hanno lo stesso colore
	 */
	private boolean sameSuit() {
		for (int pos = 1; pos < cards.length; pos++)
			if (cards[pos].getSuit() != cards[0].getSuit())
				return false;

		return true;
	}






}