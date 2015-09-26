package it.univr.date.model;

import it.univr.date.view.View;

public interface Model {
	void linkToView(View view);
	void set(int hours, int minutes, int seconds) throws IllegalArgumentException;
	int getHours();
	int getMinutes();
	int getSeconds();
}