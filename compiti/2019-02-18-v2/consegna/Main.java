import it.univr.library.AudioBook;
import it.univr.library.Book;
import it.univr.library.Genre;
import it.univr.library.PaperBook;

public class Main {

	public static void main(String[] args) {
		Book jj = new PaperBook("The joy of Java", "John Stack", 2018, Genre.COMPUTING, 557);
		Book cr = new AudioBook("Cappuccetto rosso", "Charles Perrault", 1697, Genre.FICTION, 13);
		Book ps = new AudioBook("I promessi sposi", "Alessandro Manzoni", 1840, Genre.FICTION, 1223);
		Book ps2 = new PaperBook("I promessi sposi", "Alessandro Manzoni", 1840, Genre.FICTION, 622);
		Book gl = new PaperBook("Sentieri in Lessinia", "Giovanni Gamba", 2015, Genre.GUIDE, 233);
		Book sv = new PaperBook("Gli Scala di Verona", "Roberta Guidi", 2012, Genre.HISTORY, 380);
		Book sv2 = new PaperBook("Gli Scala di Verona", "Roberta Guidi", 2012, Genre.HISTORY, 380);

		System.out.println("Ordinamento naturale:");
		// TODO: crea e poi stampa un catalogo con statistiche che contiene jj, cr, ps, ps2, gl, sv, sv2, ordinato
		// secondo il compareTo fra i libri

		System.out.println("Ordinamento per genere:");
		// TODO: crea e poi stampa un catalogo che contiene jj, cr, ps, ps2, gl, sv, sv2, ordinato
		// per genere e, a parita' di genere, secondo il compareTo fra i libri

		System.out.println("Ordinamento per supporto:");
		// TODO: crea e poi stampa un catalogo che contiene jj, cr, ps, ps2, gl, sv, sv2, ordinato
		// mettendo prima gli audio-libri e poi i libri cartacei. A parita' di tipo di libro
		// (cioe' fra due audio-libri o fra due libri cartacei) poi li mette in ordine
		// usando il compareTo fra i libri

		try {
			new PaperBook("Gli Scala di Verona", "Roberta Guidi", 2012, Genre.HISTORY, -380);
			System.out.println("legale");
		}
		catch (IllegalArgumentException e) {
			System.out.println("illegale");
		}

		try {
			new PaperBook("Gli Scala di Verona", null, 2012, Genre.HISTORY, 380);
			System.out.println("legale");
		}
		catch (IllegalArgumentException e) {
			System.out.println("illegale");
		}
	}
}
