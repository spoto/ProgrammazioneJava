import java.util.Comparator;

import it.univr.library.AudioBook;
import it.univr.library.Book;
import it.univr.library.Catalog;
import it.univr.library.CatalogWithStatistics;
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
		System.out.println(new CatalogWithStatistics(jj, cr, ps, ps2, gl, sv, sv2));

		Comparator<Book> byGenre = new Comparator<Book>() {

			@Override
			public int compare(Book book1, Book book2) {
				int diff = book1.getGenre().compareTo(book2.getGenre());
				if (diff != 0)
					return diff;
				else
					return book1.compareTo(book2);
			}
		};

		System.out.println("Ordinamento per genere:");
		System.out.println(new Catalog(byGenre, jj, cr, ps, ps2, gl, sv, sv2));

		Comparator<Book> bySupport = new Comparator<Book>() {

			@Override
			public int compare(Book book1, Book book2) {
				if (book1 instanceof AudioBook && book2 instanceof PaperBook)
					return -1;
				else if (book1 instanceof PaperBook && book2 instanceof AudioBook)
					return 1;
				else
					return book1.compareTo(book2);
			}
		};

		System.out.println("Ordinamento per supporto:");
		System.out.println(new Catalog(bySupport, jj, cr, ps, ps2, gl, sv, sv2));

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
