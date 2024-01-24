package it.univr.doodle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Doodle {
	private final Map<Person, Set<Slot>> availabilities = new HashMap<>();

	public void available(Person person, Slot... when) {
		Set<Slot> availability = availabilities.computeIfAbsent(person, _person -> new HashSet<>());
		for (Slot slot: when)
			availability.add(slot);
	}

	public void available(Person person, Iterable<Slot> when) {
		Set<Slot> availability = availabilities.computeIfAbsent(person, _person -> new HashSet<>());
		for (Slot slot: when)
			availability.add(slot);
	}

	public String toString() {
		String result = "";

		SortedSet<Slot> slots = new TreeSet<>();
		for (Set<Slot> set: availabilities.values())
			slots.addAll(set);

		int[] counters = new int[slots.size()];

		for (Slot slot: slots)
			result += slot.toString() + "\t";

		result += "\n";

		int max = 0;
		Slot best = null;

		// costruendo un TreeSet, abbiamo la garanzia
		// di enumerare le persone in ordine alfabetico
		for (Person person: new TreeSet<>(availabilities.keySet())) {
			int pos = 0;
			for (Slot slot: slots) {
				if (availabilities.get(person).contains(slot)) {
					result += "\tyes\t\t";
					counters[pos] += priority(person);
					if (counters[pos] > max) {
						max = counters[pos];
						best = slot;
					}
				}
				else
					result += "\tno\t\t";

				pos++;
			}

			result += person;
			result += "\n";
		}

		int pos = 0;
		for (Slot slot: slots)
			if (slot.equals(best))
				result += String.format("\t%d*\t\t", counters[pos++]);
			else
				result += String.format("\t%d\t\t", counters[pos++]);
		
		result += "\n";

		return result;
	}

	protected int priority(Person person) {
		return 1;
	}
}
