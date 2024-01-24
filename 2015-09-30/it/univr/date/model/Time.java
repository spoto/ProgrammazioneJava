package it.univr.date.model;

import it.univr.date.view.View;

import java.util.HashSet;
import java.util.Set;

public class Time implements Model {

	private int hours, minutes, seconds;
	private final Set<View> views = new HashSet<>();

	@Override
	public void set(int hours, int minutes, int seconds) throws IllegalArgumentException {
		if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59)
			throw new IllegalAccessError("illegal time");

		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;

		for (View view: views)
			view.onTimeChanged(hours, minutes, seconds);
	}

	@Override
	public int getHours() {
		return hours;
	}

	@Override
	public int getMinutes() {
		return minutes;
	}

	@Override
	public int getSeconds() {
		return seconds;
	}

	@Override
	public void linkToView(View view) {
		views.add(view);
		view.onTimeChanged(hours, minutes, seconds);
	}
}