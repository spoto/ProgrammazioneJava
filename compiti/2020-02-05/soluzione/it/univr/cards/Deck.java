package it.univr.cards;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Un mazzo di cinque carte.
 */
public class Deck {

	/**
	 * Le cinque carte che compongono questo mazzo.
	 */
	private final Card[] cards;

	/**
	 * Costruisce un mazzo di cinque carte, tutte diverse.
	 */
	public Deck() {
		// faccio in modo che le carte siano ordinate in ordine crescente,
		// in modo da semplificare i controlli sul ranking
		SortedSet<Card> temp = new TreeSet<>();
		while (temp.size() < 5)
			temp.add(new Card());

		cards = temp.toArray(new Card[5]);
	}

	/**
	 * Costruisce un mazzo con le cinque carte indicate. Attenzione
	 * all'eccezione che dovete lanciare se ci fossero carte ripetute!
	 * 
	 * @throws IllegalArgumentException se ci fossero carte ripetute (cioe' equals)
	 */
	public Deck(Card c1, Card c2, Card c3, Card c4, Card c5) throws IllegalArgumentException {
		// faccio in modo che le carte siano ordinate in ordine crescente,
		// in modo da semplificare i controlli sul ranking
		SortedSet<Card> temp = new TreeSet<>();
		temp.add(c1);
		temp.add(c2);
		temp.add(c3);
		temp.add(c4);
		temp.add(c5);
		if (temp.size() < 5)
			throw new IllegalArgumentException("the five cards must be different");

		cards = temp.toArray(new Card[5]);
	}
	/**
	 * Restituisce una stringa che descrive le carte in questo mazzo,
	 * costruita come le loro stampe, separate da virgola,
	 * con parentesi quadre all'inizio e alla fine.
	 * 
	 * @return la stringa
	 */
	public String toString() {
		return Arrays.toString(cards);
	}

	/**
	 * Determina se le cinque carte hanno tutte lo stesso seme.
	 */
	private boolean sameSuit() {
		Suit first = cards[0].getSuit();
		for (Card card: cards)
			if (card.getSuit() != first)
				return false;

		return true;
	}

	/**
	 * Determina se le cinque carte possono essere messe in sequenza, per esempio 9,Q,J,10,K.
	 */
	private boolean inSequence() {
		// dal momento che sono diverse e in ordine crescente,
		// basta controllare che ogni carta abbia esattamente il valore
		// della precedente piu' 1
		for (int pos = 1; pos < 5; pos++)
			if (cards[pos].getValue().ordinal() != cards[pos - 1].getValue().ordinal() + 1)
				return false;

		return true;
	}

	/**
	 * Determina se il ranking di questo mazzo e' "straight" (in italiano: "scala").
	 */
	public boolean isStraight() {
		// in sequenza ma non tutte dello stesso seme
		return inSequence() && !sameSuit();
	}

	/**
	 * Determina se il ranking di questo mazzo e' "flush" (in italiano: "colore").
	 */
	public boolean isFlush() {
		// dello stesso seme ma non in sequenza
		return sameSuit() && !inSequence();
	}

	/**
	 * Determina se il ranking di questo mazzo e' "straight flush" (in italiano: "scala reale").
	 */
	public boolean isStraightFlush() {
		return sameSuit() && inSequence();
	}

	/**
	 * Determina se il ranking di questo mazzo e' "four of a kind" (in italiano: "poker").
	 */
	public boolean isFourOfKind() {
		// dal momento che sono in ordine crescente, o le prime 4 hanno
		// lo stesso valore, oppure le ultime 4 hanno lo stesso valore
		Value first = cards[0].getValue(), last = cards[4].getValue();
		return (first == cards[1].getValue() && first == cards[2].getValue() && first == cards[3].getValue())
			|| (last == cards[1].getValue() && last == cards[2].getValue() && last == cards[3].getValue());
	}

	/**
	 * Determina se il ranking di questo mazzo e' "full house" (in italiano: "full").
	 */
	public boolean isFullHouse() {
		// dal momento che sono in ordine crescente, le prime due devono avere lo stesso valore,
		// le ultime due devono avere lo stesso valore, quella centrale deve avere lo stesso valore
		// della prima o dell'ultima
		Value first = cards[0].getValue(), last = cards[4].getValue(), middle = cards[2].getValue();
		return first == cards[1].getValue() && last == cards[3].getValue() && (first == middle || last == middle);
	}

	/**
	 * Determina se il ranking di questo mazzo e' "three of kind" (in italiano: "tris").
	 */
	public boolean isThreeOfKind() {
		// non e' ne' four of kind ne' full house. Inoltre,
		// dal momento che le carte sono in ordine crescente, la carta centrale
		// deve avere lo stesso valore di altre due carte
		if (!isFourOfKind() && !isFullHouse()) {
			Value middle = cards[2].getValue();
			int counter = 0;
			for (Card card: cards)
				if (card.getValue() == middle)
					counter++;

			return counter == 3; // 3 perche' e' inclusa se stessa
		}

		return false;
	}

	public Ranking getRanking() {
		if (isThreeOfKind())
			return Ranking.THREE_OF_KIND;
		else if (isStraight())
			return Ranking.STRAIGHT;
		else if (isFlush())
			return Ranking.FLUSH;
		else if (isFullHouse())
			return Ranking.FULL_HOUSE;
		else if (isFourOfKind())
			return Ranking.FOUR_OF_KIND;
		else if (isStraightFlush())
			return Ranking.STRAIGHT_FLUSH;
		else
			return Ranking.NONE;
	}

	public boolean hasRankingFrom(Ranking minimum) {
		return getRanking().compareTo(minimum) >= 0;
	}
}