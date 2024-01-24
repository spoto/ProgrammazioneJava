package it.univr.calendar;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Calendar implements Iterable<Event> {

	private final SortedSet<Event> events = new TreeSet<Event>();

	public void addEvent(Time startingTime, String name) {
		events.add(new Event(startingTime, name) {

			@Override
			public void delete() {
				events.remove(this);
			}
		
		});
	}

	@Override
	public Iterator<Event> iterator() {
		// deleghiamo all'insieme degli eventi in calendario
		return events.iterator();
	}

	@Override
	public String toString() {
		String result = "";

		for (Event e: this)
			result += e + "\n";

		return result;
	}
}