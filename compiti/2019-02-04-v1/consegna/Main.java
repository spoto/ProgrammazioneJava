import it.univr.agenda.AmericanTime;
import it.univr.agenda.AmericanTime.Period;
import it.univr.agenda.Event;
import it.univr.agenda.ItalianTime;
import it.univr.agenda.Time;

public class Main {
	public static void main(String[] args) {
		checkEquals(new ItalianTime(12, 1, 5), new AmericanTime(12, 1, 5, Period.PM));
		checkEquals(new ItalianTime(0, 1, 5), new AmericanTime(12, 1, 5, Period.AM));
		checkEquals(new ItalianTime(23, 20, 35), new AmericanTime(11, 20, 35, Period.PM));
		checkEquals(new ItalianTime(0, 20, 35), new AmericanTime(12, 20, 35, Period.PM));
		
		try {
			new AmericanTime(13, 20, 35, Period.PM);
			System.out.println("legale");
		}
		catch (IllegalArgumentException e) {
			System.out.println("illegale");
		}

		try {
			new ItalianTime(13, 20, 35);
			System.out.println("legale");
		}
		catch (IllegalArgumentException e) {
			System.out.println("illegale");
		}

		checkOneMinuteAfter(new AmericanTime(11, 59, 30, Period.PM));
		checkOneMinuteAfter(new ItalianTime(23, 59, 30));
		
		Event event1 = new Event("shopping", new ItalianTime(15, 10, 0), 60);
		Event event2 = new Event("dentist", new ItalianTime(15, 0, 0), 60);
		Event event3 = new Event("exam", new AmericanTime(4, 0, 0, Period.PM), 120);
		checkOverlap(event1, event3);
		checkOverlap(event2, event3);
	}

	private static void checkOverlap(Event event1, Event event2) {
		System.out.println(event1 + " and " + event2 + " overlap: " + event1.overlapsWith(event2));
	}

	private static void checkOneMinuteAfter(Time time) {
		Time timeAfter = time.after(1); // dopo un minuto...
		System.out.println(time + " after one minute becomes " + timeAfter);
	}

	private static void checkEquals(Time time1, Time time2) {
		System.out.println(time1 + " and " + time2 + " are equals? " + time1.equals(time2));
	}
}
