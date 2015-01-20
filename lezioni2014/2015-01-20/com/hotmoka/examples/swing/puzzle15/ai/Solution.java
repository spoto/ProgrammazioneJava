package com.hotmoka.examples.swing.puzzle15.ai;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.hotmoka.examples.swing.puzzle15.model.Configuration;
import com.hotmoka.examples.swing.puzzle15.moves.Rules;

public class Solution {

	private Steps steps;

	public Solution(Configuration configuration) {
		Map<Configuration, Originator> seen = new HashMap<>();
		PriorityQueue<Configuration> workingSet = new PriorityQueue<>(comparator);
		workingSet.offer(configuration);
		seen.put(configuration, new Originator(configuration, 0));

		do {
			Configuration current = workingSet.poll();
			Rules rules = new Rules(current);

			if (rules.isSolved()) {
				steps = mkSteps(current, seen, null);
				return;
			}

			for (Configuration next: rules.nextConfigurations()) {
				Originator oldWay = seen.get(next);
				int newSteps = seen.get(current).steps + 1;
				if (oldWay == null || oldWay.steps > newSteps) {
					workingSet.offer(next);
					seen.put(next, new Originator(current, newSteps));
				}
			}
		}
		while (!workingSet.isEmpty());
	}

	private Steps mkSteps(Configuration last, Map<Configuration, Originator> seen, Steps tail) {
		Originator originator = seen.get(last);
		if (originator.previous == last)
			return new Steps(last, tail);
		else
			return mkSteps(originator.previous, seen, new Steps(last, tail));
	}

	public Steps getSequenceOfSteps() {
		return steps;
	}

	private static Comparator<Configuration> comparator = new Comparator<Configuration>() {
	
		@Override
		public int compare(Configuration configuration1, Configuration configuration2) {
			return ordered(configuration2) * smallerFirst(configuration2) * firstRowsSolved(configuration2)
				- ordered(configuration1) * smallerFirst(configuration1) * firstRowsSolved(configuration1);
		}
	
		private int smallerFirst(Configuration configuration) {
			int weight = 0;
			int count = 0;
			int x = 0, y = 0;
	
			while (y < 4) {
				weight += configuration.at(x, y) * count++;
				if ((x = ++x % 4) == 0)
					y++;
			}
			
			return weight;
		}
	
		private int ordered(Configuration configuration) {
			int count = 0;
			int x = 0, y = 0;
			int before = configuration.at(0, 0);
			if (before == 0)
				before = 16;
	
			while (y < 4) {
				if ((x = ++x % 4) == 0)
					y++;
	
				if (y < 4) {
					int here = configuration.at(x, y);
					if (here == 0)
						here = 16;
					
					if (before == here - 1)
						count++;
	
					before = here;
				}
			}
			
			return count;
		}
	
		private int firstRowsSolved(Configuration configuration) {
			return hasFirst8OK(configuration) ? 4 : (hasFirst4OK(configuration) ? 2 : 1);
		}
	
		private boolean hasFirst4OK(Configuration configuration) {
			return configuration.at(0, 0) == 1 && configuration.at(1, 0) == 2 && configuration.at(2, 0) == 3 && configuration.at(3, 0) == 4;
		}
	
		private boolean hasFirst8OK(Configuration configuration) {
			return hasFirst4OK(configuration) &&
					configuration.at(0, 1) == 5 && configuration.at(1, 1) == 6 && configuration.at(2, 1) == 7 && configuration.at(3, 1) == 8;
		}
	};
}