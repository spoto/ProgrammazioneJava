import it.univr.cards.Card;
import it.univr.cards.Hand;

public class Main {

	public static void main(String[] args) {
		int howManyRoyalFlush = 0;
		int howManyStraightFlush = 0;
		int howManyStraight = 0;
		int howManyFlush = 0;
		int howManyFourOfAKind = 0;
		int howManyFullHouse = 0;
		int howManyThreeOfAKind = 0;
		int howManyTwoPairs = 0;
		int howManyOnePair = 0;
		int howManyHighCard = 0;

		final int TOTAL = 500000;
		for (int counter = 0; counter < TOTAL; counter++) {
			Hand h = new Hand(7);
			String category = h.category();
			System.out.printf("%20s : %s\n", h.toString(), category);

			switch (category) {
			case "royal flush": howManyRoyalFlush++; break;
			case "straight flush": howManyStraightFlush++; break;
			case "straight": howManyStraight++; break;
			case "flush": howManyFlush++; break;
			case "four of a kind": howManyFourOfAKind++; break;
			case "full house": howManyFullHouse++; break;
			case "three of a kind": howManyThreeOfAKind++; break;
			case "two pairs": howManyTwoPairs++; break;
			case "one pair": howManyOnePair++; break;
			case "high card": howManyHighCard++; break;
			}
		}

		System.out.println("\nstatistics:");
		System.out.printf("%s's: %d (%.4f%%)\n", "royal flush", howManyRoyalFlush, howManyRoyalFlush * 100.0 / TOTAL);
		System.out.printf("%s's: %d (%.4f%%)\n", "straight flush", howManyStraightFlush, howManyStraightFlush * 100.0 / TOTAL);
		System.out.printf("%s's: %d (%.4f%%)\n", "straight", howManyStraight, howManyStraight * 100.0 / TOTAL);
		System.out.printf("%s's: %d (%.4f%%)\n", "flush", howManyFlush, howManyFlush * 100.0 / TOTAL);
		System.out.printf("%s's: %d (%.4f%%)\n", "four of a kind", howManyFourOfAKind, howManyFourOfAKind * 100.0 / TOTAL);
		System.out.printf("%s's: %d (%.4f%%)\n", "full house", howManyFullHouse, howManyFullHouse * 100.0 / TOTAL);
		System.out.printf("%s's: %d (%.4f%%)\n", "three of a kind", howManyThreeOfAKind, howManyThreeOfAKind * 100.0 / TOTAL);
		System.out.printf("%s's: %d (%.4f%%)\n", "two pairs", howManyTwoPairs, howManyTwoPairs * 100.0 / TOTAL);
		System.out.printf("%s's: %d (%.4f%%)\n", "one pair", howManyOnePair, howManyOnePair * 100.0 / TOTAL);
		System.out.printf("%s's: %d (%.4f%%)\n", "high card", howManyHighCard, howManyHighCard * 100.0 / TOTAL);
	}
}
