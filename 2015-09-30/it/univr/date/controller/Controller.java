package it.univr.date.controller;

public interface Controller {
	void onIncreaseHours();
	void onDecreaseHours();
	void onIncreaseMinutes();
	void onDecreaseMinutes();
	void onIncreaseSeconds();
	void onDecreaseSeconds();
	void onResetTime();
}