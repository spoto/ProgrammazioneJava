package com.hotmoka.examples.swing.puzzle15.model;

import com.hotmoka.examples.swing.puzzle15.view.View;

public interface Model {
	// 5: I need your state information
	public int at(int x, int y);
	public Configuration getConfiguration();

	// 2: change your state
	public void setConfiguration(Configuration configuration);
	public void setView(View listener);
}



