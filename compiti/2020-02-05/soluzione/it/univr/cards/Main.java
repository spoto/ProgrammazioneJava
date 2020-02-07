package it.univr.cards;

import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		System.out.println("Ecco 4 esempi di \"full house\":");
		print(4, Deck::isFullHouse);
		
		System.out.println("\nEcco 6 esempi di \"four of a kind\":");
		print(6, Deck::isFourOfKind);

		System.out.println("\nEcco 8 esempi di \"straight\":");
		print(8, Deck::isStraight);

		System.out.println("\nEcco 5 esempi di \"straight flush\":");
		print(5, Deck::isStraightFlush);

		System.out.println("\nEcco 9 esempi di \"three of a kind\":");
		print(9, Deck::isThreeOfKind);

		System.out.println("\nEcco 5 esempi di \"flush\":");
		print(5, Deck::isFlush);

		System.out.println("\nEcco 10 esempi con ranking da \"flush\" in su:");
		print(10, deck -> deck.hasRankingFrom(Ranking.FLUSH));

		// tre assi, un cinque e un otto
		Card c1 = new Card(Value.ACE, Suit.HEARTS);
		Card c2 = new Card(Value.ACE, Suit.SPADES);
		Card c3 = new Card(Value.ACE, Suit.DIAMONDS);
		Card c4 = new Card(Value.FIVE, Suit.DIAMONDS);
		Card c5 = new Card(Value.EIGHT, Suit.HEARTS);
		Deck d1 = new Deck(c1, c2, c3, c4, c5); // tris di assi
		Deck d2 = new Deck(c1, c4, c5, c2, c3); // tris di assi
		Deck d3 = new Deck(c5, c4, c1, c3, c2); // tris di assi
		System.out.println("\nd1 e' un tris: " + d1.isThreeOfKind());
		System.out.println("d2 e' un tris: " + d2.isThreeOfKind());
		System.out.println("d3 e' un tris: " + d3.isThreeOfKind());
	}

	private static void print(int howMany, Predicate<Deck> when) {
		while (howMany > 0) {
			Deck deck = new Deck();
			if (when.test(deck)) {
				System.out.println(deck);
				howMany--;
			}
		}
	}
}