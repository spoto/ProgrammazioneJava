package it.univr.doodle;

import java.util.HashMap;
import java.util.Map;

public class WeightedDoodle extends Doodle {
	private final Map<String, Double> weights = new HashMap<>();

	@Override
	public void available(String name, Slot... when) {
		available(name, 1.0, when);
	}

	@Override
	public void available(String name, Iterable<Slot> when) {
		available(name, 1.0, when);
	}

	public void available(String name, double weight, Slot... when) {
		super.available(name, when);
		weights.put(name, weight);
	}

	public void available(String name, double weight, Iterable<Slot> when) {
		super.available(name, when);
		weights.put(name, weight);
	}

	@Override
	protected double weightOf(String name) {
		return weights.get(name);
	}
}