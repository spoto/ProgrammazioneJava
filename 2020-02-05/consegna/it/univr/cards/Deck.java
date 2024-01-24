package it.univr.cards;

/**
 * Una mano di cinque carte.
 */
public class Deck {

	//TODO: servono campi?

	/**
	 * Costruisce una mano di cinque carte, tutte diverse.
	 */
	public Deck() {
		// TODO
	}

	/**
	 * Costruisce una mano con le cinque carte indicate. Attenzione
	 * all'eccezione che dovete lanciare se ci fossero carte ripetute!
	 * 
	 * @throws IllegalArgumentException se ci fossero carte ripetute (cioe' equals)
	 */
	public Deck(Card c1, Card c2, Card c3, Card c4, Card c5) throws IllegalArgumentException {
		// TODO
	}

	/**
	 * Restituisce una stringa che descrive le carte in questa mano,
	 * costruita come le loro stampe, separate da virgola,
	 * con parentesi quadre all'inizio e alla fine.
	 * Per esempio: [2♠, 5♠, 8♠, 10♠, Q♠]
	 * 
	 * @return la stringa
	 */
	public String toString() {
		return ""; //TODO
	}

	/**
	 * Determina se il ranking di questa mano e' "straight" (in italiano: "scala").
	 * Cioe' devono essere in sequenza ma non tutte dello stesso seme.
	 */
	public boolean isStraight() {
		return false; // TODO
	}

	/**
	 * Determina se il ranking di questa mano e' "flush" (in italiano: "colore").
	 * Cioe' devono essere tutte dello stesso seme ma non in sequenza.
	 */
	public boolean isFlush() {
		return false; // TODO
	}

	/**
	 * Determina se il ranking di questa mano e' "straight flush" (in italiano: "scala reale").
	 * Cioe' devono essere tutte dello stesso seme e in sequenza.
	 */
	public boolean isStraightFlush() {
		return false; // TODO
	}

	/**
	 * Determina se il ranking di questa mano e' "four of a kind" (in italiano: "poker").
	 * Cioe' quattro dello stesso valore e una di valore diverso.
	 */
	public boolean isFourOfKind() {
		return false; // TODO
	}

	/**
	 * Determina se il ranking di questa mano e' "full house" (in italiano: "full").
	 * Cioe' tre dello stesso valore e le altre due dello stesso valore.
	 */
	public boolean isFullHouse() {
		return false; // TODO
	}

	/**
	 * Determina se il ranking di questa mano e' "three of kind" (in italiano: "tris").
	 * Cioe' non deve essere four of kind, non deve essere full house e ci devono essere
	 * tre carte con lo stesso valore.
	 */
	public boolean isThreeOfKind() {
		return false; // TODO
	}

	/**
	 * Restituisce il ranking di questa mano. Per esempio,
	 * se questa mano isStraight() allora restituisce Ranking.STRAIGHT;
	 */
	public Ranking getRanking() {
		return Ranking.NONE; // TODO
	}

	/**
	 * Determina se il ranking di questa mano e' il minimo indicato
	 * o e' superiore al minimo indicato.
	 * 
	 * @param minimum il minimo ranking
	 */
	public boolean hasRankingFrom(Ranking minimum) {
		return false; // TODO
	}
}