import it.univr.agenda.Date;
import it.univr.agenda.Event;
import it.univr.agenda.ItalianDate;
import it.univr.agenda.QuarterDate;
import it.univr.agenda.QuarterDate.Quarter;

public class Main {
	public static void main(String[] args) {
		checkEquals(new ItalianDate(4, 2, 2019), new QuarterDate(35, Quarter.Q1, 2019));
		checkEquals(new ItalianDate(4, 2, 2019), new QuarterDate(35, Quarter.Q2, 2019));
		checkEquals(new ItalianDate(29, 2, 2020), new QuarterDate(60, Quarter.Q1, 2020));
		checkEquals(new ItalianDate(31, 12, 2020), new QuarterDate(92, Quarter.Q4, 2020));

		try {
			new ItalianDate(29, 2, 2019);
			System.out.println("legale");
		}
		catch (IllegalArgumentException e) {
			System.out.println("illegale");
		}

		try {
			new ItalianDate(28, 2, 2019);
			System.out.println("legale");
		}
		catch (IllegalArgumentException e) {
			System.out.println("illegale");
		}

		checkOneDayAfter(new ItalianDate(28, 2, 2011));
		checkOneDayAfter(new ItalianDate(28, 2, 2012));
		checkOneDayAfter(new ItalianDate(31, 12, 2019));
		checkOneDayAfter(new QuarterDate(90, Quarter.Q1, 2019));

		Event event1 = new Event("Lezioni di Programmazione I", new ItalianDate(1, 10, 2018), 100);
		Event event2 = new Event("Lezioni di Ingegneria del Software", new QuarterDate(60, Quarter.Q1, 2019), 100);
		Event event3 = new Event("Christmas Vacation", new QuarterDate(83, Quarter.Q4, 2018), 12);
		checkOverlap(event1, event3);
		checkOverlap(event2, event3);
	}

	private static void checkOverlap(Event event1, Event event2) {
		System.out.println(event1 + " and " + event2 + " overlap: " + event1.overlapsWith(event2));
	}

	private static void checkOneDayAfter(Date date) {
		Date dayAfter = date.after(1); // dopo un giorno...
		System.out.println(date + " after one day becomes " + dayAfter);
	}

	private static void checkEquals(Date time1, Date time2) {
		System.out.println(time1 + " and " + time2 + " are equals? " + time1.equals(time2));
	}
}
