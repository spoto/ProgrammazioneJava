package com.hotmoka.examples.swing.puzzle15.controller;

public interface Controller {
	// 1: the user did something
	void onClick(int x, int y);
	void randomize();
	void giveHint();
}