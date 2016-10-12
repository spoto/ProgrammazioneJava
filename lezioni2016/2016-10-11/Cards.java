import java.util.Random;

public class Cards {
    public static void main(String[] args) {
	Random random = new Random();

	for (int counter = 1; counter <= 5; counter++) {
	    int num = random.nextInt(13) + 1;
	    int suit = random.nextInt(4) + 1; // da 1 a 4 inclusi

	    String card;

	    if (num <= 10)
		card = "" + num;
	    else if (num == 11)
		card = "J";
	    else if (num == 12)
		card = "Q";
	    else
		card = "K";

	    if (suit == 1)
		card = card + '\u2665';
	    else if (suit == 2)
		card = card + '\u2666';
	    else if (suit == 3)
		card = card + '\u2663';
	    else
		card = card + '\u2660';
	    
	    System.out.println(card);
	}
    }
}
