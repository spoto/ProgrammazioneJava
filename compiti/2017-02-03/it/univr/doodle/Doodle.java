package it.univr.doodle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Doodle {
	private final Map<String, Set<Slot>> availabilities = new HashMap<>();

	public void available(String name, Slot... when) {
		Set<Slot> availability = new HashSet<>();
		for (Slot slot: when)
			availability.add(slot);

		availabilities.put(name, availability);
	}

	public void available(String name, Iterable<Slot> when) {
		Set<Slot> availability = new HashSet<>();
		for (Slot slot: when)
			availability.add(slot);

		availabilities.put(name, availability);
	}

	@Override
	public String toString() {
		String result = "";

		SortedSet<Slot> slots = new TreeSet<>();
		for (Set<Slot> set: availabilities.values())
			slots.addAll(set);

		double[] counters = new double[slots.size()];

		for (Slot slot: slots)
			result += slot.toString() + "\t";

		result += "\n";

		double max = 0.0;
		Slot best = null;

		// costruendo un TreeSet, abbiamo la garanzia
		// di enumerare i nomi in ordine alfabetico
		for (String name: new TreeSet<>(availabilities.keySet())) {
			int pos = 0;
			for (Slot slot: slots) {
				if (availabilities.get(name).contains(slot)) {
					result += "\tyes\t\t";
					counters[pos] += weightOf(name);
					if (counters[pos] > max) {
						max = counters[pos];
						best = slot;
					}
				}
				else
					result += "\tno\t\t";

				pos++;
			}

			result += name;
			result += "\n";
		}

		int pos = 0;
		for (Slot slot: slots)
			if (slot.equals(best))
				result += String.format("\t%.1f*\t\t", counters[pos++]);
			else
				result += String.format("\t%.1f\t\t", counters[pos++]);
		
		result += "\n";

		return result;
	}

	protected double weightOf(String name) {
		return 1.0;
	}
}
