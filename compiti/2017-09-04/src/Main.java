import it.univr.airbust.AirBustBookings;
import it.univr.bookings.BookingException;
import it.univr.bookings.Bookings;
import it.univr.bookings.Date;

public class Main {
	public static void main(String[] args) throws BookingException {
		Bookings bookings = new AirBustBookings(2018);
		Date Xmas = new Date(25, 12, 2018);
		Date d = new Date(5, 9, 2018);

		// prenotiamo 300 biglietti per Natale, a qualsiasi prezzo
		for (int count = 0; count < 300; count++)
			System.out.println("Booked Xmas flight at " + bookings.book(Xmas) + " dollars");

		try {
			// prenotiamo altri 800 biglietti
			for (int count = 0; count < 800; count++) {
				// per Natale, a qualsiasi prezzo
				bookings.book(Xmas);

				// per il 5/9/2018, purché costino meno di 120 dollari
				int quote = bookings.getQuoteFor(d);
				if (quote < 120)
					bookings.book(d, quote);
			}
		}
		catch (BookingException e) {
			System.out.println(e.getMessage());
			System.out.println(bookings);
		}
	}
}