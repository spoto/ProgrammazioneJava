package it.univr.doodle;

public class WeightedDoodle extends Doodle {

	protected int priority(Person person) {
		return person.priority();
	}
}