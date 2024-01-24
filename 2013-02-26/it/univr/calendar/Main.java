package it.univr.calendar;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Calendar cal = new Calendar();
		cal.addEvent(new Time(2013, 2, 14, 21, 00), "uscire con la fidanzata");
		cal.addEvent(new Time(2013, 2, 26, 12, 45), "andare in mensa");
		cal.addEvent(new Time(2013, 2, 27, 9, 10), "andare a sciare");
		cal.addEvent(new Time(2013, 2, 26, 10, 00), "esame di Programmazione II");
		cal.addEvent(new Time(2013, 2, 26, 12, 45), "chiamare la mamma");
		cal.addEvent(new Time(2013, 3, 4, 8, 30), "ricominciare ad andare a lezione");

		System.out.println(cal);

		// ok, la fidanzata e' andata a sciare con qualcun altro:
		// collezioniamo tutti gli eventi che riguardano sciare o che hanno
		// a che fare con la ex-fidanzata....
		Set<Event> deleteThese = new HashSet<Event>();
		for (Event e: cal)
			if (e.toString().contains("sciare") || e.toString().contains("fidanzata"))
				deleteThese.add(e);

		// ....dopo rimuoviamoli!
		for (Event e: deleteThese)
			e.delete();
			
		System.out.println(cal);
	}
}
